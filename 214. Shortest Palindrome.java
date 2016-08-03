public class Solution {
    public String shortestPalindrome(String s){
        String reverse = new StringBuilder(s).reverse().toString();
        
        String test = s + "/" + reverse;
        
        int[] prefix = new int[test.length()];
        
        for(int i = 1; i< test.length(); i++){
            int j = prefix[i-1];
            while(j>0 && test.charAt(i) != test.charAt(j)) j = prefix[j-1];
            if(test.charAt(i) == test.charAt(j)) j++;
            prefix[i] = j;
        }
        
        return reverse.substring(0, s.length()-prefix[test.length()-1]) + s;
    }
}
