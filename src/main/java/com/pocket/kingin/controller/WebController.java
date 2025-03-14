package com.pocket.kingin.controller;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

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
	
	@GetMapping({"/{lang}/", "/{lang}/index"})
	public String index(@PathVariable("lang") String lang, Model model) {
		Locale locale = LocaleContextHolder.getLocale();
		
		Map<String, String> urlMap = new HashMap<String, String>();
		urlMap.put("zukan", "zukan");
		urlMap.put("ability", "ability");
		
		urlMap.put("egggroup", "egg-group");
		urlMap.put("nature", "nature");
		
		urlMap.put("move", "move");
		urlMap.put("tutor", "move-tutor");
		
		urlMap.put("item", "item");
		urlMap.put("zone", "map");
		
		
		urlMap.put("gear", "gear");
		urlMap.put("walker", "walker");
		
		urlMap.put("judge", "judge");
		urlMap.put("source", "source");
		
		model.addAttribute("lang", locale.getLanguage());
		model.addAttribute("url", "/index");
		model.addAttribute("urlMap", urlMap);
		return "index";
	}

	@GetMapping("/{lang}/source")
	public String source(@PathVariable("lang") String lang, Model model) {
		Locale locale = LocaleContextHolder.getLocale();
		model.addAttribute("lang", locale.getLanguage());
		model.addAttribute("url", "/source");
		return "source";
	}
	
}
