class Solution {
    public void wallsAndGates(int[][] rooms) {
        Queue<int[]> queue = new LinkedList<>();
        if (rooms.length == 0) return;
        for (int i = 0; i < rooms.length; i++){
            for (int j = 0; j < rooms[0].length; j++){
                if (rooms[i][j] == 0){
                    queue.offer(new int[]{i, j});
                }
            }
        }
        int[][] dir = new int[][]{{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        while (!queue.isEmpty()){
            int[] curr = queue.poll();
            for (int i = 0; i < 4; i++){
                int nr = curr[0] + dir[i][0];
                int nc = curr[1] + dir[i][1];
                if (nr >= 0 && nr < rooms.length && nc >= 0 && nc < rooms[0].length && rooms[nr][nc] == Integer.MAX_VALUE){
                    rooms[nr][nc] = rooms[curr[0]][curr[1]] + 1;
                    queue.offer(new int[]{nr, nc});
                }
            }
        }
    }
}