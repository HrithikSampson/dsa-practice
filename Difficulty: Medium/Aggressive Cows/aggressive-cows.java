// User function Template for Java
class Solution {
    private static boolean check(int[] stalls,int k,int minDistance) {
        int numCowsAssigned = 0,i=0, n=stalls.length;
        int lastDistance = -minDistance;
        int numStalls = 0;
        for(i=0;i<n;i++) {
            if(stalls[i]>=lastDistance+minDistance) {
                numStalls++;
                lastDistance = stalls[i];
            }
            if(numStalls==k) return true;
            
        }
        return false;
    }
    
    public static int aggressiveCows(int[] stalls, int k) {
        // code here
        Arrays.sort(stalls);
        int left = 1;
        int n = stalls.length;
        int right = stalls[n-1];
        int candidate = -1;
        while(left<=right) {
            int mid = left + (right - left)/2;
            boolean checkIsNotAggressive = check(stalls,k,mid);
            // System.out.println(mid+" "+checkIsNotAggressive);
            if(checkIsNotAggressive) {
                candidate = mid;
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
        return candidate;
    }
}