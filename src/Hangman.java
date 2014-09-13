/* Project: Hangman
 * File: Hangman.java
 * Name: Amar Patel 
 * Date: 9/5/14
 * Description: This application simulates a game of Hangman. You are given 6 lives to guess the correct word. If the word
 * is not guess correctly in the number of lives given, the correct word will be displayed.
 */

import java.util.Arrays;
import java.util.Scanner;

public class Hangman {

	// instance variables
	private String wordToGuess;
	private int numberOfLives;
	private int livesLeft;
	private char[] guessedWord;

	// Getters
	public String wordToGuess() {

		return this.wordToGuess;
	}

	public int numberOfLives() {

		return this.numberOfLives;
	}

	// Setters
	public void setWordToGuess(String word) {

		this.wordToGuess = word.toLowerCase();
	}

	public void setNumberOfLives(int lives) {

		this.numberOfLives = lives;
	}

	// This method will find the letter in the word to guess. If no letter is
	// found, it returns false
	public boolean findLetterInWord(char letter, String wordToGuess) {

		for (int i = 0; i < wordToGuess.length(); i++) {

			if (wordToGuess.indexOf(letter) != -1) {
				int index = wordToGuess.indexOf(letter);
				guessedWord[index] = letter;
				return true;
			}
		}

		return false;

	}

	// This method initiates the game
	public void playGame() {

		guessedWord = new char[wordToGuess.length()];

		livesLeft = numberOfLives;

		Arrays.fill(guessedWord, '_');

		this.getGuess(wordToGuess);

	}

	// This method will get the letter to guess from the user
	public void getGuess(String wordToGuess) {

		while (livesLeft != 0) {

			for (char symbol : guessedWord) {
				System.out.print(symbol + " ");

			}

			System.out.printf(" (lives left: %d)%n%n", livesLeft);
			Scanner keyboard = new Scanner(System.in);
			System.out.print("Your guess: ");
			char letter = keyboard.next().charAt(0);
			letter = Character.toLowerCase(letter);

			boolean result = this.findLetterInWord(letter, wordToGuess);

			if (result == false) {
				livesLeft--;
			}

			if (livesLeft == 0) {
				System.out
						.print("The word was " + wordToGuess + " - try again");
			}

			if (!containsBlank(guessedWord)) {

				for (char symbol : guessedWord) {
					System.out.print(symbol + " ");

				}

				System.out.printf(" (lives left: %d)%n%n", livesLeft);
				System.out.println("Congratulations!");
				break;
			}
		}
	}

	// This method will return true if the word to be guessed has a blank; if
	// not it returns false
	public boolean containsBlank(char[] guessedWord) {

		boolean contains = false;
		for (char c : guessedWord) {
			if (c == '_') {
				contains = true;
			}
		}
		if (!contains) {
			contains = false;
		}
		return contains;
	}

	/**
	 * This is the main entry point of the application. It initializes the Hangman
	 * application. It also chooses the word to guess, and sets the number of lives
	 * before starting the game.
	 */
	public static void main(String[] args) {

		Hangman hm = new Hangman();
		hm.setWordToGuess("Headphones");
		hm.setNumberOfLives(10);

		hm.playGame();

	}
}
