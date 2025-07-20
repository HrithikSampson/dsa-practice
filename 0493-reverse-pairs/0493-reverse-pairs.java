class Solution {
    public int reversePairs(int[] nums) {
        int l = 0, r = nums.length - 1;
        return mergeSort(nums, l, r);
    }
    static int mergeSort(int arr[], int l, int r) {
        // code here
        if(l>=r) return 0;
        int mid = (l + r)/2;
        int inversion1 = mergeSort(arr, l, mid);
        int inversion2 = mergeSort(arr,mid + 1, r);
        int[] cloned = new int [r-l+1];
        int currentInversion = 0;
        int currentGreater = l;
        for(int i = mid+1;i<=r;i++) {
            while(currentGreater<=mid && (long)arr[currentGreater]<=2*(long)arr[i]) currentGreater++;
            currentInversion += mid - currentGreater + 1;
        }
        int start1 = l;
        int start2 = mid+1;
        int cloneCnt = 0;
        while(start1<=mid || start2<=r) {
            if(start1 == mid + 1) {
                cloned[cloneCnt++] = arr[start2++];
            }
            else if(start2 == r + 1){
                cloned[cloneCnt++] = arr[start1++];
            }
            else if(arr[start1]<arr[start2]){
                cloned[cloneCnt++] = arr[start1++];
            }
            else {
                cloned[cloneCnt++] = arr[start2++];
            }
        }
        for(int i=0;i<cloneCnt;i++){
            arr[i+l] = cloned[i];
        }
        return currentInversion + inversion1 +inversion2;
    }
}