/*
* @Author: GZhY
* @Date:   2016-10-21 15:42:54
* @Last Modified by:   GZhY
* @Last Modified time: 2016-10-21 15:55:09
*/

// Runtime: 7 ms
public class Solution {
	public List<String> fizzBuzz(int n) {
    	List<String> result = new ArrayList<>();
    	for (int i = 1; i <= n; i++) {
			String temp = "";
			if(i%3 == 0) temp += "Fizz";
			else if(i%5 != 0) temp += i;
			if(i%5 == 0) temp += "Buzz";
			result.add(temp);
		}
    	return result;
    }
}