class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> prev = List.of(1);
        if(rowIndex == 0) return prev;
        for(int i = 1; i<=rowIndex; i++){
           List<Integer> cur = new ArrayList<>();

           cur.add(1);

           for(int j = 1; j<i; j++){
            cur.add(prev.get(j-1)+prev.get(j));
           }
           cur.add(1);
           prev=cur;
        }
        return prev;
    }
}