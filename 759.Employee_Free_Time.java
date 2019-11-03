/*
// Definition for an Interval.
class Interval {
    public int start;
    public int end;

    public Interval() {}

    public Interval(int _start,int _end) {
        start = _start;
        end = _end;
    }
};
*/
class Solution {
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        List<Interval> list = new ArrayList<>();
        for (List<Interval> temp: schedule){
            for (Interval i:temp){
                list.add(i);
            }
        }
        Collections.sort(list, new Comparator<Interval>(){
            public int compare(Interval i1, Interval i2){
                return i1.start - i2.start;
            }
        });
        List<Interval> res = new ArrayList<>();
        int end = list.get(0).end;
        for (int i = 1; i < list.size(); i++){
            if (list.get(i).start > end){
                Interval interval = new Interval(end, list.get(i).start);
                res.add(interval);
            }
            end = Math.max(end, list.get(i).end);
        }
        return res;
    }
}