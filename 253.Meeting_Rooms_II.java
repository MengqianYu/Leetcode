class Solution {
    public int minMeetingRooms(int[][] intervals) {
        int length = intervals.length;
        int[] start = new int[length];
        int[] end = new int[length];
        for (int i = 0; i < length; i++){
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }
        Arrays.sort(start);
        Arrays.sort(end);
        int rooms = 0;
        int res = 0;
        int s = 0;
        int e = 0;
        while (s < length){
            if (start[s] < end[e]){
                rooms++;
                s++;
                res = Math.max(rooms, res);
            }
            else if (start[s] > end[e]){
                rooms--;
                e++;
            }
            else{
                s++;
                e++;
            }
        }
        return res;
    }
}