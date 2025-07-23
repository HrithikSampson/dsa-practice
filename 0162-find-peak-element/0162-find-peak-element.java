class Solution {
    private int findPivot(int[] nums) {
        int pivot = -1;
        int left = 0;
        int right = nums.length - 1;
        int n = nums.length;
        if(n<2) return 0;
        if(nums[left]>nums[left+1]) return left;
        if(nums[right]>nums[right-1]) return right;
        while(left<=right) {
            int mid = left + (right - left)/2;
            // System.out.println(mid);
            if(mid==0){
                left++;
                continue;
            }
            if(mid==n-1) {
                right--;
                continue;
            }
            if(nums[mid]>nums[mid-1] && nums[mid]>nums[mid+1]) {
                return mid;
            }
            else if(nums[mid-1]<nums[mid] && nums[mid]<nums[mid+1]) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
        return left;
        
    }
    public int findPeakElement(int[] nums) {
        return findPivot(nums);
    }
}