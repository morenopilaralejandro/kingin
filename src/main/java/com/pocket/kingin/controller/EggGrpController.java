package com.pocket.kingin.controller;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.pocket.kingin.domain.EggGrp;
import com.pocket.kingin.domain.EggGrpService;

@Controller
public class EggGrpController {
	@Autowired
	private EggGrpService eggGrpService;
	
	@GetMapping({"/{lang}/egg-group", "/{lang}/egg-group/"})
	public String eggGroupList(@PathVariable("lang") String lang, Model model) {
		Locale locale = LocaleContextHolder.getLocale();
	        
		List<EggGrp> eggGrps = eggGrpService.all();
			
		model.addAttribute("lang", locale.getLanguage());
		model.addAttribute("url", "/egg-group");
		model.addAttribute("eggGrps", eggGrps);
		return "egg-group-list";
	}
	
	@GetMapping({"/{lang}/egg-group/{code}", "/{lang}/egg-group/{code}/"})
	public String eggGroup(@PathVariable("lang") String lang, @PathVariable("code") String code, Model model) {
		Locale locale = LocaleContextHolder.getLocale();
	        
		List<EggGrp> eggGrps = eggGrpService.findByEggGrpCode(code);
		if (eggGrps.isEmpty()) {
			return eggGroupList(lang, model);
		}
		
		model.addAttribute("lang", locale.getLanguage());
		model.addAttribute("url", "/egg-group/" + code);
		model.addAttribute("eggGrp", eggGrps.get(0));
		return "egg-group";
	}
	
}
