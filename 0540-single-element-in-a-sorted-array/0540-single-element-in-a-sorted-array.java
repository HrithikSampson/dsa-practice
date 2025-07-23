class Solution {
    public int singleNonDuplicate(int[] nums) {
        int left = 0;
        int right = nums.length -1;
        int candidate = right;
        while(left<=right) {

            int mid = left + (right - left)/2;
            if(mid == nums.length - 1) break;
            System.out.println(mid);
            if(mid%2==1){
                if(nums[mid] == nums[mid-1]) {
                    //number is contained in the right side
                    left = mid + 1;
                }
                else {
                    candidate = mid;
                    right = mid - 1;
                }
            }
            else {
                if(nums[mid]==nums[mid+1]) {
                    left = mid + 1;
                }
                else {
                    right = mid - 1;
                    candidate = mid;
                }
            }
        }
        return nums[candidate];
    }
}