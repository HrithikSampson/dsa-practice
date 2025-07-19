class Solution {
    public int[][] merge(int[][] intervals) {
        int m = intervals.length;
        
        int[][] arr = new int[m][2];
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int i;
        int largestEnd = intervals[0][1],count=0;
        arr[0][0] = intervals[0][0];
        for(i=0;i<m;i++) {
            if(intervals[i][0]>largestEnd) {
                arr[count][1] = largestEnd;
                ++count;
                arr[count][0] = intervals[i][0];
            }
            largestEnd = Math.max(largestEnd,intervals[i][1]);
        }
        arr[count][1] = largestEnd;
        int[][] ret = new int[count+1][2];
        for(i=0;i<=count;i++){
            ret[i][0] = arr[i][0];
            ret[i][1] = arr[i][1];
        }
        // return arr;
        return ret;

    }
}