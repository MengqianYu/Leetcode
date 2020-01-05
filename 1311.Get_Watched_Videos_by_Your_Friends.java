class Solution {
    public List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id, int level) {
        Set<Integer> visited = new HashSet<>();
        Set<Integer> set = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(id);
        visited.add(id);
        while (level > 0){
            int size = queue.size();
            for (int i = 0; i < size; i++){
                int curr = queue.poll();
                for (int j = 0; j < friends[curr].length; j++){
                    if (visited.contains(friends[curr][j])){
                        continue;
                    }
                    visited.add(friends[curr][j]);
                    queue.offer(friends[curr][j]);
                }
            }
            level--;
        }
        while (!queue.isEmpty()){
            set.add(queue.poll());
        }
        Map<String, Integer> map = new HashMap<>();
        List<String> res = new ArrayList<>();
        for (int i : set){
            for (String video: watchedVideos.get(i)){
                map.put(video, map.getOrDefault(video, 0)+1);
            }
        }
        for (String s : map.keySet()){
            res.add(s);
        }
        
        Collections.sort(res, new Comparator<String>(){
            public int compare(String a, String b){
                if (map.get(a) == map.get(b)){
                    return a.compareTo(b);
                }
                else{
                    return map.get(a) - map.get(b);
                }
            }
        });
        return res;
    }
}