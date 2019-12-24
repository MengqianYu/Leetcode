class Solution {
    public List<String> removeComments(String[] source) {
        List<String> res = new ArrayList<>();
        boolean blocked = false;
        StringBuilder line = new StringBuilder();
        for (String s : source){
            for (int i = 0; i < s.length(); i++){
                if (!blocked && i + 1 < s.length() && s.charAt(i) == '/' && s.charAt(i+1) == '*'){
                    blocked = true;
                    i++;
                }
                else if (!blocked && i + 1 < s.length()  && s.charAt(i) == '/' && s.charAt(i+1) == '/'){
                    break;
                }
                else if (!blocked){
                    line.append(s.charAt(i));
                }
                else if (blocked && i+1 < s.length() && s.charAt(i) == '*' && s.charAt(i+1) == '/'){
                    blocked = false;
                    i++;
                }
            }
            if (!blocked && line.length() > 0){
                res.add(line.toString());
                line = new StringBuilder();
            }
        }
        return res;
    }
}