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

import com.pocket.kingin.domain.Move;
import com.pocket.kingin.domain.MoveService;
import com.pocket.kingin.domain.Pd;
import com.pocket.kingin.domain.PdService;

@Controller
public class EggMoveController {
	@Autowired
	private PdService pdService;
	
	@Autowired
	private MoveService moveService;
	
	@GetMapping({"/{lang}/egg-move/{pdCode}/{moveCode}", "/{lang}/egg-move/{pdCode}/{moveCode}/"})
	public String eggMove(@PathVariable("lang") String lang, @PathVariable("pdCode") String pdCode, @PathVariable("moveCode") String moveCode, Model model) {
		Locale locale = LocaleContextHolder.getLocale();
	        
		List<Pd> pds = pdService.findByPdCode(pdCode);
		List<Pd> lvPds = new ArrayList<Pd>();
		List<Pd> egPds = new ArrayList<Pd>();
		List<Move> moves = moveService.findByMoveCode(moveCode);
		if (pds.isEmpty() || moves.isEmpty()) {
			WebController webController= new WebController();
			return webController.index(lang, model);
		}

		lvPds = pdService.findByEggMoveLv(pds.get(0).getPdId(), moves.get(0).getMoveId());
		egPds = pdService.findByEggMoveEg(pds.get(0).getPdId(), moves.get(0).getMoveId());

		model.addAttribute("lang", locale.getLanguage());
		model.addAttribute("url", "/egg-move/" + pdCode + "/" + moveCode);
		model.addAttribute("pd", pds.get(0));
		model.addAttribute("move", moves.get(0));
		model.addAttribute("lvPds", lvPds);
		model.addAttribute("egPds", egPds);
		return "egg-move";
	}
	
}
