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

import com.pocket.kingin.composite.PdLrnMove;
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
		boolean isFossil = false;
		boolean isLocation = true;
		List<Item> auxItemFoss = new ArrayList<Item>();
		List<PdLrnMove> lvPdLrnMove = new ArrayList<PdLrnMove>();
		List<PdLrnMove> tmPdLrnMove = new ArrayList<PdLrnMove>();
		List<PdLrnMove> egPdLrnMove = new ArrayList<PdLrnMove>();
		List<PdLrnMove> tuPdLrnMove = new ArrayList<PdLrnMove>();
		List<PdLrnMove> prPdLrnMove = new ArrayList<PdLrnMove>();
		List<PdLrnMove> tfPdLrnMove = new ArrayList<PdLrnMove>();
		List<PdLrnMove> pwPdLrnMove = new ArrayList<PdLrnMove>();
		List<PdLrnMove> spPdLrnMove = new ArrayList<PdLrnMove>();
		
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
		
		/*details*/
		ids.add("details");
		/*items*/
		if (!pd.getPdHoldItem().isEmpty()) {
			ids.add("items");	
		}
		/*evolution*/
		if (!pd.getPdLinaEvoFam().isEmpty()) {
			ids.add("evolution");
			auxEvoPds = pdService.findByEvoFamId(pd.getPdLinaEvoFam().get(0).getEvoFam().getEvoFamId());
			for (Pd auxEvoPd : auxEvoPds) {
				/*incense*/
				if (!auxEvoPd.getPdBabyPd().isEmpty()) {
					isIncense = true;
				}
				/*fossil*/
				if (!auxEvoPd.getItemFoss().isEmpty()) {
					ids.add("fossil");
					isFossil = true;
					auxItemFoss.addAll(auxEvoPd.getItemFoss());
				}
			}
		}
		/*incense*/
		if (isIncense) {
			ids.add("incense");
		}
		/*fossil*/
		if (!isFossil && !pd.getItemFoss().isEmpty()) {
			ids.add("fossil");
			isFossil = true;
			auxItemFoss.addAll(pd.getItemFoss());
		}
		/*forms*/
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
		/*location*/
		ids.add("location");
		if (pd.getPdSpawHgss().isEmpty() && 
				pd.getPdSpawSaf().isEmpty() &&
				pd.getPwCrseSpawPd().isEmpty() &&
				pd.getShopExchPd().isEmpty()) {
			isLocation = false;
		}
		/*moves*/
		ids.add("moves");
		for (PdLrnMove plm : pd.getPdLrnMove()) {
			switch (plm.getMoveLrn().getMoveLrnCode()) {
			case "lv": {
				lvPdLrnMove.add(plm);
				break;
			}
			case "tm": {
				tmPdLrnMove.add(plm);
				break;
			}
			
			case "eg": {
				egPdLrnMove.add(plm);
				break;
			}
			case "tu": {
				tuPdLrnMove.add(plm);
				break;
			}
			case "pr": {
				prPdLrnMove.add(plm);
				break;
			}
			case "tf": {
				tfPdLrnMove.add(plm);
				break;
			}
			case "pw": {
				pwPdLrnMove.add(plm);
				break;
			}
			case "sp": {
				spPdLrnMove.add(plm);
				break;
			}
			}
		}
		lvPdLrnMove.sort((o1, o2) -> o1.getId().getLv().compareTo(o2.getId().getLv()));
		tmPdLrnMove.sort((o1, o2) -> o1.getMove().getItems().get(0).getItemMachNum().compareTo(o2.getMove().getItems().get(0).getItemMachNum()));
		
		model.addAttribute("lang", locale.getLanguage());
		model.addAttribute("url", "/zukan/" + code);
		model.addAttribute("pd", pds.get(0));
		model.addAttribute("ids", ids);
		model.addAttribute("auxEvoPds", auxEvoPds);
		model.addAttribute("auxStats", auxStats);
		model.addAttribute("auxEvoItems", auxEvoItems);
		model.addAttribute("isIncense", isIncense);
		model.addAttribute("isFossil", isFossil);
		model.addAttribute("isLocation", isLocation);
		model.addAttribute("auxItemFoss", auxItemFoss);
		model.addAttribute("auxAlts", auxAlts);
		model.addAttribute("lvPdLrnMove", lvPdLrnMove);
		model.addAttribute("tmPdLrnMove", tmPdLrnMove);
		model.addAttribute("egPdLrnMove", egPdLrnMove);
		model.addAttribute("tuPdLrnMove", tuPdLrnMove);
		model.addAttribute("prPdLrnMove", prPdLrnMove);
		model.addAttribute("tfPdLrnMove", tfPdLrnMove);
		model.addAttribute("pwPdLrnMove", pwPdLrnMove);
		model.addAttribute("spPdLrnMove", spPdLrnMove);
		
		return "zukan";
	}
	
}
