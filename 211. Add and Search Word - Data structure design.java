// https://leetcode.com/problems/add-and-search-word-data-structure-design/
public class WordDictionary {
    
    public class TrieNode{
        public TrieNode[] children = new TrieNode[26];
        public String item = "";
    }
    
    private TrieNode root = new TrieNode();
    
    // Adds a word into the data structure.
    public void addWord(String word) {
        TrieNode node = root;
        for(char ch : word.toCharArray()){
            if(node.children[ch-'a'] == null) node.children[ch-'a'] = new TrieNode();
            node = node.children[ch-'a'];
        }
        node.item = word;
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        return match(word.toCharArray(), 0, root);
    }
    
    private boolean match(char[] chs, int k, TrieNode node){
        if( k == chs.length) return !node.item.equals("");
        if(chs[k] != '.') return node.children[chs[k] - 'a'] != null && match(chs, k+1, node.children[chs[k] - 'a']);
        else{
            for( int i = 0; i < 26; i++){
                if(node.children[i] != null && match(chs, k+1, node.children[i])) return true;
            }
        }
        return false;
    }
}
