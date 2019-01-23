package it.hyperborea.vincenzo.mastermind.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.hyperborea.vincenzo.mastermind.model.Ranking;
import it.hyperborea.vincenzo.mastermind.service.RankingService;
import it.hyperborea.vincenzo.mastermind.utility.Loggable;

@Controller
public class RankingController extends Loggable{

	@Autowired
	private RankingService rankingService;
	
	@RequestMapping(value="/rank", method=RequestMethod.GET)
	public String rank(Model model){
		Ranking ranking;
		
		try {
			ranking = rankingService.getRankingObject();
		} catch (IOException e) {
			logger.error("Errore nella lettura della classifica", e);
			return "menu";
		}
		
		model.addAttribute("rank", ranking);
		return "rank";
	}
	
	@RequestMapping(value="/backToMenu", method=RequestMethod.GET)
	public String backToMenu(){
		return "menu";
	}
}
