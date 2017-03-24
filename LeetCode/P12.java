/*
* @Author: GZhY
* @Time:   2017-03-24 20:00:44
* @Last Modified by:   GZhY
* @Last Modified time: 2017-03-24 20:37:07
*/

//Runtime:96ms Beats:48.86%, This is a trick that we can use static variables to optimize runtime.
public class Solution {
    
    private static String M[] = {"", "M", "MM", "MMM"};
    private static String C[] = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
    private static String X[] = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
    private static String I[] = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};

    public static String intToRoman(int num) {
        return M[num/1000] + C[(num%1000)/100]+ X[(num%100)/10] + I[num%10];
    }
}

//Runtime:102ms Beats:48.86%
public class Solution {
    public String intToRoman(int num) {
    String M[] = {"", "M", "MM", "MMM"};
    String C[] = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
    String X[] = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
    String I[] = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
    return M[num/1000] + C[(num%1000)/100]+ X[(num%100)/10] + I[num%10];
    }
}