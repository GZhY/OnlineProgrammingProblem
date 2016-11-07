/*
* @Author: GZhY
* @Date:   2016-11-08 00:11:10
* @Last Modified by:   GZhY
* @Last Modified time: 2016-11-08 00:30:53
*/

public class Solution {

	// Runtime:6ms Beats:86.84%
	public char findTheDifference(String s, String t) {
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        char ans = tArr[sArr.length];
        for(int i = 0; i < sArr.length; ++i)
            ans ^= sArr[i]^tArr[i];
        return ans;
    }

    // Runtime:9ms Beats:40.44%
    // public char findTheDifference(String s, String t) {
    //     char ans = t.charAt(t.length() - 1);
    //     for(int i = 0; i < s.length(); i++){
    //         ans ^= s.charAt(i) ^ t.charAt(i);
    //     }
    //     return ans;
    // }
}