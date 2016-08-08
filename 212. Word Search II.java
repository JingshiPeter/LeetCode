// https://leetcode.com/problems/word-search-ii/
public class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        TrieNode root = buildTrie(words);
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                dfs(board, i, j, root, res, "", new HashSet<Integer>());
            }
        }
        return res;
    }
    public void dfs(char[][] board, int i, int j, TrieNode p, List<String> res, String curr, HashSet<Integer> visiting){
        char c = board[i][j];
        int key = i*board[0].length+j;
        int k = c - 'a';
        if(visiting.contains(key) || p.next[k] == null) return;
        p = p.next[k];
        if(p.word){
            res.add(curr+c);
            p.word = false;// delete the word
        }
        visiting.add(key);
        if(i > 0) dfs(board, i-1, j, p, res,curr+c, visiting);
        if(j > 0) dfs(board, i, j-1, p, res,curr+c, visiting);
        if(i < board.length-1) dfs(board, i+1, j, p, res,curr+c, visiting);
        if(j < board[0].length-1) dfs(board, i, j+1, p, res,curr+c, visiting);
        visiting.remove(key);
        
    }
    
    public TrieNode buildTrie(String[] words){
        TrieNode root = new TrieNode();
        for(String w : words){
            TrieNode p = root;
            for(char c : w.toCharArray()){
                int i = c - 'a';
                if(p.next[i] == null) p.next[i] = new TrieNode();
                p = p.next[i];
            }
            p.word = true;
        }
        return root;
    }
    
    class TrieNode{
        TrieNode[] next = new TrieNode[26];
        boolean word;
    }
}
