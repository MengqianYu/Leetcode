class Solution {
    int max;
    public int maxLength(List<String> arr) {
        max = 0;
        dfs(arr, 0, new HashSet<Character>());
        return max;
    }
    
    public void dfs(List<String> arr, int index, Set<Character> set){
        max = Math.max(max, set.size());
        if (index >= arr.size()) return;
        dfs(arr, index+1, set);
        String s = arr.get(index);
        for (int i = 0; i < s.length(); i++){
            if (set.contains(s.charAt(i))){
                for (int j = 0; j < i; j++){
                    set.remove(s.charAt(j));
                }
                return;
            }
            set.add(s.charAt(i));
        }
        dfs(arr, index+1, set);
        for (char ch : s.toCharArray()){
            set.remove(ch);
        }
    }
}