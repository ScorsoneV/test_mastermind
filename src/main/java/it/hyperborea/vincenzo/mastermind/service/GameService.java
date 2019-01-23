package it.hyperborea.vincenzo.mastermind.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.hyperborea.vincenzo.mastermind.model.Attempt;
import it.hyperborea.vincenzo.mastermind.model.Game;
import it.hyperborea.vincenzo.mastermind.model.Player;
import it.hyperborea.vincenzo.mastermind.utility.Loggable;



@Service("gameService")
public class GameService extends Loggable {
	
	@Autowired
	private PlayerService playerService;
		
	public Game initGame(String firstPlayer, String secondPlayer, int difficulty){
		Game game = new Game();
		
		logger.debug("Settaggio parametri partita");
		
		game.setDifficulty(difficulty);
		Player firstPlayerObj;
		
		if(!secondPlayer.equals("")){
			Player secondPlayerObj = playerService.initPlayer(secondPlayer, difficulty, false);
			firstPlayerObj = playerService.initPlayer(firstPlayer, difficulty, false);
			game.setFirstPlayer(firstPlayerObj);
			game.setSecondPlayer(secondPlayerObj);
			game.setMultiplayer(true);
		} else {
			firstPlayerObj = playerService.initPlayer(firstPlayer, difficulty, true);
			game.setFirstPlayer(firstPlayerObj);
			game.setSecondPlayer(null);
			game.setMultiplayer(false);
		}
		
		game.setCurrentPlayer(firstPlayerObj);
		
		logger.debug("Parametri partita settati");
		
		return game;
		
	}
	
	public void changeCurrentPlayer(Game game){
		Player first = game.getFirstPlayer();
		Player second = game.getSecondPlayer();
		Player current = game.getCurrentPlayer();
		
		if(first.equals(current)){
			game.setCurrentPlayer(second);
		}else{
			game.setCurrentPlayer(first);
		}
			
	}
	
	public int[] checkSequence(Game game, int[] sequenceToCheck){
		int n = game.getDifficulty();
		int[] currentSequence = game.getCurrentPlayer().getSequence();
		
		int correct = 0;
		int present = 0;
		
		for(int i=0; i<n; ++i){
			if(currentSequence[i]==sequenceToCheck[i])
				++correct;
			else if(contains(currentSequence, sequenceToCheck[i]))
				++present;
		}
		
		int[] result = {correct, present};
		
		return result;
		
	}
	
	private boolean contains(int[] list, int toCheck){
		for(int i=0; i<list.length; ++i){
			if(list[i]==toCheck)
				return true;
		}
		
		return false;
	}
	
	public void setResultAttemptCurrentPlayer(Game game, int[] resultAttempt){
		Player current = game.getCurrentPlayer();
		Attempt lastAttempt = current.getLastAttempt();
		int numberAttempts = current.getNumbersOfAttempt();
		
		if(lastAttempt==null){
			current.setLastAttempt(new Attempt());
			lastAttempt = current.getLastAttempt();
		}
		lastAttempt.setCorrect(resultAttempt[0]);
		lastAttempt.setPresent(resultAttempt[1]);
		current.setNumbersOfAttempt(++numberAttempts);
		
	}
	
	public boolean isEnd(Game game){
		return game.getDifficulty()==game.getCurrentPlayer().getLastAttempt().getCorrect();
	}
	
	public void calculateScore(Game game){
		int attempts = game.getCurrentPlayer().getNumbersOfAttempt();
		int difficulty = game.getDifficulty();
		int score=100*difficulty/attempts;
		
		game.getCurrentPlayer().setScore(score);
		 
	}
	
	public void setSequences(Game game, int[] first, int[] second){
		game.getFirstPlayer().setSequence(first);
		game.getSecondPlayer().setSequence(second);
	}
	
}
