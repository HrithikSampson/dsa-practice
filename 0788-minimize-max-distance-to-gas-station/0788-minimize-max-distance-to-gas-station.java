class Solution {
    public boolean checkGas(long[] gas,int k,long mid) {
        long lastgas = gas[0];
        int numStations=0;
        for(int i=0;i<gas.length;) {
            if(lastgas+mid<gas[i]) {
                lastgas = lastgas+mid;
                numStations++;
                if(numStations>k) {
                    // System.out.println(lastgas+"->"+gas[i]+"<"+i+">");
                    return false;
                }
            }
            else {
                lastgas = gas[i];
                i++;
            }
        }
        return true;
    }
    public double minmaxGasDist(int[] stations, int k) {
        int n = stations.length;
        long[] gas = new long[n];
        int i;
        for(i=0;i<n;i++) {
            gas[i] = stations[i] * (long)1e6;
        }
        long left = 0, right = 0;
        for(long x: gas) {
            right = Math.max(right, x);
        }
        long candidate = 0;
        while(left<=right) {
            long mid = left + (right - left)/2;
            boolean chk = checkGas(gas,k,mid);
            // System.out.println(mid+":"+chk);
            if(chk) {
                candidate = mid;
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }
        return (candidate/1e6);
    }
}