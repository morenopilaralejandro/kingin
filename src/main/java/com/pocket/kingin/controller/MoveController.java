package com.pocket.kingin.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pocket.kingin.composite.PdLrnMove;
import com.pocket.kingin.domain.Item;
import com.pocket.kingin.domain.ItemService;
import com.pocket.kingin.domain.Move;
import com.pocket.kingin.domain.MoveCatService;
import com.pocket.kingin.domain.MoveService;
import com.pocket.kingin.domain.Pd;
import com.pocket.kingin.domain.TypeService;
import com.pocket.kingin.form.MoveSearch;

@Controller
public class MoveController {
	@Autowired
	private MoveService moveService;

	@Autowired
	private TypeService typeService;

	@Autowired
	private MoveCatService moveCatService;

	@Autowired
	private ItemService itemService;

	@RequestMapping(value = { "/{lang}/move", "/{lang}/move/" }, method = { RequestMethod.GET, RequestMethod.POST })
	public String moveListSubmit(@PathVariable("lang") String lang, Model model, MoveSearch moveSearch,
			BindingResult bindingResult) {
		Locale locale = LocaleContextHolder.getLocale();

		List<Move> moves = new ArrayList<Move>();
		
		if (!bindingResult.hasErrors()) {
			try {
				if (moveSearch.getType() > 0) {
					moveSearch.setTypeObj(typeService.one(moveSearch.getType()));
				}
				if (moveSearch.getMoveCat() > 0) {
					moveSearch.setMoveCatObj(moveCatService.one(moveSearch.getMoveCat()));
				}
				moves = moveService.findByCriteriaMoveSearch(moveSearch, lang);
			} catch (Exception e) {
				moves = moveService.all();
			}
		}
		
		model.addAttribute("lang", locale.getLanguage());
		model.addAttribute("url", "/move");
		model.addAttribute("moves", moves);
		model.addAttribute("types", typeService.all());
		model.addAttribute("moveCats", moveCatService.all());
		return "move-list";
	}

	@GetMapping({ "/{lang}/move/{code}", "/{lang}/move/{code}/" })
	public String ability(@PathVariable("lang") String lang, @PathVariable("code") String code, Model model) {
		Locale locale = LocaleContextHolder.getLocale();

		List<Move> moves = moveService.findByMoveCode(code);
		List<PdLrnMove> lvPdLrnMove = new ArrayList<PdLrnMove>();
		List<Pd> tmMoves = new ArrayList<Pd>();
		List<Pd> egMoves = new ArrayList<Pd>();
		List<Pd> tuMoves = new ArrayList<Pd>();
		List<Pd> tfMoves = new ArrayList<Pd>();
		List<Pd> pwMoves = new ArrayList<Pd>();
		List<Pd> spMoves = new ArrayList<Pd>();
		List<String> tocIds = new ArrayList<String>();
		Move move = null;
		List<Item> auxItems = new ArrayList<Item>();
		Item tm = null;

		if (moves.isEmpty()) {
			//return moveListDefault(lang, model, null);
		}

		move = moves.get(0);

		/* Bright Powder */
		auxItems.add(itemService.one(199L));
		/* King's Rock */
		auxItems.add(itemService.one(207L));

		if (!move.getItems().isEmpty()) {
			tm = move.getItems().get(0);
		}

		for (PdLrnMove plm : move.getPdLrnMove()) {
			switch (plm.getMoveLrn().getMoveLrnCode()) {
			case "lv": {
				lvPdLrnMove.add(plm);
				break;
			}
			case "tm": {
				tmMoves.add(plm.getPd());
				break;
			}
			
			case "eg": {
				egMoves.add(plm.getPd());
				break;
			}
			case "tu": {
				tuMoves.add(plm.getPd());
				break;
			}
			case "tf": {
				tfMoves.add(plm.getPd());
				break;
			}
			case "pw": {
				pwMoves.add(plm.getPd());
				break;
			}
			case "sp": {
				spMoves.add(plm.getPd());
				break;
			}
			}
		}
		
		if (!lvPdLrnMove.isEmpty()) {
			tocIds.add("lv");
		}
		if (!tmMoves.isEmpty()) {
			tocIds.add("tm");
		}
		if (!egMoves.isEmpty()) {
			tocIds.add("eg");
		}
		if (!tuMoves.isEmpty()) {
			tocIds.add("tu");
		}
		if (!tfMoves.isEmpty()) {
			tocIds.add("tf");
		}
		if (!pwMoves.isEmpty()) {
			tocIds.add("pw");
		}
		if (!spMoves.isEmpty()) {
			tocIds.add("sp");
		}
		
		model.addAttribute("lang", locale.getLanguage());
		model.addAttribute("url", "/move/" + code);
		model.addAttribute("moves", moves);
		model.addAttribute("move", moves.get(0));
		model.addAttribute("lvPdLrnMove", lvPdLrnMove);
		model.addAttribute("tmMoves", tmMoves);
		model.addAttribute("egMoves", egMoves);
		model.addAttribute("tuMoves", tuMoves);
		model.addAttribute("tfMoves", tfMoves);
		model.addAttribute("pwMoves", pwMoves);
		model.addAttribute("spMoves", spMoves);
		model.addAttribute("tocIds", tocIds);
		model.addAttribute("auxItems", auxItems);
		model.addAttribute("tm", tm);
	
		/*
		 * 
		 * 
		 * list-------------------------------
		 *
		 * -search
		 * hacer formulario en move fragments
		 * 
		 * -result
		 * tabla con la basico para reutilzar en move/{code} con efecto
		 * 
		 * 
		 * move/{code}-------------------------
		 * 
		 * -toc
		 * sub niveles 2.1, 2.3 dinamicos para how to learn
		 * 	  th:each="tocId : ${tocIds}"
				<th:block th:switch="${tocId}">
			    <li th:case="'lv'" th:id="${tocId}" th:text="#{move.learn.lv}">
			    </li>
			    </th:block>
		 * 
		 * -detalles
		 * tabla con la basico para reutilzar en move/{code} con efecto
		 * 
		 * otra tabla con hit(self), Method カテゴリ(wind, pinch) ,tm(none/nashi), priority, conctact(x), bright(x), king(x),  
		 * 
		 * -How to learn
		 *
		 *  lvPdLrnMove tmMoves el primero hay que sacar pd y getId().getLv()
		 * 	hacer una tabla especial 
		 * 		 * 	move.learn.lv.name=Name 名前
				move.learn.lv.lv=Lv
		 * 	los demas sacar pd container lg
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * */

		return "move";
	}

}
