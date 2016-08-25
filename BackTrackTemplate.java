public class Solution{
  public void backtrackTemplate(List<Character> candidates, boolean[] used, List<String> res, StringBuilder curr){
    //termination condition for backtracking
    if(curr.length == candidates.size()){
    
      //record result
      res.add(curr.toString());
      return;
    }
    
    // iterate through candidates
    for(int i = 0; i < candidates.size(); i++){
    
      // pruning conditions to eliminate duplicates
      if(i > 0 && candidates.get(i) == candidates.get(i-1) && !used[i-1]) continue;
    
      // anti-cycle condition
      if(!used[i]){
      
        used[i] = true;
        curr.append(candidates.get(i));
        
        // recursive call
        backtrack(candidates, used, res, curr);
        
        // backtrack
        used[i] = false;
        curr.setLength(curr.length()-1);
      }
    }
  }
}
