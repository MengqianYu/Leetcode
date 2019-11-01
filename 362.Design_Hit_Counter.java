class Hit{
    int count;
    int timestamp;
    public Hit(int timestamp){
        count = 1;
        this.timestamp = timestamp;
    }
    public void addCount(){
        count++;
    }
}
class HitCounter {
    int count = 0;
    Deque<Hit> dq;

    /** Initialize your data structure here. */
    public HitCounter() {
        dq = new LinkedList<>();
    }
    
    /** Record a hit.
        @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        int start = timestamp - 300;
        while (!dq.isEmpty()&&dq.peekFirst().timestamp <= start){
            count -= dq.pollFirst().count;
        }
        if (dq.isEmpty() || dq.peekLast().timestamp < timestamp){
            dq.offerLast(new Hit(timestamp));
        }
        else{
            dq.peekLast().addCount();
        }
        count++;
    }
    
    /** Return the number of hits in the past 5 minutes.
        @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        int start = timestamp - 300;
        while (!dq.isEmpty()&&dq.peekFirst().timestamp <= start){
            count -= dq.pollFirst().count;
        }
        return count;
    }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */