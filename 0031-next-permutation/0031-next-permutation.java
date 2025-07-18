class Solution {
    public void nextPermutation(int[] nums) {
        int i,n = nums.length;
        boolean des = true;
        for(i=n-1;i>=1;i--) {
            if(nums[i]>nums[i-1]){
                
                int lesser = nums[i-1];

                int greaterThanLesser = nums[n-1];
                int k = n-1;
                while(k>=i){ if(nums[k]>lesser) break; k--;};
                // System.out.println(i-1+" "+k);
                int temp1 = nums[i - 1];
                nums[i - 1] = nums[k];
                nums[k] = temp1;
                k=i;
                // for(i=0;i<n;i++) System.out.print(nums[i]+" ");
                // System.out.println();
                int left = k, right = n - 1;
                while (left < right) {
                    int temp = nums[left];
                    nums[left] = nums[right];
                    nums[right] = temp;
                    left++;
                    right--;
                }
                des = false;
                break;
            }
        }
        if(des) {
            for(i=0;i<n/2;i++){
                int temp = nums[i];
                nums[i] = nums[n-1-i];
                nums[n-1-i] = temp;
            }
        }

    }
}
