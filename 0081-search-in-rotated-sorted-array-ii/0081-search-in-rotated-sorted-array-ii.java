
class Solution {
    public boolean search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        // if(nums[right]==target) return true;
        while(left<=right){
            int mid = left + (right - left)/2;
            // System.out.println(mid);
            if(nums[mid]==target){
                return true;
            }
            if(nums[mid] == nums[left] && nums[mid]==nums[right]) {
                left++;
                right--;
                continue;
            }
            else if(nums[mid]<=nums[right]){
                //right part is sorted
                if(target>=nums[mid] && target<=nums[right]){
                    left = mid + 1;
                }
                else {
                    right = mid -1;
                }
            }
            else {// if(nums[mid]>=nums[left]) {
                //left part is sorted
                if(nums[left]<=target && target<=nums[mid]) {
                    right = mid - 1;
                }
                else {
                    left = mid + 1;
                }
            }
            
        }
        return false;
    }
}