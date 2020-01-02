class Solution {
    public int brokenCalc(int X, int Y) {
        int n = 0;
        if (X >= Y){
            return X-Y;
        }
        while (X < Y){
            if (Y % 2 == 0){
                Y = Y/2;
            }
            else{
                Y = Y+1;
            }
            n++;
        }
        n += X-Y;
        return n;
    }
}