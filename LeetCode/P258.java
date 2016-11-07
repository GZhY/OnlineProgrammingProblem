/*
* @Author: GZhY
* @Time:   2016-11-07 23:33:44
* @Last Modified by:   GZhY
* @Last Modified time: 2016-11-07 23:35:30
*/

public class Solution {
    public int addDigits(int num) {
    	// Runtime: 2 ms
        return 1 + (num-1) % 9;
    }
}