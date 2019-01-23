package it.hyperborea.vincenzo.mastermind.model;

public class Player {
	private String username;
	private int[] sequence;
	private Attempt lastAttempt;
	int numbersOfAttempt;
	int score;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int[] getSequence() {
		return sequence;
	}

	public void setSequence(int[] sequence) {
		this.sequence = sequence;
	}

	public Attempt getLastAttempt() {
		return lastAttempt;
	}

	public void setLastAttempt(Attempt lastAttempt) {
		this.lastAttempt = lastAttempt;
	}
	
	public int getNumbersOfAttempt() {
		return numbersOfAttempt;
	}

	public void setNumbersOfAttempt(int numbersOfAttempt) {
		this.numbersOfAttempt = numbersOfAttempt;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	@Override
	public boolean equals(Object obj) {
		Player player = (Player) obj;
		return username.equals(player.getUsername());
	}
	
	
}
