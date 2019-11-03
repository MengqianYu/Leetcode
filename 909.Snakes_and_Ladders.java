class Solution {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        if (n == 0) return 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        int[] dis = new int[n*n+1];
        Arrays.fill(dis, -1);
        dis[1] = 0;
        Map<Integer, Integer> ladders = new HashMap<>();
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                if (board[i][j] != -1){
                    int num = n * (n-i-1);
                    int col = j+1;
                    if ((n-i)%2 == 0){
                        col = n-j;
                    }
                    num+=col;
                    ladders.put(num, board[i][j]);
                }
            }
        }
        while (!queue.isEmpty()){
            int curr = queue.poll();
            for (int i = 1; i <= 6 && curr+i <= n*n; i++){
                if (ladders.containsKey(curr+i)){
                    int next = ladders.get(curr+i);
                    if (dis[next]==-1){
                        dis[next] = dis[curr]+1;
                        queue.offer(next);
                    }
                }
                else{
                    if (dis[curr+i] == -1){
                        dis[curr+i] = dis[curr]+1;
                        queue.offer(curr+i);
                    }
                }
            }
        }
        return dis[n*n];
    }
}