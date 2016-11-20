# 72. Edit Distance
##定义
> 编辑距离（Edit Distance），又称Levenshtein距离，是指两个字串之间，由一个转成另一个所需的最少编辑操作次数。许可的编辑操作包括将一个字符替换成另一个字符，插入一个字符，删除一个字符。一般来说，编辑距离越小，两个串的相似度越大。[百科]

例如：
1. kitten → sitten (替换k为s)
2. sitten → sittn (删除e)
3. sittin → sitting (插入g)

##解法
动态规划典型例子，动态规划方程式如下

$$
\begin{matrix} d_{ i0 } & =\sum _{ k=1 }^{ i } w_{ del }(b_{ k }), & for & 1\le i\le m \\ d_{ 0j } & =\sum _{ k=1 }^{ j } w_{ ins }(a_{ k }), & for & 1\le j\le n \\ d_{ ij } & =\begin{cases} d_{ i-1,j-1 } & { for }\; a_{ j }=b_{ i } \\ \min  \begin{cases} d_{ i-1,j }+w_{ del }(b_{ i }) \\ d_{ i,j-1 }+w_{ ins }(a_{ j }) \\ d_{ i-1,j-1 }+w_{ sub }(a_{ j },b_{ i }) \end{cases} & { for }\; a_{ j }_{ i } \end{cases} & for & 1\le i\le m,1\le j\le n \end{matrix}
$$


## 代码
### 递归解法
递归解法比较直观，代码中的省略公共前缀的小技巧是利用了
$$
d(uv, uw) = d(v, w)
$$

因为省略公共前缀是在线性时间内完成的，所以可以用此进行优化。

```java
public class Solution {

    private int[][] dp;
    // 每个操作的权重，可根据实际问题修改
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
```

### 非递归解法
因为编译器会对递归所用内存有所限制，所以递归算法对于较长字符串可能会无法运行。非递归算法建立在已知所需所有子问题的基础上，从底向上求解最终结果。
``` java
public class Solution {

    private int[][] dp;
    // 每个操作的权重，可根据实际问题修改
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
```

### 空间复杂度的优化
因为计算dp(i,j)的时候，我们只需知道dp(i-1, j), dp(i, j-1)和dp(i-1], j-1), 而不需要知道其他信息，因此空间复杂度可以降低到线性。但这样做法的代价就是只能得到最小编辑距离，而无法得到最小编辑序列。
``` java
public class Solution {
	// 每个操作的权重，可根据实际问题修改
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
```

##参考
1. [wikipedia](https://en.wikipedia.org/wiki/Edit_distance#cite_note-navarro-1)

2. [dreamxu](http://www.dreamxu.com/books/dsa/dp/edit-distance.html)

3. [百度百科](http://baike.baidu.com/link?url=BmM38FFihUUtVLaoYjN360x6w-O4E3rMhYKbBXtq9hhsqlAYJFM-wxLtriZ2nxNIy8kZIwl-brKCIdYmK5KL4JeWsfVJG8Bp9qkjLwKFnm43opEn4gZdDCmQcWazASJJ)

