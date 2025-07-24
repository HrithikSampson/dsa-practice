class Solution {
    public int findKthPositive(int[] arr, int k) {
        int left = 0;
        int right = arr.length-1;
        int candidate = left;
        while(left<=right) {
            int mid = left + (right - left)/2;
            int numMissing = arr[mid] - 1 - mid;
            // System.out.println(mid+ " " + numMissing);
            if(numMissing<k) {
                candidate = mid;
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
        // System.out.println(candidate);
        if(arr[candidate]-candidate-1>=k) return k;
        return arr[candidate] + k - (arr[candidate]-candidate-1);
    }
}