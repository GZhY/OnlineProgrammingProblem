/*
* @Author: GZhY
* @Time:   2017-03-24 20:28:30
* @Last Modified by:   GZhY
* @Last Modified time: 2017-03-24 21:55:24
*/

//Runtime:99ms Beats:70.50%
public class Solution {
    private static Map<Character, Integer> map = new HashMap<Character, Integer>(){{
        put('I', 1);
        put('V', 5);
        put('X', 10);
        put('L', 50);
        put('C', 100);
        put('D', 500);
        put('M', 1000);
    }};
    public static int romanToInt(String s) {
        int sum = map.get(s.charAt(s.length()-1));
        for(int i=0; i<s.length()-1; ++i){
        	if(map.get(s.charAt(i)) < map.get(s.charAt(i+1)))
        		sum -= map.get(s.charAt(i));
        	else sum += map.get(s.charAt(i));
        }
        return sum;
    }
}