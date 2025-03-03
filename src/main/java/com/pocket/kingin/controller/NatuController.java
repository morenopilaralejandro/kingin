package com.pocket.kingin.controller;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.pocket.kingin.domain.Natu;
import com.pocket.kingin.domain.NatuService;

@Controller
public class NatuController {
	@Autowired
	private NatuService natuService;
	
	@GetMapping(value = "/{lang}/nature")
	public String nature(@PathVariable("lang") String lang, Model model) {
		Locale locale = LocaleContextHolder.getLocale();
	        
		List<Natu> natus = natuService.all();
		
		model.addAttribute("lang", locale.getLanguage());
		model.addAttribute("url", "/nature");
		model.addAttribute("natus", natus);
		return "nature";
	}
	
}
