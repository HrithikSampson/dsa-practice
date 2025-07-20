class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i,j;
        for(i=0;i<m;i++){
            nums1[m+n-1-i] = nums1[m-1-i];
        }
        int start1 = n;
        int start2 = 0;
        while(start1<m+n || start2<n) {
            int currentIndex = start1 - n + start2;
            if(start1==m+n){
                nums1[currentIndex] = nums2[start2++];
            }
            else if(start2==n) {
                nums1[currentIndex] = nums1[start1++];
            }
            else if(nums1[start1]<nums2[start2]) {
                nums1[currentIndex] = nums1[start1++];
            }
            else {
                nums1[currentIndex] = nums2[start2++];
            }
            System.out.println(start1+" "+start2+" "+currentIndex);
        }
    }
}