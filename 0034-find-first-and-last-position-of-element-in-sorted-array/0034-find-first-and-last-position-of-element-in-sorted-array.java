class Solution {
    public int[] searchRange(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        if(nums.length==0 || nums[right]<target){
            return new int[]{-1,-1};
        }
        int[] ret = new int[2];
        int candidateMid = -1;
        while(left<=right) {
            int mid = left + (right - left)/2;
            if(nums[mid]==target){
                candidateMid = mid;
                right = mid - 1;
            }
            else if(nums[mid]<target) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
        
        if(candidateMid == -1){
            return new int[]{-1,-1};
        }
        ret[0] = candidateMid;
        left = 0;
        right = nums.length - 1;
        candidateMid = -1;
        while(left<=right) {
            int mid = left + (right - left)/2;
            if(nums[mid]==target){
                candidateMid = mid;
                left = mid + 1;
            }
            else if(nums[mid]<target) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
        ret[1] = candidateMid;
        return ret;
    }
}