// https://leetcode.com/problems/combination-sum-iii/
public class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(res, new ArrayList<Integer>(), k, 1, n);
        return res;
    }
    
    private void backtrack(List<List<Integer>> res, List<Integer> comb, int k, int s, int n){
        if(comb.size() == k){
            if(n == 0){
                res.add(new ArrayList<Integer>(comb));
            }
            return;
        }
        for(int i = s; i <= 9; i++){
            comb.add(i);
            backtrack(res, comb, k, i+1, n-i);
            comb.remove(comb.size()-1);
        }
    }
}
