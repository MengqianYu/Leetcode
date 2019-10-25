class Solution {
    public int[] pourWater(int[] heights, int V, int K) {
        for (int i = 0; i < V; i++){
            if (!checkIfFall(heights, K, -1)){
                heights[K]++;
            }
        }
        return heights;
    }
    
    private boolean checkIfFall(int[] heights, int pos, int direction){
        int p = pos + direction;
        int min = heights[pos];
        int minPos = pos;
        while (p >= 0 && p < heights.length){
            if (heights[p] > heights[p-direction]){
                break;
            }
            if (min > heights[p]){
                min = heights[p];
                minPos = p;
            }
            p += direction;
        }
        if (minPos != pos){
            heights[minPos]++;
            return true;
        }
        if (direction == -1){
            return checkIfFall(heights, pos, 1);
        }
        return false;
    }
}