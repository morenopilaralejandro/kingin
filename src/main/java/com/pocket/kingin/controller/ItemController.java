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

import com.pocket.kingin.domain.Item;
import com.pocket.kingin.domain.ItemMach;
import com.pocket.kingin.domain.ItemMachService;
import com.pocket.kingin.domain.ItemPkt;
import com.pocket.kingin.domain.ItemPktService;
import com.pocket.kingin.domain.ItemService;

@Controller
public class ItemController {
	@Autowired
	private ItemService itemService;
	
	@Autowired
	private ItemMachService itemMatchService;
	
	@Autowired
	private ItemPktService itemPktService;
	
	@GetMapping({"/{lang}/item", "/{lang}/item/"})
	public String itemList(@PathVariable("lang") String lang, Model model) {
		Locale locale = LocaleContextHolder.getLocale();
	        
		List<ItemPkt> itemPkts = itemPktService.all();
			
		model.addAttribute("lang", locale.getLanguage());
		model.addAttribute("url", "/item");
		model.addAttribute("itemPkts", itemPkts);
		return "item-list";
	}

	@GetMapping({"/{lang}/pocket/{code}", "/{lang}/pocket/{code}/"})
	public String pocket(@PathVariable("lang") String lang, @PathVariable("code") String code, Model model) {
		Locale locale = LocaleContextHolder.getLocale();
	        
		List<ItemPkt> itemPkts = itemPktService.findByItemPktCode(code);
		List<Item> items = new ArrayList<Item>();
		List<ItemMach> itemMachs = new ArrayList<ItemMach>();
		if (itemPkts.isEmpty()) {
			return itemList(lang, model);
		}
		if (code.equals("ip-tmhm")) {
			itemMachs = itemMatchService.all();
		} else {
			items = itemService.findByItemPkt(itemPkts.get(0));	
		}

		model.addAttribute("lang", locale.getLanguage());
		model.addAttribute("url", "/pocket/" + code);
		model.addAttribute("itemPkt", itemPkts.get(0));
		model.addAttribute("items", items);
		model.addAttribute("itemMachs", itemMachs);
		return "item-pocket";
	}
	
	@GetMapping({"/{lang}/item/{code}", "/{lang}/item/{code}/"})
	public String item(@PathVariable("lang") String lang, @PathVariable("code") String code, Model model) {
		Locale locale = LocaleContextHolder.getLocale();
	        
		List<Item> items = itemService.findByItemCode(code);
		List<ItemMach> itemMachs = new ArrayList<ItemMach>();
		
		if (items.isEmpty()) {
			return itemList(lang, model);
		}
		if (items.get(0).getItemPkt().getItemPktCode().equals("ip-tmhm")) {
			itemMachs.add(itemMatchService.one(items.get(0).getItemId()));
		}

		model.addAttribute("lang", locale.getLanguage());
		model.addAttribute("url", "/item/" + code);
		model.addAttribute("item", items.get(0));
		model.addAttribute("itemMachs", itemMachs);
		return "item";
	}
	
}
