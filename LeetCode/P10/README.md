# via [@jianchao.li.fighter](https://discuss.leetcode.com/topic/17852/9-lines-16ms-c-dp-solutions-with-explanations/25)
## Source text
This problem has a typical solution using Dynamic Programming. We define the state `P[i][j]` to be `true` if `s[0..i)` matches `p[0..j)` and `false` otherwise. Then the state equations are:
 
 1. `P[i][j] = P[i - 1][j - 1]`, if `p[j - 1] != '*' && (s[i - 1] == p[j - 1] || p[j - 1] == '.')`;
 2. `P[i][j] = P[i][j - 2]`, if `p[j - 1] == '*'` and the pattern repeats for `0` times;
 3. `P[i][j] = P[i - 1][j] && (s[i - 1] == p[j - 2] || p[j - 2] == '.')`, if `p[j - 1] == '*'` and the pattern repeats for at least `1` times.
 
Putting these together, we will have the following code.
``` C++
    class Solution {
    public:
        bool isMatch(string s, string p) {
            int m = s.length(), n = p.length(); 
            vector<vector<bool> > dp(m + 1, vector<bool> (n + 1, false));
            dp[0][0] = true;
            for (int i = 0; i <= m; i++)
                for (int j = 1; j <= n; j++)
                    if (p[j - 1] == '*')
                        dp[i][j] = dp[i][j - 2] || (i > 0 && (s[i - 1] == p[j - 2] || p[j - 2] == '.') && dp[i - 1][j]);
                    else dp[i][j] = i > 0 && dp[i - 1][j - 1] && (s[i - 1] == p[j - 1] || p[j - 1] == '.');
            return dp[m][n];
        }
    };
```
## Supplement
The codes will crash when we input this testcase: `"*" "*"`  
So, I gave the following code in java.  
``` java
public class Solution {
	public boolean isMatch(String s, String p) {
		if(s==null || p==null) return false;
		boolean[][] dp = new boolean[s.length()+1][p.length()+1];
		dp[0][0] = true;
		for(int i = 0; i <= s.length(); ++i)
			for(int j = 1; j <= p.length(); ++j){
				if (i>0 && (p.charAt(j-1)==s.charAt(i-1) || p.charAt(j-1)=='.'))
					dp[i][j] = dp[i-1][j-1];
				else if(j>1 && p.charAt(j-1) == '*')
					dp[i][j] = dp[i][j-2] || (i>0 && (s.charAt(i-1)==p.charAt(j-2)||p.charAt(j-2)=='.') && dp[i-1][j]);
			}
		return dp[s.length()][p.length()];
	}
}
```