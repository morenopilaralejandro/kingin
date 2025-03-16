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

import com.pocket.kingin.domain.Pd;
import com.pocket.kingin.domain.PdService;
import com.pocket.kingin.domain.Stat;
import com.pocket.kingin.domain.StatService;

@Controller
public class ZukanController {
	@Autowired
	private PdService pdService;
	
	@Autowired
	private StatService statService;
	
	@GetMapping({"/{lang}/zukan", "/{lang}/zukan/"})
	public String zukanList(@PathVariable("lang") String lang, Model model) {
		Locale locale = LocaleContextHolder.getLocale();
	        
		List<Pd> pds = pdService.all();
		List<Pd> zukanPds = new ArrayList<Pd>();
		for (Pd pd : pds) {
			if (pd.getOris().isEmpty()) {
				zukanPds.add(pd);
			}
		}
			
		model.addAttribute("lang", locale.getLanguage());
		model.addAttribute("url", "/zukan");
		model.addAttribute("zukanPds", zukanPds);
		return "zukan-list";
	}
	
	@GetMapping({"/{lang}/zukan/{code}", "/{lang}/zukan/{code}/"})
	public String zukan(@PathVariable("lang") String lang, @PathVariable("code") String code, Model model) {
		Locale locale = LocaleContextHolder.getLocale();
	        
		List<Pd> pds = pdService.findByPdCode(code);
		List<Stat> stats = statService.all();
		if (pds.isEmpty()) {
			return zukanList(lang, model);
		}

		model.addAttribute("lang", locale.getLanguage());
		model.addAttribute("url", "/zukan/" + code);
		model.addAttribute("pd", pds.get(0));
		model.addAttribute("stats", stats);
		return "zukan";
	}
	
}
