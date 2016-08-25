// https://leetcode.com/problems/factor-combinations/
public class Solution {
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        helper(res, new ArrayList<Integer>(), n, 2);
        return res;
    }
    public void helper(List<List<Integer>> res, List<Integer> item, int curr, int start){
        if(curr <= 1){
            if(item.size() > 1) res.add(new ArrayList<Integer>(item));
            return;
        }
        for(int i = start; i <= curr; i++){
            if(curr % i == 0){
                item.add(i);
                helper(res, item, curr/i, i);
                item.remove(item.size()-1);
            }
        }
    }
}
