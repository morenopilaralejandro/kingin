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

import com.pocket.kingin.domain.Abil;
import com.pocket.kingin.domain.AbilService;
import com.pocket.kingin.domain.Move;
import com.pocket.kingin.domain.MoveService;

@Controller
public class AbilController {
	@Autowired
	private AbilService abilService;
	
	@Autowired
	private MoveService moveService;
	
	@GetMapping({"/{lang}/ability", "/{lang}/ability/"})
	public String abilityList(@PathVariable("lang") String lang, Model model) {
		Locale locale = LocaleContextHolder.getLocale();
	        
		List<Abil> abils = abilService.all();
			
		model.addAttribute("lang", locale.getLanguage());
		model.addAttribute("url", "/ability");
		model.addAttribute("abils", abils);
		return "ability-list";
	}
	
	@GetMapping({"/{lang}/ability/{code}", "/{lang}/ability/{code}/"})
	public String ability(@PathVariable("lang") String lang, @PathVariable("code") String code, Model model) {
		Locale locale = LocaleContextHolder.getLocale();
	        
		List<Abil> abils = abilService.findByAbilCode(code);
		List<Abil> auxAbils = new ArrayList<Abil>();
		List<Move> auxMoves = new ArrayList<Move>();
		if (abils.isEmpty()) {
			return abilityList(lang, model);
		}

		/*Role Play*/
		auxMoves.add(moveService.one(330L));
		/*Trace*/	
		auxAbils.add(abilService.one(114L));
		/*Skill Swap*/
		auxMoves.add(moveService.one(359L));
		/*Gastro Acid*/
		auxMoves.add(moveService.one(155L));
		/*Mold Breaker*/	
		auxAbils.add(abilService.one(57L));
		/*Transform*/
		auxMoves.add(moveService.one(432L));

		model.addAttribute("lang", locale.getLanguage());
		model.addAttribute("url", "/ability/" + code);
		model.addAttribute("abil", abils.get(0));
		model.addAttribute("auxAbils", auxAbils);
		model.addAttribute("auxMoves", auxMoves);
		return "ability";
	}
	
}
