package com.hramn.algo.easy;

/**
 * <strong>3360. Stone Removal Game</strong>
 *
 * <p>
 * <strong>Difficulty:</strong> Easy
 * <br>
 * <strong>LeetCode:</strong>
 * <a href="https://leetcode.com/problems/stone-removal-game/">
 * 3360. Stone Removal Game</a>
 * <br>
 * <strong>Topic:</strong> math, simulation
 *
 * <hr>
 *
 * <p>
 * Alice and Bob are playing a game where they take turns removing stones from a
 * pile, with Alice going first.
 * <ul>
 * <li>Alice starts by removing exactly 10 stones on her first turn.</li>
 * <li>For each subsequent turn, each player removes exactly 1 fewer stone than
 * the previous opponent.</li>
 * </ul>
 *
 * <p>
 * The player who cannot make a move loses the game.
 *
 * <p>
 * Given a positive integer {@code n}, return {@code true} if Alice wins the
 * game and {@code false} otherwise.
 *
 * <p>
 * <strong>Example 1:</strong>
 * <p>
 * Input: {@code n = 12}
 * <p>
 * Output: {@code true}
 * <p>
 * Explanation:
 * <ul>
 * <li>Alice removes 10 stones on her first turn, leaving 2 stones for Bob.</li>
 * <li>Bob cannot remove 9 stones, so Alice wins.</li>
 * </ul>
 *
 * <p>
 * <strong>Example 2:</strong>
 * <p>
 * Input: {@code n = 1}
 * <p>
 * Output: {@code false}
 * <p>
 * Explanation:
 * <ul>
 * <li>Alice cannot remove 10 stones, so Alice loses.</li>
 * </ul>
 *
 * <p>
 * <strong>Constraints:</strong>
 * <ul>
 * <li>{@code 1 <= n <= 50}</li>
 * </ul>
 */
public class StoneRemovalGame {
	private StoneRemovalGame() {
		/* This utility class should not be instantiated */
	}

	static class Solution {
		public boolean canAliceWin(int n) {
			boolean aliceTurn = true;
			for (int stones = 10; n >= stones; n -= stones, stones--) {
				aliceTurn = !aliceTurn;
			}
			return !aliceTurn;
		}
	}
}
