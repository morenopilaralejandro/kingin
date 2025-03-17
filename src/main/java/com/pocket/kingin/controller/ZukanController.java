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

import com.pocket.kingin.domain.Item;
import com.pocket.kingin.domain.ItemService;
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
	
	@Autowired
	private ItemService itemService;
	
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
	        
		Pd pd = null;
		List<Pd> pds = pdService.findByPdCode(code);
		List<Pd> auxEvoPds = new ArrayList<Pd>();
		List<Pd> auxAlts = new ArrayList<Pd>();
		List<String> ids = new ArrayList<String>();
		List<Stat> auxStats = statService.all();
		Map<String, Item> auxEvoItems = new HashMap<String, Item>();
		boolean isIncense = false;
		if (pds.isEmpty()) {
			return zukanList(lang, model);
		}
		
		pd = pds.get(0);		
		
		/*evoItems*/
		/*Thunder Stone*/
		auxEvoItems.put("thunderstone", itemService.findByItemCode("thunderstone").get(0));
		/*Fire Stone*/
		auxEvoItems.put("firestone", itemService.findByItemCode("firestone").get(0));
		/*Water Stone*/
		auxEvoItems.put("waterstone", itemService.findByItemCode("waterstone").get(0));
		/*Leaf Stone*/
		auxEvoItems.put("leafstone", itemService.findByItemCode("leafstone").get(0));
		/*Sun Stone*/
		auxEvoItems.put("sunstone", itemService.findByItemCode("sunstone").get(0));
		/*Moon Stone*/
		auxEvoItems.put("moonstone", itemService.findByItemCode("moonstone").get(0));
		/*Shiny Stone*/
		auxEvoItems.put("shinystone", itemService.findByItemCode("shinystone").get(0));
		/*Dusk Stone*/
		auxEvoItems.put("duskstone", itemService.findByItemCode("duskstone").get(0));
		/*Dawn Stone*/
		auxEvoItems.put("dawnstone", itemService.findByItemCode("dawnstone").get(0));
		/*King's Rock*/
		auxEvoItems.put("kingsrock", itemService.findByItemCode("kingsrock").get(0));
		/*Metal Coat*/
		auxEvoItems.put("metalcoat", itemService.findByItemCode("metalcoat").get(0));
		/*Protector*/
		auxEvoItems.put("protector", itemService.findByItemCode("protector").get(0));
		/*Dragon Scale*/
		auxEvoItems.put("dragonscale", itemService.findByItemCode("dragonscale").get(0));
		/*Electirizer*/
		auxEvoItems.put("electirizer", itemService.findByItemCode("electirizer").get(0));
		/*Magmarizer*/
		auxEvoItems.put("magmarizer", itemService.findByItemCode("magmarizer").get(0));
		/*Up-Grade*/
		auxEvoItems.put("upgrade", itemService.findByItemCode("upgrade").get(0));
		/*Dubious Disc*/
		auxEvoItems.put("dubiousdisc", itemService.findByItemCode("dubiousdisc").get(0));
		/*Reaper Cloth*/
		auxEvoItems.put("reapercloth", itemService.findByItemCode("reapercloth").get(0));
		/*Deep Sea Tooth*/
		auxEvoItems.put("deepseatooth", itemService.findByItemCode("deepseatooth").get(0));
		/*Deep Sea Scale*/
		auxEvoItems.put("deepseascale", itemService.findByItemCode("deepseascale").get(0));
		/*Oval Stone*/
		auxEvoItems.put("ovalstone", itemService.findByItemCode("ovalstone").get(0));
		/*Razor Fang*/
		auxEvoItems.put("razorfang", itemService.findByItemCode("razorfang").get(0));
		/*Razor Claw*/
		auxEvoItems.put("razorclaw", itemService.findByItemCode("razorclaw").get(0));
		
		ids.add("details");
		if (!pd.getPdHoldItem().isEmpty()) {
			ids.add("items");	
		}
		if (!pd.getPdLinaEvoFam().isEmpty()) {
			ids.add("evolution");
			auxEvoPds = pdService.findByEvoFamId(pd.getPdLinaEvoFam().get(0).getEvoFam().getEvoFamId());
			for (Pd pare : auxEvoPds) {
				if (!pare.getPdBabyPd().isEmpty()) {
					isIncense = true;
				}
			}
		}
		if (isIncense) {
			ids.add("incense");
		}
		if (!pd.getAlts().isEmpty()) {
			ids.add("forms");
			auxAlts.add(pd);
			auxAlts.addAll(pd.getAlts());
		}
		if (!pd.getOris().isEmpty()) {
			ids.add("forms");
			auxAlts.add(pd.getOris().get(0));
			auxAlts.addAll(pd.getOris().get(0).getAlts());
		}
		
		model.addAttribute("lang", locale.getLanguage());
		model.addAttribute("url", "/zukan/" + code);
		model.addAttribute("pd", pds.get(0));
		model.addAttribute("ids", ids);
		model.addAttribute("auxEvoPds", auxEvoPds);
		model.addAttribute("auxStats", auxStats);
		model.addAttribute("auxEvoItems", auxEvoItems);
		model.addAttribute("isIncense", isIncense);
		model.addAttribute("auxAlts", auxAlts);
		
		return "zukan";
	}
	
}
