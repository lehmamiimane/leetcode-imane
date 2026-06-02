class Solution {
    public String capitalizeTitle(String title) {
        char[] c = title.toCharArray();
        int len = 0;
        for(int i = 0; i <= c.length; i++){
            if(i < c.length && c[i] != ' '){
                if(c[i] < 'a') c[i] +=  32;
                len++;
            }
            else{
                if(len > 2){
                    c[i - len] -= 32;
                }
                len = 0;
            }
        }
        return String.valueOf(c);
    }
}