// https://leetcode.com/problems/longest-valid-parentheses/

public class Solution {
    public int longestValidParentheses(String s) {
        int len = s.length(), max = 0;
        Stack<Integer> stack = new Stack<Integer>();
        for(int i = 0; i < len; i++){
            if(s.charAt(i) == '(') stack.push(i);
            else if( !stack.isEmpty() && s.charAt(stack.peek()) == '(') stack.pop();
            else stack.push(i);
        }
        if(stack.isEmpty()) return len;
        else{
            int i = len, j = 0;
            while(!stack.isEmpty()){
                j = stack.pop();
                max = Math.max(max, i-j-1);
                i = j;
            }
            max = Math.max(max, i);
        }
        return max;
    }
}
