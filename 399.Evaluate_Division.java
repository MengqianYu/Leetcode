class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> map = new HashMap<>();
        for (int i = 0; i < equations.size(); i++){
            List<String> equation = equations.get(i);
            String s1 = equation.get(0);
            String s2 = equation.get(1);
            if (!map.containsKey(s1)){
                map.put(s1, new HashMap<String, Double>());
            }
            if (!map.containsKey(s2)){
                map.put(s2, new HashMap<String, Double>());
            }
            map.get(s1).put(s2,values[i]);
            map.get(s2).put(s1,(1.0/values[i]));
        }
        double[] res = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++){
            List<String> query = queries.get(i);
            String dividend = query.get(0);
            String divisor = query.get(1);
            if (!map.containsKey(dividend) || !map.containsKey(divisor)){
                res[i] = -1.0;
            }
            else{
                List<Double> vals = new ArrayList<>();
                Set<String> visited = new HashSet<>();
                if(dfs(map, vals, divisor, visited, dividend)){
                    res[i] = 1.0;
                    for (double d : vals){
                        res[i] *= d;
                    }
                }
                else{
                    res[i] = -1.0;
                }
            }
        }
        return res;
    }
    
    private boolean dfs(Map<String, Map<String, Double>> map, List<Double> values, String divisor, Set<String> visited, String dividend){
        if (dividend.equals(divisor)){
            return true;
        }
        visited.add(dividend);
        Map<String, Double> temp = map.get(dividend);
        for (String next : temp.keySet()){
            if (visited.contains(next)) continue;
            values.add(map.get(dividend).get(next));
            if (dfs(map, values, divisor, visited, next)){
                return true;
            }
            values.remove(values.size()-1);
        }
        return false;
    }
}