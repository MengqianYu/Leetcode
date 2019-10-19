class Solution {
    public String frequencySort(String s) {
        int[] frequency = new int[256];
        int max = 0;
        for (char ch : s.toCharArray()){
            frequency[ch]++;
            max = Math.max(max, frequency[ch]);
        }
        Map<Integer, Set<Character>> map = new HashMap<>();
        for (char ch : s.toCharArray()){
            if (!map.containsKey(frequency[ch])){
                map.put(frequency[ch], new HashSet<Character>());
            }
            map.get(frequency[ch]).add(ch);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = max; i > 0; i--){
            if (!map.containsKey(i)){
                continue;
            }
            Set<Character> set = map.get(i);
            for (char ch : set){
                for (int j = 0; j < i; j++){
                    sb.append(ch);
                }
            }
        }
        return sb.toString();
    }
}