class Solution {
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int n = pid.size();
        for (int i = 0; i < n; i++){
            if (!map.containsKey(ppid.get(i))){
                map.put(ppid.get(i), new ArrayList<Integer>());
            }
            map.get(ppid.get(i)).add(pid.get(i));
        }
        List<Integer> res = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        stack.push(kill);
        while (!stack.isEmpty()){
            int curr = stack.pop();
            res.add(curr);
            if (map.containsKey(curr)){
                for (int i : map.get(curr)){
                    stack.push(i);
                }
            }
        }
        return res;
    }
}