package it.hyperborea.vincenzo.mastermind.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import it.hyperborea.vincenzo.mastermind.model.Game;
import it.hyperborea.vincenzo.mastermind.service.GameService;
import it.hyperborea.vincenzo.mastermind.service.PlayerService;
import it.hyperborea.vincenzo.mastermind.service.RankingService;
import it.hyperborea.vincenzo.mastermind.utility.Loggable;


@Controller
public class GameController extends Loggable {
	
	@Autowired
	private GameService gameService;
	
	@Autowired
	private PlayerService playerService;
	
	@Autowired
	private RankingService rankingService;
		
	@RequestMapping(value="/check", method=RequestMethod.POST) 
	public String check(@SessionAttribute("game") Game game, @RequestParam("sequenceToCheck")int[] sequenceToCheck,Model model){
		logger.debug(playerService.print(game.getCurrentPlayer().getSequence()));
		logger.debug(playerService.print(sequenceToCheck));
		int[] resultAttempt = gameService.checkSequence(game, sequenceToCheck);
		logger.debug(playerService.print(resultAttempt));
		gameService.setResultAttemptCurrentPlayer(game, resultAttempt);
		if(gameService.isEnd(game)){
			gameService.calculateScore(game);
			try {
				rankingService.insertScore(game);
			} catch (IOException e) {
				logger.error("Errore nell'aggiornare la classifica", e);
				return "end";
			}
			model.addAttribute("win", true);
			return "end";
		}
		
		if(game.isMultiplayer())
			gameService.changeCurrentPlayer(game);
			
		return "game";
	}
	
	@RequestMapping(value="/surrender", method=RequestMethod.GET)
	public String surrender(Model model){
		model.addAttribute("win", false);
		return "end";
	}
	
	@RequestMapping(value="/back", method=RequestMethod.GET)
	public String back(@SessionAttribute("game") Game game){
		game = null;
		return "menu";
	}

}
