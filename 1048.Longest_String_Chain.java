class Solution {
    public int longestStrChain(String[] words) {
        Map<String, Integer> map = new HashMap<>();
        for (String word: words){
            map.put(word, 1);
        }
        if (words == null || words.length == 0) return 0;
        int max = 1;
        Arrays.sort(words, new Comparator<String>(){
            public int compare(String s1, String s2){
                return s2.length()-s1.length();
            }
        });
        for (String word: words){
            for (int i = 0; i < word.length(); i++){
                StringBuilder sb = new StringBuilder();
                sb.append(word.substring(0, i));
                sb.append(word.substring(i+1, word.length()));
                String s = sb.toString();
                if (map.containsKey(s)){
                    map.put(s, Math.max(map.get(s), map.get(word)+1));
                    max = Math.max(max, map.get(s));
                }
            }
        }
        return max;
    }
}