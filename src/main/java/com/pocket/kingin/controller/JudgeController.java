package com.pocket.kingin.controller;

import java.util.Locale;

import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class JudgeController {
	
	@GetMapping({"/{lang}/judge", "/{lang}/judge/"})
	public String nature(@PathVariable("lang") String lang, Model model) {
		Locale locale = LocaleContextHolder.getLocale();
		
		model.addAttribute("lang", locale.getLanguage());
		model.addAttribute("url", "/judge");
		return "judge";
	}
	
}
