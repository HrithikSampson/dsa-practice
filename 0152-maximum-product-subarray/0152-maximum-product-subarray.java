class Solution {
    public int maxProduct(int[] nums) {
        int prev_prod = 1;
        int prod = 1;
        int maxm = nums[0];
        for(int n: nums) {
            prod = prod*n;
            if(n==0) {
                prev_prod = 1;
                prod = 1;
                maxm = Math.max(0,maxm);
                continue;
            }
            else if(prod<0) {
                // System.out.println(prev_prod + " " + prod);
                maxm = Math.max(prod/prev_prod,maxm);
                prev_prod = prev_prod==1?prod:Math.max(prod,prev_prod);
            }
            maxm = Math.max(prod,maxm);
            // System.out.println(maxm + " " + prod);
            
        }
        return maxm;
    }
}