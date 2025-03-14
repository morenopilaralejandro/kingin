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

import com.pocket.kingin.domain.GearCall;
import com.pocket.kingin.domain.GearCallService;

@Controller
public class GearController {
	@Autowired
	private GearCallService gearCallService;
	
	@GetMapping({"/{lang}/gear", "/{lang}/gear/"})
	public String nature(@PathVariable("lang") String lang, Model model) {
		Locale locale = LocaleContextHolder.getLocale();
	        
		List<GearCall> gearCalls = gearCallService.all();
		List<GearCall> gearCallItem = new ArrayList<GearCall>();
		List<GearCall> gearCallGym = new ArrayList<GearCall>();
		List<GearCall> gearCallOther = new ArrayList<GearCall>();
		
		for (GearCall gearCall : gearCalls) {
			if (gearCall.getGearCallId() < 13) {
				gearCallItem.add(gearCall);
			} else if (gearCall.getGearCallId() > 12 && gearCall.getGearCallId() < 29) {
				gearCallGym.add(gearCall);
			} else {
				gearCallOther.add(gearCall);
			}
		}
		
		model.addAttribute("lang", locale.getLanguage());
		model.addAttribute("url", "/gear");
		model.addAttribute("gearCallItem", gearCallItem);
		model.addAttribute("gearCallGym", gearCallGym);
		model.addAttribute("gearCallOther", gearCallOther);
		return "gear";
	}
	
}
