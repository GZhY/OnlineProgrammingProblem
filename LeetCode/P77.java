/*
* @Author: GZhY
* @Date:   2016-10-21 23:46:52
* @Last Modified by:   GZhY
* @Last Modified time: 2016-10-22 00:16:06
*/

// Runtime: 9 ms
public class Solution {
	public List<Integer> nextCombine(List<Integer> iList, int n, int k) {
		for (int i = k-1; i >= 0; --i) {
			int nextInt = iList.get(i) + 1;
			if (nextInt <= n && (!iList.contains(nextInt))){
				for (int j = i; j < k; ++j)
					iList.set(j, nextInt + j - i);
				break;
			}
		}
		return new ArrayList<Integer>(iList);
	}

	public List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> iList = new ArrayList<Integer>();
		for (int i = 1; i <= k; ++i)
			iList.add(i);
		result.add(new ArrayList<Integer>(iList));
		while (true) {
		    if(iList.get(0) == n-k+1) break;
			result.add(nextCombine(iList, n, k));
		}
		return result;

	}
}