/*
* @Author: GZhY
* @Date:   2016-10-22 00:25:13
* @Last Modified by:   GZhY
* @Last Modified time: 2016-10-22 01:07:45
*/

// beats 4.88%, need to improve
public class java {
	public int singleNumber(int[] nums) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			if(map.containsKey(nums[i])) map.put(nums[i], map.get(nums[i])+1);
			else map.put(nums[i], 1);
		}
		for (Iterator<Integer> iterator = map.keySet().iterator(); iterator.hasNext();) {
			Integer key = iterator.next();
			if(map.get(key)==1) return key;
		}
		return 0;
	}
}