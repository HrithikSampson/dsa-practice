class Solution {
    private static boolean canAllocate(int[] arr, int k, int maxPages) {
        int studentsUsed = 1;
        int currentPages = 0;
        
        for(int i = 0; i < arr.length; i++) {
            if(currentPages + arr[i] > maxPages) {
                // Start new student
                studentsUsed++;
                currentPages = arr[i];
                
                if(studentsUsed > k) {
                    return false;
                }
            } else {
                currentPages += arr[i];
            }
        }
        return true;
    }
    
    public static int findPages(int[] arr, int k) {
        if(k > arr.length) return -1;
        
        int left = 0;
        int right = 0;
        
        // Set proper bounds
        for(int pages : arr) {
            left = Math.max(left, pages);  // max single book
            right += pages;                // sum of all books
        }
        
        int result = -1;
        
        while(left <= right) {
            int mid = left + (right - left) / 2;
            
            if(canAllocate(arr, k, mid)) {
                result = mid;
                right = mid - 1;  // Try to find smaller maximum
            } else {
                left = mid + 1;   // Need larger maximum
            }
        }
        
        return result;
    }
}