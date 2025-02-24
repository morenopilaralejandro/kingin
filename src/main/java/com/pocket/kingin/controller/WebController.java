package com.pocket.kingin.controller;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pocket.kingin.domain.Move;
import com.pocket.kingin.domain.MoveService;
import com.pocket.kingin.domain.Stat;
import com.pocket.kingin.domain.StatService;

@Controller
public class WebController {
	@Autowired
	private StatService statService;
	
	@Autowired
	private MoveService moveService;
	
	@RequestMapping(value = "/")
	public String index(Model model) {
		Locale locale = LocaleContextHolder.getLocale();
		
		List<Stat> all = statService.all();
		System.out.println("test1");
		for (Stat i : all) {
			System.out.println(i.toString());
		}
		System.out.println("test2");
		for (Stat i : all) {
			System.out.println(i.getInternatName().get(locale.getLanguage()));
		}
		/*
		System.out.println("test3");
		statService.insert(new Stat(7L, "new", "en", "ja"));
		System.out.println(statService.one(7L).toString());
		System.out.println("test4");
		statService.delete(7L);
		all = statService.all();
		for (Stat i : all) {
			System.out.println(i.toString());
		}
		*/
		
		System.out.println("test5");
		List<Move> all1 = moveService.all();
		System.out.println(all1.get(0).getMoveCauseEffs().toString());
		
		
		
		
		model.addAttribute("test", 1234);
		model.addAttribute("langCur", locale.getLanguage());
		return "/index";
	}
	
}
