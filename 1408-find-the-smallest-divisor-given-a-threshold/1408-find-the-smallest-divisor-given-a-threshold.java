class Solution {
    private boolean check(int[] nums, int threshold, long divisor) {
        long sum = 0;
        for(int x:nums) {
            sum+=x/divisor+(x%divisor!=0?1:0);
            if(sum>threshold) return false;
        }
        return true;
    }
    public int smallestDivisor(int[] nums, int threshold) {
        long sum = 0;
        for(int x:nums) {
            sum+=x;
        }
        long right = sum;
        long left = 1;
        long candidate = -1;
        while(left<=right) {
            long mid = left + (right - left)/2;
            if(check(nums,threshold,mid)) {
                right = mid - 1;
                candidate = mid;
            }
            else {
                left = mid + 1;
            }
        }
        return (int)candidate;
    }
}