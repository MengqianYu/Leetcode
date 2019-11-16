class Solution {
    int[] parent;
    public int maximumMinimumPath(int[][] A) {
        int m = A.length;
        int n = A[0].length;
        parent = new int[m*n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((x, y)->A[y[0]][y[1]] - A[x[0]][x[1]]);
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                int index = i*n + j;
                parent[index] = index;
                pq.offer(new int[]{i, j});
            }
        }
        int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int res = Integer.MAX_VALUE;
        while (!pq.isEmpty()){
            int[] curr = pq.poll();
            int row = curr[0];
            int col = curr[1];
            res = Math.min(res, A[row][col]);
            visited[row][col] = true;
            for (int[] dir : dirs){
                int nr = row + dir[0];
                int nc = col + dir[1];
                if (nr < 0 || nr >= m || nc < 0 || nc >= n || !visited[nr][nc]){
                    continue;
                }
                union(row*n+col, nr*n+nc);
            }
            if (find(0) == find(m*n-1)){
                break;
            }
        }
        return res;
    }
    
    public int find(int i){
        if (parent[i] == i) return i;
        return find(parent[i]);
    }
    
    public void union(int x, int y){
        int parentx = find(x);
        int parenty = find(y);
        parent[parenty] = parentx;
    }
}