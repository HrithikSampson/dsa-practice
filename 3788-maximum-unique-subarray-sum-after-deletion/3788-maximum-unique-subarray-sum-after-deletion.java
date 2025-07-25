class Solution {
    public int maxSum(int[] nums) {
        Set<Integer> s = new HashSet<Integer>();
        int maxm = Integer.MIN_VALUE;
        for(int x: nums) {
            if(x>=0){
                s.add(x);
            }
            maxm = Math.max(maxm,x);
        }
        if(s.size()==0){
            return maxm;
        }
        int sum = 0;
        for(int x: s) {
            sum+=x;
        }
        
        return sum;
    }
}