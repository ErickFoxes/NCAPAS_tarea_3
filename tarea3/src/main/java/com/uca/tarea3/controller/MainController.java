package com.uca.tarea3.controller;


import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {
		
	@RequestMapping("/ingresar")
	public String index() {
		return "commons/ingresar";
	}
	@RequestMapping("/resultados")
	public ModelAndView ingresar(@RequestParam(value="nombres",required=false) String nombres, 
			@RequestParam(value="apellidos",required=false) String apellidos,
			@RequestParam(value="dia",required=false) int dia,
			@RequestParam(value="mes",required=false) int mes,
			@RequestParam(value="anno",required=false) int anno,
			@RequestParam(value="lugarNac",required=false) String lugarNac,
			@RequestParam(value="colegio",required=false) String colegio,
			@RequestParam(value="telFijo",required=false) String telFijo,
			@RequestParam(value="telCel",required=false) String telCel) {
		
		ModelAndView mav = new ModelAndView();
		List<String> lista = new ArrayList<>();
		boolean bandera = false; 
		
		
		if(nombres.length() <1 || nombres.length()>25 ) {
			lista.add("El campo Nombres no puede ser mayor a 25 caracteres");
			bandera = true; 
		}
		if(apellidos.length() <1 || apellidos.length()>25 ) {
			lista.add("El campo Apellidos no puede ser mayor a 25 caracteres");
			bandera = true;
		}
		if(anno < 2003) {
			lista.add("El campo Fecha de nacimiento no puede ser antes del 1 de enero del 2003");
			bandera = true;
		}
		if(lugarNac.length() <1 || lugarNac.length()>25 ) {
			lista.add("El campo Lugar de nacimiento no puede ser mayor a 25 caracteres");
			bandera = true;
		}
		if(colegio.length() <1 || colegio.length()>100 ) {
			lista.add("El campo colegio o institución no puede ser mayor a 100 caracteres");
			bandera = true;
		}
		if(telFijo.length() <8 || telFijo.length()>8 ) {
			lista.add("El campo telefono fijo tiene que tener 8 caracteres");
			bandera = true;
		}
		if(telCel.length() <8 || telCel.length()>8 ) {
			lista.add("El campo telefono movil tiene que tener 8 caracteres");
			bandera = true;
		}
		if(bandera) {
			mav.setViewName("commons/errores");
			mav.addObject("errores",lista);
		}else {
			mav.addObject("nombres", "nombres");
			mav.addObject("apellidos", "apellidos");
			mav.addObject("dia", "dia");
			mav.addObject("mes", "mes");
			mav.addObject("anno", "anno");
			mav.addObject("lugarNac", "lugarNac");
			mav.addObject("colegio", "colegio");
			mav.addObject("telFijo", "telFijo");
			mav.addObject("telCel", "telCel");
			mav.setViewName("commons/resultado");
		}
		return mav;
		
		 
	}
	
	@RequestMapping("/regresarIngresar")
	public String regresarIng() {
		return "commons/ingresar";
	}
	
}
