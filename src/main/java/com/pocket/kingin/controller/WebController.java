package com.pocket.kingin.controller;

import java.util.Locale;

import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebController {

	@RequestMapping({"/", "/index"})
	public String indexNoVar(Model model) {
		Locale locale = LocaleContextHolder.getLocale();
		return index(locale.getLanguage(), model);
	}
	
	@GetMapping({"/{lang}/", "/{lang}", "/{lang}/index"})
	public String index(@PathVariable("lang") String lang, Model model) {
		Locale locale = LocaleContextHolder.getLocale();
		
		model.addAttribute("lang", locale.getLanguage());
		return "/index";
	}
	
}
