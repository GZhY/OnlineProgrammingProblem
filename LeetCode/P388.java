/*
* @Author: GZhY
* @Time:   2016-10-28 12:22:44
* @Last Modified by:   GZhY
* @Last Modified time: 2016-10-28 12:28:02
*/

public class Solution {
	// Runtime:7ms Beats:23.28%
    public int lengthLongestPath(String input) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        hashMap.put(0, 0);
        int result = 0;
        for (String s : input.split("\n")) {
            int level = s.lastIndexOf("\t") + 1;
            int len = s.substring(level).length();
            if (s.contains(".")) result = Math.max(result, hashMap.get(level) + len);
            else hashMap.put(level + 1, hashMap.get(level) + len + 1);
        }
        return result;
    }
}