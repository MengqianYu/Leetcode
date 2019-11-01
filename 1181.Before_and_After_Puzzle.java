class Solution {
    public List<String> beforeAndAfterPuzzles(String[] phrases) {
        Map<String, List<Integer>> firstword = new HashMap<>();
        Map<String, List<Integer>> lastword = new HashMap<>();
        for (int i = 0; i < phrases.length; i++){
            String[] ss = phrases[i].split(" ");
            if (!firstword.containsKey(ss[0])){
                firstword.put(ss[0], new ArrayList<Integer>());
            }
            firstword.get(ss[0]).add(i);
            int len = ss.length;
            if (!lastword.containsKey(ss[len-1])){
                lastword.put(ss[len-1], new ArrayList<Integer>());
            }
            lastword.get(ss[len-1]).add(i);
        }
        Set<String> set = new HashSet<>();
        List<String> res = new ArrayList<>();
        for (String s : firstword.keySet()){
            if (lastword.containsKey(s)){
                for (int first : firstword.get(s)){
                    for (int last : lastword.get(s)){
                        if (first == last) continue;
                        StringBuilder sb = new StringBuilder();
                        sb.append(phrases[last].substring(0, phrases[last].length()-s.length()));
                        sb.append(phrases[first]);
                        set.add(sb.toString());
                    }
                }
            }
        }
        for (String s : set){
            res.add(s);
        }
        Collections.sort(res);
        return res;
    }
}