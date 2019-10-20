class Solution {
    
    class TrieNode{
        char ch;
        TrieNode[] children;
        boolean isFolder;
        public TrieNode(char ch){
            this.ch = ch;
            isFolder = false;
        }
    }
    
    public TrieNode root;
    public List<String> removeSubfolders(String[] folder) {
        root = new TrieNode(' ');
        for (int i = 0; i < folder.length; i++){
            TrieNode curr = root;
            for (char ch : folder[i].toCharArray()){
                if (curr.children == null)
                    curr.children = new TrieNode[256];
                if (curr.children[ch] == null)
                    curr.children[ch] = new TrieNode(ch);
                curr = curr.children[ch];
            }
            curr.isFolder = true;
        }
        List<String> res = new ArrayList<>();
        for (int i = 0; i < folder.length; i++){
            TrieNode curr = root;
            boolean isSubFolder = false;
            for (char ch : folder[i].toCharArray()){
                if (ch == '/' && curr.isFolder){
                    isSubFolder = true;
                    break;
                }
                curr = curr.children[ch];
            }
            if (!isSubFolder){
                res.add(folder[i]);
            }
        }
        return res;
    }
}