class Solution {
    public int numberOfBouquets(int[] bloomDay, int days,int k) {
        int i;
        int numBouquet = 0;
        int currentBloomed = 0;
        for(i=0;i<bloomDay.length;i++) {
            if(bloomDay[i]>days) {
                currentBloomed = 0;
                continue;
            }
            currentBloomed++;
            if(currentBloomed==k){
                ++numBouquet;
                currentBloomed = 0;
            }
        }
        return numBouquet;
    }
    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
        if(k*m>n) return -1;
        // Arrays.sort(bloomDay);
        
        int left = 0;
        int maxm = 0;
        for(int x: bloomDay) {
            maxm = Math.max(x,maxm);
        }
        int right = maxm;
        int candidate = -1;
        while(left<=right) {
            int mid = left + (right - left)/2;
            int num = numberOfBouquets(bloomDay,mid,k);
            // System.out.println(mid+" "+num);
            if(num<m){
                left = mid + 1;
            }
            else {
                candidate = mid;
                right = mid - 1;
            }
        }
        return candidate;
    }
}