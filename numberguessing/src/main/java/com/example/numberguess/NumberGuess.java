package com.example.numberguess;

import java.io.*;
import java.util.Random;

public class NumberGuess {

	private static final String READY = "READY";
	private static final String HIGHER = "HIGHER";
	private static final String LOWER = "LOWER";
	private static final String YES = "YES";
	private static final String END = "END";
	private int lower = 0;
	private int higher = 1000;
	static float magicNumber = 2;// will improve the guess based on input range
									// and increments

	public int getLower() {
		return lower;
	}

	public void setLower(int lower) {
		this.lower = lower;
	}

	public int getHigher() {
		return higher;
	}

	public void setHigher(int higher) {
		this.higher = higher;
	}

	public static void main(String[] args) {
		// Expecting the user to guess within this range Assumption
		NumberGuess ng = new NumberGuess();
		int number = new Random().nextInt(ng.higher);
		ng.startGame(number);
	}

	public void startGame(int number) {
		boolean started = false;
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		System.out
				.println("Take a guess between 0 - 1000 excluding both numbers and type ready to start playing");
		try {
			String input = null;
			while ((input = in.readLine()) != null) {
				if (started || READY.equalsIgnoreCase(input)) {
					if (!started) {
						started = true;
						System.out.println("Is the number " + number + " ?");
					}
					switch (input.toUpperCase()) {
					case END:
						System.out.println("See you again");
						return;
					case YES:
						System.out.println("I guessed Correct : " + number);
						return;
					case HIGHER:
						if (this.higher - this.lower == 2) {
							System.out.println("no more guesses");
							return;
						} else {
							number = this.increaseGuess(number);
							System.out
									.println("Is the number " + number + " ?");
						}
						break;
					case LOWER:
						if (this.higher - this.lower == 2) {
							System.out.println("no more guesses");
							return;
						} else {
							number = this.decreaseGuess(number);
							System.out
									.println("Is the number " + number + " ?");
						}
						break;
					default:
						System.out
								.println("Please enter only Higher, Lower, Yes or End I don't understand other words");
						break;
					}
				} else if (!started && END.equalsIgnoreCase(input)) {
					System.out.println("Bye");
					break;
				} else {
					System.out.println("Type READY or END");
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public int increaseGuess(int num) {
		lower = num;
		System.out.println("inc higher : " + higher + " lower : " + lower
				+ " num : " + num);
		int nextGuess = lower
				+ (int) (Math.ceil((higher - lower) / magicNumber));
		return nextGuess;
	}

	public int decreaseGuess(int num) {
		higher = num;
		System.out.println("dec higher : " + higher + " lower : " + lower
				+ " num : " + num);
		int nextGuess = higher
				- (int) (Math.ceil((higher - lower) / magicNumber));
		return nextGuess;
	}
}
