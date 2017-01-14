/*
* @Author: GZhY
* @Time:   2017-01-14 19:51:00
* @Last Modified by:   GZhY
* @Last Modified time: 2017-01-14 22:36:41
*/

public class Solution {
	//Runtime:244ms Beats:1.8%
    public int islandPerimeter(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j]==1){
                    int[] cell = new int[]{i*n+j+1, i*n+j+1+n, -(j*m+i+1), -(j*m+i+1+m)};
                    for (int edge : cell) {
                        if(set.contains(edge)) set.remove(edge);
                        else set.add(edge);
                    }
                }
            }
        }
        return set.size();
    }
}