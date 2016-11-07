/*
* @Author: GZhY
* @Date:   2016-11-08 00:11:10
* @Last Modified by:   GZhY
* @Last Modified time: 2016-11-08 00:11:47
*/

public class Solution {
    public char findTheDifference(String s, String t) {
    	// Runtime: 9 ms
        char ans = t.charAt(t.length() - 1);
        for(int i = 0; i < s.length(); i++){
            ans ^= s.charAt(i) ^ t.charAt(i);
        }
        return ans;
    }
}