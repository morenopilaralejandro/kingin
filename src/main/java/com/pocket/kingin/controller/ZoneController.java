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

import com.pocket.kingin.domain.Zone;
import com.pocket.kingin.domain.ZoneService;

@Controller
public class ZoneController {
	@Autowired
	private ZoneService zoneService;

	@GetMapping({ "/{lang}/map", "/{lang}/map/" })
	public String zoneList(@PathVariable("lang") String lang, Model model) {
		Locale locale = LocaleContextHolder.getLocale();

		List<Zone> zones = zoneService.all();
		List<Zone> mainZones = new ArrayList<Zone>();

		for (Zone zone : zones) {
			if (zone.getZoneMain() == null) {
				mainZones.add(zone);
			}
		}

		model.addAttribute("lang", locale.getLanguage());
		model.addAttribute("url", "/map");
		model.addAttribute("zones", mainZones);
		return "zone-list";
	}

	@GetMapping({ "/{lang}/map/{code}", "/{lang}/map/{code}/" })
	public String zone(@PathVariable("lang") String lang, @PathVariable("code") String code, Model model) {
		Locale locale = LocaleContextHolder.getLocale();

		List<Zone> zones = zoneService.findByZoneCode(code);
		if (zones.isEmpty()) {
			return zoneList(lang, model);
		}
		List<Zone> subZones = zoneService.findByZoneMain(zones.get(0));

		model.addAttribute("lang", locale.getLanguage());
		model.addAttribute("url", "/map/" + code);
		model.addAttribute("zone", zones.get(0));
		model.addAttribute("subZones", subZones);
		return "zone";
	}

}
