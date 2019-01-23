package it.hyperborea.vincenzo.mastermind.test;

import java.util.Random;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import it.hyperborea.vincenzo.mastermind.model.Game;
import it.hyperborea.vincenzo.mastermind.service.GameService;
import it.hyperborea.vincenzo.mastermind.utility.Loggable;

public class GameTest extends Loggable{
	
	private GameService gameService;
	
	private Game game;
	
	@Before
	public void game(){
		gameService = new GameService();
		this.game=gameService.initGame("test1", "", 3);
	}
	
	@Test
	public void test(){
		
		for(int i=0; i<100000; ++i){
			int[] testSeq = {new Random().nextInt(10), new Random().nextInt(10), new Random().nextInt(10)};
			int[] testReq = gameService.checkSequence(game, testSeq);
			Assert.assertTrue(testReq[0]!=3);
		}
	}
}
