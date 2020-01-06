class Solution {
    public String largestNumber(int[] nums) {
        String[] ss = new String[nums.length];
        for (int i = 0; i < nums.length; i++){
            ss[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(ss, new Comparator<String>(){
            public int compare(String s1, String s2){
                String str1 = s1 + s2;
                String str2 = s2 + s1;
                return str2.compareTo(str1);
            }
        });
        if (ss.length == 0 || ss[0].equals("0")) return "0";
        StringBuilder sb = new StringBuilder();
        for (String s : ss){
            sb.append(s);
        }
        return sb.toString();
    }
}