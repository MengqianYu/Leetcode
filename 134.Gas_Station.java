class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int tank = 0;
        int prev = 0;
        int res = 0;
        for (int i = 0; i < gas.length; i++){
            int total = gas[i] - cost[i];
            tank += total;
            if (tank < 0){
                res = i+1;
                prev += tank;
                tank = 0;
            }
        }
        tank += prev;
        if (res < gas.length && tank >= 0){
            return res;
        }
        return -1;
    }
}