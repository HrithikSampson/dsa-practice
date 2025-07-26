// User function Template for Java

class Solution {
    private boolean check(int[] arr,int k,int mid) {
        int numPainters = 1;
        int currentPainterTime = 0;
        for(int i = 0; i< arr.length;i++) {
            currentPainterTime+=arr[i];
            if(currentPainterTime>mid) {
                currentPainterTime = arr[i];
                numPainters++;
            }
            if(numPainters>k) return false;
        }
        return true;
    }
    public int minTime(int[] arr, int k) {
        // code here
        int left = 0;
        int right = 0;
        for(int x: arr) {
            left = Math.max(left, x);
            right += x;
        }
        int candidate = -1;
        while(left<=right) {
            int mid = left + (right - left)/2;
            boolean canDo = check(arr, k, mid);
            if(canDo) {
                right = mid - 1;
                candidate = mid;
            } else {
                left = mid + 1;
            }
        }
        return candidate;
    }
}
