class Solution {
    private int findPivot(int[] nums) {
        int pivot = -1;
        int left = 0;
        int right = nums.length - 1;
        
        if(nums[right]>=nums[left]) return 0;
        int candidateMid = -1;
        while(left<=right){
            int mid = left + (right - left) /2;
            // System.out.println(mid);
            if(nums[mid]>=nums[0]) {
                left = mid + 1;
                candidateMid = mid;
            }
            else {
                right = mid - 1;
            }
            // System.out.println(left+" "+right);
        }
        // System.out.println(candidateMid);
        return candidateMid + 1;
    }
    public int search(int[] nums, int target) {
        int pivot = findPivot(nums);
        int left = pivot;
        int n = nums.length;
        int right = pivot + n -1;
        if(nums[right%n]<target) return -1;
        int candidateMid = -1;
        // System.out.println("pivot:"+pivot);
        while(left <= right) {
            int mid = left + (right - left)/2;
            // System.out.println(mid);
            if(nums[mid%n]<target) {
                left = mid + 1;
            }
            else if(nums[mid%n]==target) {
                return mid%n;
            }
            else {
                right = mid - 1;
            }
        }
        return candidateMid;
    }
}