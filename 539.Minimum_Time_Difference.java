class Solution {
    public int findMinDifference(List<String> timePoints) {
        boolean[] bucket = new boolean[24*60];
        if (timePoints.size() == 0) return 0;
        int last = 0;
        int first = 1440;
        int min = 1440;
        for (int i = 0; i < timePoints.size(); i++){
            String[] ss = timePoints.get(i).split(":");
            int hour = Integer.parseInt(ss[0]);
            int minute = Integer.parseInt(ss[1]);
            int index = hour*60+minute;
            if (bucket[index]) return 0;
            bucket[index] = true;
            last = Math.max(last, index);
            first = Math.min(first, index);
        }
        int prev = first;
        for (int i = 0; i < 1440; i++){
            if (bucket[i] && i != first){
                int difference = i - prev;
                min = Math.min(difference, min);
                prev = i;
            }
        }
        min = Math.min(min, 1440+first-last);
        return min;
    }
}