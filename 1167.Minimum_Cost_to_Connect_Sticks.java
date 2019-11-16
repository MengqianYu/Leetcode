class Solution {
    public int connectSticks(int[] sticks) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < sticks.length; i++){
            pq.offer(sticks[i]);
        }
        int res = 0;
        while (!pq.isEmpty()){
            int num1 = pq.poll();
            if (pq.isEmpty()){
                return res;
            }
            int num2 = pq.poll();
            int num = num1+num2;
            res += num;
            pq.offer(num);
        }
        return res;
    }
}