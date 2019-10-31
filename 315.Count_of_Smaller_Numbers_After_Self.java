class Item{
    int value;
    int index;
    public Item(int v, int i){
        value = v;
        index = i;
    }
}
class Solution {
    public List<Integer> countSmaller(int[] nums) {
        Item[] items = new Item[nums.length];
        for (int i = 0; i < nums.length; i++){
            items[i] = new Item(nums[i], i);
        }
        int[] count = new int[nums.length];
        mergeSort(items, count, 0, items.length-1);
        List<Integer> res = new ArrayList<>();
        for (int c : count){
            res.add(c);
        }
        return res;
    }
    
    private void mergeSort(Item[] items, int[] count, int start, int end){
        if (start >= end){
            return;
        }
        int mid = start + (end-start)/2;
        mergeSort(items, count, start, mid);
        mergeSort(items, count, mid+1, end);
        merge(items, count, start, mid, mid+1, end);
    }
    
    private void merge(Item[] items, int[] count, int s1, int e1, int s2, int e2){
        int p1 = s1;
        int p2 = s2;
        int counter = 0;
        List<Item> sorted = new ArrayList<>();
        while (p1 <= e1 && p2 <= e2){
            if (items[p1].value > items[p2].value){
                counter++;
                sorted.add(items[p2]);
                p2++;
            }
            else{
                count[items[p1].index] += counter;
                sorted.add(items[p1]);
                p1++;
            }
        }
        while (p1 <= e1){
            count[items[p1].index] += counter;
            sorted.add(items[p1]);
            p1++;
        }
        while (p2 <= e2){
            sorted.add(items[p2]);
            p2++;
        }
        int pos = s1;
        for (Item i : sorted){
            items[pos] = i;
            pos++;
        }
    }
}