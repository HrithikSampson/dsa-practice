class Solution {
    public int check(int[] weights, int weight) {
        int i;
        int numDays = 0;
        int current = weight;
        for(i=0;i<weights.length;i++) {

            if(weights[i]>current) {
                current = weight;
                numDays++;
            }
            current-=weights[i];
            // System.out.println(current+" "+i+" "+numDays);
        }
        
        return numDays + 1;
    }
    public int shipWithinDays(int[] weights, int days) {
        // Arrays.sort(weights);
        int left = Arrays.stream(weights).max().getAsInt();
        int right = Arrays.stream(weights).sum();
        int candidate = -1;
        while(left<=right) {
            int mid = left + (right - left)/2;
            int curr = check(weights,mid);
            if(curr <= days) {
                candidate = mid;
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }
        return candidate;
    }
}