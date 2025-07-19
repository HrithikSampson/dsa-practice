class Solution {
    public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int x: nums) {
            map.put(x,0);
        }
        Set<Integer> list = map.keySet();
        if(nums.length<1){
            return 0;
        }
        int maxm = 1;
        for(int key: list) {
            if(!map.containsKey(key-1)) {
                int temp = key;
                while(map.containsKey(temp)) {
                    temp++;
                }
                maxm = Math.max(temp-key,maxm);
            }
        }
        return maxm;
    }
}