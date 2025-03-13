package com.pocket.kingin.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.pocket.kingin.composite.PwCrseLocItem;
import com.pocket.kingin.composite.PwCrseSpawPd;
import com.pocket.kingin.domain.PwCrse;
import com.pocket.kingin.domain.PwCrseService;

@Controller
public class PwController {
	@Autowired
	private PwCrseService pwCrseService;
	
	@GetMapping({"/{lang}/walker", "/{lang}/walker/"})
	public String walkerList(@PathVariable("lang") String lang, Model model) {
		Locale locale = LocaleContextHolder.getLocale();
	        
		List<PwCrse> pwCrses = pwCrseService.all();
		
		model.addAttribute("lang", locale.getLanguage());
		model.addAttribute("url", "/walker");
		model.addAttribute("pwCrses", pwCrses);
		return "walker-list";
	}
	
	@GetMapping({"/{lang}/walker/{code}", "/{lang}/walker/{code}/"})
	public String walker(@PathVariable("lang") String lang, @PathVariable("code") String code, Model model) {
		Locale locale = LocaleContextHolder.getLocale();
	        
		List<PwCrse> pwCrses = pwCrseService.findByPwCrseCode(code);
		List<PwCrseSpawPd> grpA = new ArrayList<PwCrseSpawPd>();
		List<PwCrseSpawPd> grpB = new ArrayList<PwCrseSpawPd>();
		List<PwCrseSpawPd> grpC = new ArrayList<PwCrseSpawPd>();
		List<PwCrseLocItem> itemsOrdered = new ArrayList<PwCrseLocItem>();
		if (pwCrses.isEmpty()) {
			return walkerList(lang, model);
		}
		for (PwCrseSpawPd wsp : pwCrses.get(0).getPwCrseSpawPd()) {
			switch (wsp.getPwGrp().getPwGrpCode()) {
			case "pw-grp-a": {
				grpA.add(wsp); 
				break;
			}
			case "pw-grp-b": {
				grpB.add(wsp); 
				break;
			}
			case "pw-grp-c": {
				grpC.add(wsp); 
				break;
			}
			}
		}
		itemsOrdered = pwCrses.get(0).getPwCrseLocItem();
		itemsOrdered.sort((o1, o2) -> o1.getId().getStep().compareTo(o2.getId().getStep()));

		model.addAttribute("lang", locale.getLanguage());
		model.addAttribute("url", "/walker/" + code);
		model.addAttribute("pwCrse", pwCrses.get(0));
		model.addAttribute("grpA", grpA);
		model.addAttribute("grpB", grpB);
		model.addAttribute("grpC", grpC);
		model.addAttribute("itemsOrdered", itemsOrdered);
		return "walker";
	}
	
}
