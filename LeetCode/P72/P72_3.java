/*
* @Author: GZhY
* @Date:   2016-11-20 22:01:01
* @Last Modified by:   GZhY
* @Last Modified time: 2016-11-20 22:04:22
*/

public class Solution {

    private static int wdel = 1, wins = 1, wsub = 1;

    public int minDistance(String word1, String word2) {
        if (word1.length() > word2.length()) return minDistance(word2, word1);
        int[] dp = new int[word1.length() + 1];
        int upleft, temp;//upleft对应dp[i-1][j-1]
        for (int i = 0; i < dp.length; i++) dp[i] = i;
        for (int j = 1; j <= word2.length(); j++) {
            upleft = dp[0];
            dp[0] = j;
            for (int i = 1; i < dp.length; i++) {
                temp = dp[i];
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) dp[i] = upleft;
                //dp[i-1]对应dp[i-1][j], dp[i]对应dp[i][j-1]
                else dp[i] = Math.min(dp[i - 1] + wdel, Math.min(dp[i] + wins, upleft + wsub));
                upleft = temp;
            }
        }
        return dp[word1.length()];
    }
}