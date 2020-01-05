class Solution {
    public String findReplaceString(String S, int[] indexes, String[] sources, String[] targets) {
        StringBuilder sb = new StringBuilder();
        Map<Integer, String> sourcemap = new HashMap<>();
        Map<Integer, String> targetmap = new HashMap<>();
        for (int i = 0; i < indexes.length; i++){
            sourcemap.put(indexes[i], sources[i]);
            targetmap.put(indexes[i], targets[i]);
        }
        Arrays.sort(indexes);
        int prev = 0;
        for (int i = 0; i < indexes.length; i++){
            for (int j = prev; j < indexes[i]; j++){
                sb.append(S.charAt(j));
            }
            if (S.substring(indexes[i], sourcemap.get(indexes[i]).length() + indexes[i]).equals(sourcemap.get(indexes[i]))){
                sb.append(targetmap.get(indexes[i]));
                prev = indexes[i] + sourcemap.get(indexes[i]).length();
            }
            else{
                prev = indexes[i];
            }
        }
        for (int i = prev; i < S.length(); i++){
            sb.append(S.charAt(i));
        }
        return sb.toString();
    }
}