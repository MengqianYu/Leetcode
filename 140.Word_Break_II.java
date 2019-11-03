class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>();
        for (String word : wordDict){
            dict.add(word);
        }
        return dfs(new HashMap<String, List<String>>(), dict, s);
    }
    
    private List<String> dfs (Map<String, List<String>> map, Set<String> dict, String s){
        if (map.containsKey(s)) return map.get(s);
        List<String> res = new ArrayList<>();
        if (s.length() == 0){
            res.add("");
            return res;
        }
        for (String word : dict){
            if (s.startsWith(word)){
                List<String> temp = dfs(map, dict, s.substring(word.length(), s.length()));
                for (String str : temp){
                    StringBuilder sb = new StringBuilder();
                    sb.append(word);
                    if (str.length() != 0){
                        sb.append(" ").append(str);
                    }
                    res.add(sb.toString());
                }
            }
        }
        map.put(s, res);
        return res;
    }
}