class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        int len = nums.length;
        int j = 1, k = len-1;
        
        List<List<Integer>> arr = new ArrayList<>();
        int l;
        for(int i=0;i<len-3;i++) {

            if (i > 0 && nums[i] == nums[i - 1]) continue;
            for(l = i+1;l<len-2;l++){
                if (l > i+1 && nums[l] == nums[l - 1]) continue;
                j = l+1;
                k = len-1;
                while(j<k){
                    long sum = (long)nums[i]+(long)nums[j]+(long)nums[l]+(long)nums[k];
                    if(sum<target){
                        j++;
                    }
                    else if(sum>target) {
                        k--;
                    }
                    else {
                        arr.add(Arrays.asList(nums[i], nums[l], nums[j], nums[k]));
                        j++;
                        k--;

                        // Skip duplicates for j
                        while (j < k && nums[j] == nums[j - 1]) j++;
                        // Skip duplicates for k
                        while (j < k && nums[k] == nums[k + 1]) k--;
                    }
                }
            }
        }
        return arr;
    }
}