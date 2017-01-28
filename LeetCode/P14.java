/*
* @Author: GZhY
* @Date:   2017-01-28 21:47:09
* @Last Modified by:   GZhY
* @Last Modified time: 2017-01-28 21:49:04
*/

// Runtime:15ms, Beats:17.50%
public class Solution {
    public String longestCommonPrefix(String str1, String str2) {
        int index = 0;
        for (int i = 0; i < str1.length() && i < str2.length(); i++) {
            if(str1.charAt(i) == str2.charAt(i)) index++;
            else break;
        }
        return str1.substring(0, index);
    }
    
    public String longestCommonPrefix(String[] strs) {
        String s = null;
        for (String str : strs) {
            if(s == null) s = str;
            else{
                s = longestCommonPrefix(s, str);
            }
        }
        return s == null ? "" : s;
    }
}