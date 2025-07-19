class Solution {
    public List<List<Integer>> generate(int numRows) {
        int currentLength = 1;
        if(numRows == 0){
            return new ArrayList<>();
        }
        List<List<Integer>> list = new ArrayList<>();
        list.add(new ArrayList<>(Arrays.asList(1)));
        while(currentLength<numRows) {
            ++currentLength;
            List<Integer> subList = new ArrayList<Integer>(currentLength);
            subList.add(list.get(currentLength-2).get(0));
            for(int length = 1;length<currentLength - 1;length++) {
                subList.add(list.get(currentLength-2).get(length) + list.get(currentLength-2).get(length-1));
            }
            subList.add(list.get(currentLength-2).get(currentLength-2));
            list.add(subList);
        }
        return list;
    }
}