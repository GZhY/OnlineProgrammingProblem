/*
* @Author: GZhY
* @Date:   2016-11-19 22:18:36
* @Last Modified by:   GZhY
* @Last Modified time: 2016-11-19 23:12:07
*/
// Runtime:7ms Beats 98.86%
public class Solution {

    private int[][] dp;
    private static int wdel = 1, wins = 1, wsub = 1;

    public int minDistance(String word1, String word2) {
        int i = word1.length(), j = word2.length();
        // These codes that line between 9 and 17 can be used to skip the common prefixes in linear time.
        int same = 0;
        for (int k = 0; k < i && k < j; k++) {
            if(word1.charAt(k) == word2.charAt(k)) same++;
            else break;
        }
        i -= same;
        j -= same;
        word1 = word1.substring(same);
        word2 = word2.substring(same);

        dp = new int[i][j];
        return minDistanceRecursion(word1, word2, i - 1, j - 1);
    }

    public int minDistanceRecursion(String word1, String word2, int i, int j) {
        if (j == -1) return wdel * (i + 1);
        if (i == -1) return wins * (j + 1);
        if (dp[i][j] != 0) return dp[i][j];
        if (word1.charAt(i) == word2.charAt(j)) return dp[i][j] = minDistanceRecursion(word1, word2, i - 1, j - 1);
        return dp[i][j] = Math.min(minDistanceRecursion(word1, word2, i - 1, j) + wdel, Math.min(minDistanceRecursion(word1, word2, i, j - 1) + wins, minDistanceRecursion(word1, word2, i - 1, j - 1) + wsub));
    }
}