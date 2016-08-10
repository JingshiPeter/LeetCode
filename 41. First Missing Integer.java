// https://leetcode.com/problems/first-missing-positive/

public class Solution {
    public int firstMissingPositive(int[] nums) {
    if(nums.length==0)  return 1;
        int max = Arrays.stream(nums).max().getAsInt();
        
        int[] bucket=new int[max+1];
        bucket[0]=1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>0){
            bucket[nums[i]]=1;
            }
        }

     for(int i=0;i<bucket.length;i++){
         if(bucket[i]==0) return i;
     }
        return max+1;
    }
}
