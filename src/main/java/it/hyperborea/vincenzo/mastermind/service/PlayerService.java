package it.hyperborea.vincenzo.mastermind.service;

import java.util.Random;

import org.springframework.stereotype.Service;

import it.hyperborea.vincenzo.mastermind.model.Player;
import it.hyperborea.vincenzo.mastermind.utility.Loggable;

@Service("playerService")
public class PlayerService extends Loggable {
	
	public Player initPlayer(String username, int difficulty, boolean singlePlayer){
		Player player = new Player();
		
		int[] sequence = generateRandomSequence(difficulty);
		player.setUsername(username);
		if(singlePlayer)
			player.setSequence(sequence);
		player.setNumbersOfAttempt(0);
		player.setScore(0);
		
		return player;
	}
	
	private int[] generateRandomSequence(int n){
		int[] sequence = new int[n];
		
		for(int i=0; i<n; ++i)
			sequence[i]=new Random().nextInt(10);
		
		return sequence;
	}
	

	public String print(int[] arr){
		String s="";
		for(int i=0; i<arr.length-1; ++i)
			s+=arr[i]+"-";
		s+=arr[arr.length-1];
		
		return s;
		
	}

}
