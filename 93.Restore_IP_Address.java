class Solution {
    List<String> res;
    public List<String> restoreIpAddresses(String s) {
        res = new ArrayList<>();
        int len = s.length();
        for (int i = 1; i < 4 && i < len; i++){
            for (int j = i+1; j < i+4 && j < len; j++){
                for (int k = j+1; k < j+4 && k < len; k++){
                    String s1 = s.substring(0, i);
                    String s2 = s.substring(i, j);
                    String s3 = s.substring(j, k);
                    String s4 = s.substring(k, len);
                    if (isValid(s1) && isValid(s2) && isValid(s3) && isValid(s4)){
                        StringBuilder sb = new StringBuilder();
                        sb.append(s1).append(".").append(s2).append(".").append(s3).append(".").append(s4);
                        res.add(sb.toString());
                    }
                }
            }
        }
        return res;
    }
    
    private boolean isValid(String s){
        if (s.charAt(0) == '0') return s.length() == 1;
        if (s.length() > 3) return false;
        int n = Integer.parseInt(s);
        if (n > 255) return false;
        return true;
    }
}