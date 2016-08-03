public class Solution {
    public int trap(int[] height) {
        if(height.length == 0) return 0;
        Stack<Integer> stack = new Stack<Integer>(); // store index, min stack of height[i]
        int vol = 0;
        for(int i = 0; i < height.length; i++) {
            if(stack.empty() || height[stack.peek()] > height[i]) stack.push(i);
            else {
                while(!stack.empty() && height[stack.peek()] < height[i]) {
                    int mid = stack.pop();
                    if(!stack.empty()) {
                        int j = stack.peek();
                        vol += (i - j - 1) * (Math.min(height[i], height[j]) - height[mid]);
                    }
                }
                stack.push(i);
            }
        }
        return vol;
    }
}
