class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>(){
            public int compare(int[] a, int[] b){
                if (a[0] != b[0]) return b[0] - a[0];
                else return a[1] - b[1];
            }
        });
        List<int[]> list = new ArrayList<>();
        for (int[] person : people){
            list.add(person);
        }
        for (int i = 1; i < list.size(); i++){
            int[] temp = list.get(i);
            int k = temp[1];
            if (k < i){
                list.remove(i);
                list.add(k, temp);
            }
        }
        int[][] res = new int[people.length][2];
        for (int i = 0; i < list.size(); i++){
            res[i][0] = list.get(i)[0];
            res[i][1] = list.get(i)[1];
        }
        return res;
    }
}