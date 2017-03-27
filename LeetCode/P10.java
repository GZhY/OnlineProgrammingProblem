/*
* @Author: GZhY
* @Time:   2017-03-27 19:57:45
* @Last Modified by:   GZhY
* @Last Modified time: 2017-03-27 20:05:19
*/

public class Solution {

	// WA "ab" \n ".*c" 靠穷举所有的可能的做法不现实，WA多次，总忽略一些情况，不是正解。
    public boolean isMatch(String s, String p) {
        if("".equals(p)) return "".equals(s) ? true : false;
        if(s.length() > 0 && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.')){
            if(p.length()>=2 && p.charAt(1) == '*'){
               String temp = p.substring(0,2);
               p = p.replaceFirst("("+p.charAt(0)+"\\*)*", "");
               String p2 = p.replaceFirst(temp, "");
               String s2 = s.replaceFirst(temp, "");
               if(p.length()-p2.length() > s.length()-s2.length()) return false;
               return isMatch(s2, p2); 
            }
            return isMatch(s.substring(1), p.substring(1));
        }
        if(p.length()>=2 && p.charAt(1) == '*')
                return isMatch(s, p.substring(2));
        return false;
    }
}