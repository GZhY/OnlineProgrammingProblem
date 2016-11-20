/*
* @Author: GZhY
* @Date:   2016-11-20 10:27:45
* @Last Modified by:   GZhY
* @Last Modified time: 2016-11-20 10:28:29
*/

public class Solution {

    private int[][] dp;
    private static int wdel = 1, wins = 1, wsub = 1;

    public int minDistance(String word1, String word2) {
        dp = new int[word1.length() + 1][word2.length() + 1];
        for (int i = 1; i <= word1.length(); i++) dp[i][0] = wdel * i;
        for (int j = 1; j <= word2.length(); j++) dp[0][j] = wins * j;
        for (int i = 1; i <= word1.length(); i++)
            for (int j = 1; j <= word2.length(); j++)
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) dp[i][j] = dp[i - 1][j - 1];
                else dp[i][j] = Math.min(dp[i - 1][j] + wdel, Math.min(dp[i][j - 1] + wins, dp[i - 1][j - 1] + wsub));
        return dp[word1.length()][word2.length()];
    }
}