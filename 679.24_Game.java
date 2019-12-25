class Solution {
    public boolean judgePoint24(int[] nums) {
        List<Double> temp = new ArrayList<>();
        for (int i = 0; i < nums.length; i++){
            temp.add((double)nums[i]);
        }
        return judgePoint24(temp);
    }
    
    public boolean judgePoint24(List<Double> nums){
        if (nums.size() == 1){
            if (Math.abs(nums.get(0) - 24.0) < 0.001) return true;
            else return false;
        }
        for (int i = 0; i < nums.size(); i++){
            for (int j = i+1; j < nums.size(); j++){
                List<Double> temp = new ArrayList<>();
                for (int k = 0; k < nums.size(); k++){
                    if (k != i && k != j){
                        temp.add(nums.get(k));
                    }
                }
                double d1 = nums.get(i);
                double d2 = nums.get(j);
                temp.add(d1+d2);
                if (judgePoint24(temp)) return true;
                temp.remove(temp.size()-1);
                temp.add(d1-d2);
                if (judgePoint24(temp)) return true;
                temp.remove(temp.size()-1);
                temp.add(d2-d1);
                if (judgePoint24(temp)) return true;
                temp.remove(temp.size()-1);
                temp.add(d1*d2);
                if (judgePoint24(temp)) return true;
                temp.remove(temp.size()-1);
                temp.add(d1/d2);
                if (judgePoint24(temp)) return true;
                temp.remove(temp.size()-1);
                temp.add(d2/d1);
                if (judgePoint24(temp)) return true;
                temp.remove(temp.size()-1);
            }
        }
       /* for (int i = 0; i < nums.size(); i++){
            System.out.print(nums.get(i) + " ");
        }
        System.out.println("");*/
        return false;
    }
}