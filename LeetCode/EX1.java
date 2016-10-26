/*
* @Author: GZhY
* @Date:   2016-10-22 00:31:38
* @Last Modified by:   GZhY
* @Last Modified time: 2016-10-22 00:39:29
*/

import java.util.Scanner;

public class EX1 {

	public static void main(String[] args) {
		int num;
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			num = sc.nextInt();
			if((num&num-1) == 0) System.out.println(num + "是2的幂次方"); 
			else  System.out.println(num + "不是2的幂次方"); 
		}
	}

}
