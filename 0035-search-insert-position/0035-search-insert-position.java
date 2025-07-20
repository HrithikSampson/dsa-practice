class Solution {
    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1, i = 0;
        if(nums[right]<target) return right+1;
        int mid;
        while(left<right) {
            mid = (left + right)/2;
            if(nums[mid]>target) {
                right = mid;
            }
            
            else if (nums[mid]<target) {
                left = mid + 1;
            }
            else {
                return mid;
            }
        }
        return left;
    }
}