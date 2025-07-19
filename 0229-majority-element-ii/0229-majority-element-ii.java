class Solution {
    public List<Integer> majorityElement(int[] nums) {
        Integer candidate1 = null;
        Integer candidate2 = null;
        int len = nums.length;
        int count1 = 0;
        int count2 = 0;
        List<Integer> list = new ArrayList<Integer>();
        for(int n: nums) {
            if(candidate1!=null && candidate1 == n) {
                ++count1;
            }
            else if(candidate2!=null && candidate2 == n) {
                ++count2;
            }
            else if(count1 == 0) {
                candidate1 = n;
                count1++;
            }
            else if(count2 == 0){
                candidate2 = n;
                count2++;
            }
            else {
                --count1;
                --count2;
            }
        }
        count1 = 0;
        count2 = 0;
        for(int n: nums) {
            if(candidate1!=null && candidate1 == n) {
                count1++;
            }
            if(candidate2!=null && candidate2 == n){
                count2++;
            }
        }
        if(count1>len/3){
            list.add(candidate1);
        }
        if(count2>len/3){
            list.add(candidate2);
        }
        return list;
    }
}