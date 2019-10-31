class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        StringBuilder sb = new StringBuilder();
        if ((numerator>0 && denominator < 0) || (numerator < 0 && denominator > 0)){
            sb.append("-");
        }
        long ln = (long)Math.abs((long)numerator);
        long ld = (long)Math.abs((long)denominator);
        long ipart = ln/ld;
        sb.append(ipart);
        if (ln%ld==0){
            return sb.toString();
        }
        sb.append(".");
        List<Integer> decimals = new ArrayList<>();
        Map<Long, Integer> map = new HashMap<>();
        long remainder = ln%ld;
        boolean recurrent = false;
        int recurrence = sb.length();
        while (remainder != 0){
            map.put(remainder, map.size());
            long dividend = remainder * 10;
            decimals.add((int)(dividend/ld));
            remainder = dividend%ld;
            if (map.containsKey(remainder)){
                recurrence += map.get(remainder);
                recurrent = true;
                break;
            }
        }
        for (int i = 0; i < decimals.size(); i++){
            sb.append(decimals.get(i));
        }
        if (recurrent){
            sb.insert(recurrence, "(");
            sb.append(")");
        }
        return sb.toString();
    }
}