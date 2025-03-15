package com.pocket.kingin.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.pocket.kingin.domain.Abil;
import com.pocket.kingin.domain.AbilService;
import com.pocket.kingin.domain.Item;
import com.pocket.kingin.domain.ItemService;
import com.pocket.kingin.domain.Move;
import com.pocket.kingin.domain.MoveService;
import com.pocket.kingin.domain.Pd;
import com.pocket.kingin.domain.PdService;
import com.pocket.kingin.domain.Zone;
import com.pocket.kingin.domain.ZoneService;

@Controller
public class WebController {
	@Autowired
	private PdService pdService;
	
	@Autowired
	private AbilService abilService;
	
	@Autowired
	private MoveService moveService;
	
	@Autowired
	private ItemService itemService;
	
	@Autowired
	private ZoneService zoneService;
	
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
	
	@GetMapping("/{lang}/search")
	public String search(@PathVariable("lang") String lang, @RequestParam String q, Model model) {
		Locale locale = LocaleContextHolder.getLocale();
		
		List<Pd> pds = new ArrayList<Pd>();
		List<Abil> abils = new ArrayList<Abil>();
		List<Move> moves = new ArrayList<Move>();
		List<Item> items = new ArrayList<Item>();
		List<Zone> zones = new ArrayList<Zone>();
		boolean isEmptyRes = false; 
		
		if (q != null && !q.isEmpty() && q.length() < 36) {
			switch (lang) {
			case "ja": {
				pds = pdService.findByPdNameJaContainingIgnoreCase(q);
				abils = abilService.findByAbilNameJaContainingIgnoreCase(q);
				moves = moveService.findByMoveNameJaContainingIgnoreCase(q);
				items = itemService.findByItemNameJaContainingIgnoreCase(q);
				/* custom query */
				zones = zoneService.findByNameJa(q);
				break;
			}
			default:
				pds = pdService.findByPdNameEnContainingIgnoreCase(q);
				abils = abilService.findByAbilNameEnContainingIgnoreCase(q);
				moves = moveService.findByMoveNameEnContainingIgnoreCase(q);
				items = itemService.findByItemNameEnContainingIgnoreCase(q);
				/* custom query */
				zones = zoneService.findByNameEn(q);
				break;
			}
		} 
		if (pds.isEmpty() &&
				abils.isEmpty() &&
				moves.isEmpty() &&
				items.isEmpty() &&
				zones.isEmpty()) {
			isEmptyRes = true;
		}
		
		model.addAttribute("lang", locale.getLanguage());
		model.addAttribute("url", "/index");
		model.addAttribute("pds", pds);
		model.addAttribute("abils", abils);
		model.addAttribute("moves", moves);
		model.addAttribute("items", items);
		model.addAttribute("zones", zones);
		model.addAttribute("isEmptyRes", isEmptyRes);
		return "search";
	}
	
}
