class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        long start = 1;
        long sum = 0;
        for(int x:piles){
            sum += x;
        }
        long end = sum;
        long mid;
        long candidateMid = end;
        while(start<=end){
            //System.out.println(start+" "+end);
            mid = (start+end)/2;
            boolean check = false;
            long hours = 0;
            for(int i = 0;i<piles.length;i++){
                hours += (piles[i]/mid) + ((piles[i]%mid!=0)?1:0);
            }
            //System.out.println(hours);          
            if(hours<=h){
                candidateMid = mid;
                end = mid-1;
            }  
            else{
                start = mid + 1;
            }
        }
        return (int)candidateMid;
    }
}