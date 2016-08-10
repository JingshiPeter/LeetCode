// https://leetcode.com/problems/interleaving-string/
public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int len1 = s1.length();
        int len2 = s2.length();
        int len3 = s3.length();
        if(len1 + len2 != len3) return false;
        boolean[][] cache = new boolean[len2+1][len1+1];
        cache[0][0] = true;
        int m3 = 1;
        while(m3 <= len3){
            for(int m1 = Math.max(m3-len2, 0); m1 <= len1 && m1 <=m3; m1++){
                int m2 = m3 - m1;
                cache[m2][m1] = 
                    m1 > 0 && cache[m2][m1-1] && s3.charAt(m3-1) == s1.charAt(m1-1)||
                    m2 > 0 && cache[m2-1][m1]&& s3.charAt(m3-1) == s2.charAt(m2-1);
            }
            m3++;
        }
        return cache[len2][len1];
    }
}
