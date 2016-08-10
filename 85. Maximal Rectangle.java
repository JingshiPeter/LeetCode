// https://leetcode.com/problems/maximal-rectangle/

public class Solution {
    public int maximalRectangle(char[][] matrix) {
        if((matrix == null)|| matrix.length == 0||matrix[0].length == 0) return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int[] height = new int[n];
        int res = 0;
        for(int i = 0; i < m; i++){
            updateHeight(matrix, height, i);
            res = Math.max(res, largestRectangleArea(height));
        }
        return res;
    }
    
    private void updateHeight(char[][] matrix, int[] height, int idx){
        for(int i = 0; i < matrix[0].length; i++){
            if(matrix[idx][i] == '1') height[i] += 1;
            else height[i] = 0;
        }
    }
    public int largestRectangleArea(int[] heights) {
        int len = heights.length;
        Stack<Integer> s = new Stack<Integer>();
        int max = 0;
        for(int i = 0; i <= len; i++){
            int h = (i == len ? 0 : heights[i]);
            if(s.isEmpty() || h >= heights[s.peek()]) s.push(i);
            else{
                int tp = s.pop();
                max = Math.max(max, heights[tp]*(s.isEmpty()? i : i - s.peek()-1));
                i--;
            }
        }
        return max;
    }
}
