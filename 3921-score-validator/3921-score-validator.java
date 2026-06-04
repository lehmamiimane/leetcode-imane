class Solution {
    public int[] scoreValidator(String[] events) {
        int[] arr = {0,0};
        for(int i = 0; i < events.length; i++){
            if(arr[1] == 10){
                break;
            }
            if(events[i].equals("W")){
                if(arr[1] < 10){
                arr[1]++;
                }
            }else if(events[i].equals("WD")){
                arr[0]++;
            }else if(events[i].equals("NB")){
                arr[0]++;
            }else{
                char ch = events[i].charAt(0);
                arr[0] += (ch - '0'); 
            }
        }
        return arr;
    }
}