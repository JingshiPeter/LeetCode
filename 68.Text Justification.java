public class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> lines = new ArrayList<String>();
        int index = 0;// word index in words
        while(index < words.length){
            int count = words[index].length();
            int last = index + 1; // last word in current line
            while( last < words.length){
                if(count + 1 + words[last].length() > maxWidth) break;
                count += 1 + words[last++].length();
                // total length of words(including in between spaces) in current line : ex. "a word" count = 6
            }
            StringBuilder sb = new StringBuilder();
            int diff = last - index - 1;
            // if last line or number of words in the line is 1, left adjusted
            if(last == words.length || diff == 0){
                for(int i = index; i < last; i++){
                    if(i != last -1) sb.append(words[i] + " ");
                    else sb.append(words[i]);
                } 
                sb.append(spaces(maxWidth-sb.length()));
            }else{
                int spaces = (maxWidth - count) /diff;
                int r = (maxWidth - count) % diff;
                for (int i = index; i < last; i++) {
                    sb.append(words[i]);
                    if (i < last - 1) sb.append(spaces(spaces + 1 + ((i - index) < r ? 1 : 0)));
                }
            }
            lines.add(sb.toString());
            index = last;
            }
            return lines;
        }
        private String spaces(int n){
            if (n == 0) return "";
            else if (n == 1) return " ";
            else if (n == 2) return "  ";
            else if (n == 3) return "   ";
            else if (n == 4) return "    ";
            else if (n == 5) return "     ";
            else return "     "+spaces(n-5);
        }
}
