class MyCalendar {
    TreeMap<Integer, Integer> map;
    

    public MyCalendar() {
        map = new TreeMap<>();
    }
    
    public boolean book(int start, int end) {
        Integer last = map.lowerKey(end);
        Integer next = map.ceilingKey(start);
        if ((last == null || map.get(last) <= start) && (next == null || end <= next)){
            map.put(start, end);
            return true;
        }
        return false;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */