public class Solution {
    public int calculate(String s) {
        int len = s.length();
        Stack<Integer> stack = new Stack<Integer>();
        int num = 0;
        char sign = '+';
        for(int i = 0; i < len; i++){
            if(Character.isDigit(s.charAt(i))) num = num*10 + s.charAt(i)-'0';
            if((!Character.isDigit(s.charAt(i)) &&' '!=s.charAt(i)) || i==len-1){
                if(sign == '-') stack.push(-num);
                else if(sign == '+') stack.push(num);
                else if(sign == '*') stack.push(stack.pop()*num);
                else if(sign == '/') stack.push(stack.pop()/num);
                sign = s.charAt(i);
                num = 0;
            }
        }
        
        return stack.stream().mapToInt(Integer::intValue).sum();
    }
}
