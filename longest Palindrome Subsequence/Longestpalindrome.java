/*Given a String, find the longest palindromic subsequence.

NOTE: Subsequence of a given sequence is a sequence that can be derived from the given sequence by deleting some or no elements without changing the order of the remaining elements

Example 1:

Input:
S = "bbabcbcab"
Output: 7
Explanation: Subsequence "babcbab" is the
longest subsequence which is also a palindrome.


Example 2:

Input: 
S = "abcd"
Output: 1
Explanation: "a", "b", "c" and "d" are
palindromic and all have a length 1.

Your Task:
You don't need to read input or print anything. Your task is to complete the function longestPalinSubseq() which takes the string S as input and returns an integer denoting the length of the longest palindromic subsequence of S.

Expected Time Complexity: O(|S|*|S|).
Expected Auxiliary Space: O(|S|*|S|).

Constraints:
1 ≤ |S| ≤ 1000//  */// >> JAVA CODE: TABULATION <<//

class Solution {
    public int longestPalinSubseq(String S) {
        int n = S.length();
        int[][] dp = new int[n + 1][n + 1];
        String rev = new StringBuilder(S).reverse().toString();
        for (int i = n; i >= 0; i--) {
            for (int j = n; j >= 0; j--) {
                if (i == n || j == n)
                    dp[i][j] = 0;
                else if (S.charAt(i) == rev.charAt(j))
                    dp[i][j] = 1 + dp[i + 1][j + 1];
                else
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j + 1]);
            }
        }

        return dp[0][0];
    }
}