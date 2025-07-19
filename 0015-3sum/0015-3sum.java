class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        int j = 1, k = len-1;
        
        List<List<Integer>> arr = new ArrayList<>();
        for(int i=0;i<len-2;i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            j = i+1;
            k = len-1;
            while(j<k){
                int sum = nums[i]+nums[j]+nums[k];
                if(sum<0){
                    j++;
                }
                else if(sum>0) {
                    k--;
                }
                else {
                    arr.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;

                    // Skip duplicates for j
                    while (j < k && nums[j] == nums[j - 1]) j++;
                    // Skip duplicates for k
                    while (j < k && nums[k] == nums[k + 1]) k--;
                }
            }
        }
        return arr;
    }
}