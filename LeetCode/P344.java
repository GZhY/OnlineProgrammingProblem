/*
* @Author: GZhY
* @Date:   2016-10-21 15:16:06
* @Last Modified by:   GZhY
* @Last Modified time: 2016-10-21 15:37:05
*/

// Runtime: 5 ms
public class Solution {
	public String reverseString(String s) {
		StringBuilder sb = new StringBuilder();
		for (int i = s.length() - 1; i >= 0; --i) {
			sb.append(s.charAt(i));
		}
		return sb.toString();
	}
}