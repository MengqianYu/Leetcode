class Solution {
    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        Map<String, Integer> substrings = new HashMap<>();
        int max = 0;
        for (int i = 0; i < s.length(); i++){
            StringBuilder sb = new StringBuilder();
            Set<Character> set = new HashSet<>();
            for (int j = 0; j < maxSize; j++){
                if (i+j >= s.length()) break;
                sb.append(s.charAt(i+j));
                set.add(s.charAt(i+j));
                if (set.size() > maxLetters) break;
                if (j+1 < minSize) continue;
                String temp = sb.toString();
                substrings.put(temp, substrings.getOrDefault(temp, 0)+1);
                max = Math.max(max, substrings.get(temp));
            }
        }
        return max;
    }
}