package com.hramn.algo;
/**
 * 3307. Find the K-th Character in String Game II
 * https://leetcode.com/problems/find-the-k-th-character-in-string-game-ii/description
 * 
 * Alice and Bob are playing a game. Initially, Alice has a string word = "a".
 * 
 * You are given a positive integer k. You are also given an integer array 
 * operations, where operations[i] represents the type of the ith operation.
 * 
 * Now Bob will ask Alice to perform all operations in sequence:
 * - If operations[i] == 0, append a copy of word to itself.
 * - If operations[i] == 1, generate a new string by changing each character in 
 *   word to its next character in the English alphabet, and append it to 
 *   the original word. For example, performing the operation on "c" generates 
 *   "cd" and performing the operation on "zb" generates "zbac".
 * 
 * Return the value of the kth character in word after performing all 
 * the operations.
 * 
 * Note that the character 'z' can be changed to 'a' in the second type of 
 * operation.
 * 
 * Example 1:
 * Input: k = 5, operations = [0,0,0]
 * Output: "a"
 * Explanation:
 * Initially, word == "a". Alice performs the three operations as follows:
 * - Appends "a" to "a", word becomes "aa".
 * - Appends "aa" to "aa", word becomes "aaaa".
 * - Appends "aaaa" to "aaaa", word becomes "aaaaaaaa".
 * 
 * Example 2:
 * Input: k = 10, operations = [0,1,0,1]
 * Output: "b"
 * Explanation:
 * Initially, word == "a". Alice performs the four operations as follows:
 * - Appends "a" to "a", word becomes "aa".
 * - Appends "bb" to "aa", word becomes "aabb".
 * - Appends "aabb" to "aabb", word becomes "aabbaabb".
 * - Appends "bbccbbcc" to "aabbaabb", word becomes "aabbaabbbbccbbcc".
 * 
 * Constraints:
 * 1 <= k <= 10^14
 * 1 <= operations.length <= 100
 * operations[i] is either 0 or 1.
 * The input is generated such that word has at least k characters after all 
 * operations.
 * 
 * TAG: 20250704
 * TAG: hard
 */
public class FindKthCharacterInStringGameII {
class Solution {
    public char kthCharacter(long k, int[] operations) {
        long[][] pos = new long[100][2];
        int index = 1;
        pos[0][0] = 1;
        pos[0][1] = 1;
        for (; pos[index-1][0] < k; index++) {
            pos[index][0] = pos[index-1][0] * 2;
        }
        pos[index][1] = k;
        for (int i = index-1; i >= 1; i--) {
            if (pos[i+1][1] > pos[i][0]) {
                pos[i][1] = pos[i][0] - (pos[i+1][0] - pos[i+1][1]);
            } else {
                pos[i][1] = pos[i+1][1];
            }
        }
        char ch = 'a';
        for (int i = 0; i < index; i++) {
            if (pos[i+1][1] > pos[i][0]) {
                if (operations[i] == 1) {
                    ch = ch - 'a' < 25 ? (char)(ch+1) : 'a';
                }
            }
        }
        return ch;
    }
}
	class Solution2 {
		public char kthCharacter(long k, int[] operations) {
			if (k == 1) return 'a';
			int n = operations.length;
			int index = 0;
			long count = 1;
			while (count < k && index < n) {
				count *= 2;
				index++;
			}

			long[] pos = new long[index+1];
			pos[index-1] = k;
			for (int i = index-2; i >= 0; i--) {
				long half = count / 2;
				if (half - pos[i+1] >= 0) {
					pos[i] = pos[i+1];
				} else {
					pos[i] = half - (count - pos[i+1]);
				}
				count = half;
			}

			int ch = 0;
			long p = 1;
			for (int i = 0; i < index; i++) {
				if (p != pos[i] && operations[i] == 1) {
					ch = (ch + 1) % 26;
				}
				p = pos[i];
			}
			return (char)('a' + ch) ;
		}
	}
}
