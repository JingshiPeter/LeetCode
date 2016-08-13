// https://leetcode.com/problems/number-of-islands/

public class Solution {
    public int numIslands(char[][] grid) {
        int res = 0;
        if(grid.length == 0) return res;
        
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if (grid[i][j] == '1'){explore(grid, i, j); res++;}
            }
        }
        return res;
    }
    
    public void explore(char[][] grid, int i, int j){
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) return;
        if(grid[i][j] != '1') return;
        grid[i][j] = '2';
        explore(grid,i+1,j);
        explore(grid,i-1,j);
        explore(grid,i,j-1);
        explore(grid,i,j+1);
    }
}
