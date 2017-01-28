/*
* @Author: GZhY
* @Date:   2017-01-28 21:47:09
* @Last Modified by:   GZhY
* @Last Modified time: 2017-01-28 22:16:50
*/


public class Solution {

	// Runtime:13ms, Beats:35.58%
	public String longestCommonPrefix(String[] strs) {
    	if (strs == null || strs.length == 0) return "";
    	Arrays.sort(strs);
    	String a = strs[0], b = strs[strs.length - 1];
        while (b.indexOf(a) != 0)
            a = a.substring(0, a.length() - 1);
        return a;
    }

	// // Runtime:9ms, Beats:93.59%
	// public String longestCommonPrefix(String[] strs) {
 //        if (strs == null || strs.length == 0) return "";
 //        String pre = strs[0];
 //        for (int i = 1; i < strs.length; i++)
 //            while (strs[i].indexOf(pre) != 0)
 //                pre = pre.substring(0, pre.length() - 1);
 //        return pre;
 //    }

	// // Runtime:15ms, Beats:17.50%
 //    public String longestCommonPrefix(String str1, String str2) {
 //        int index = 0;
 //        for (int i = 0; i < str1.length() && i < str2.length(); i++) {
 //            if(str1.charAt(i) == str2.charAt(i)) index++;
 //            else break;
 //        }
 //        return str1.substring(0, index);
 //    }
    
 //    public String longestCommonPrefix(String[] strs) {
 //        String s = null;
 //        for (String str : strs) {
 //            if(s == null) s = str;
 //            else{
 //                s = longestCommonPrefix(s, str);
 //            }
 //        }
 //        return s == null ? "" : s;
 //    }
}