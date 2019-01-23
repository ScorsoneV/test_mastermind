package it.hyperborea.vincenzo.mastermind.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import it.hyperborea.vincenzo.mastermind.model.Game;
import it.hyperborea.vincenzo.mastermind.service.GameService;
import it.hyperborea.vincenzo.mastermind.service.PlayerService;
import it.hyperborea.vincenzo.mastermind.utility.Loggable;

@Controller
@SessionAttributes("game")
public class HomeController extends Loggable{
    
	@Autowired
	private GameService gameService;
	
	@Autowired
	private PlayerService playerService;
	
	@RequestMapping(value="/", method=RequestMethod.GET) 
    public String home(){
        return "menu"; 
    } 
	
	@RequestMapping(value="/start", method=RequestMethod.POST)
	public String start(@RequestParam("firstPlayer")String firstPlayer, @RequestParam("secondPlayer")String secondPlayer, @RequestParam("difficulty")int difficulty, Model model){
		Game game = gameService.initGame(firstPlayer, secondPlayer, difficulty);
		model.addAttribute("game", game);
		
		if(!game.isMultiplayer()){
			logger.debug(playerService.print(game.getCurrentPlayer().getSequence()));
			return "game";
		}else{
			return "multiplayer";
		}
	}
	
	@RequestMapping(value="/startMultiplayer", method=RequestMethod.POST)
	public String startMultiplayer(@RequestParam("sequenceFirstPlayer")int[] firstSequence, @RequestParam("sequenceSecondPlayer")int[] secondSequence, @SessionAttribute("game")Game game){
		gameService.setSequences(game, firstSequence, secondSequence);
		return "game";
	}
	
	
	
}
