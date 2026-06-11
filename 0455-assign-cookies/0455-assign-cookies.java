class Solution {
    public int findContentChildren(int[] g, int[] s) {
         Arrays.sort(g);
    Arrays.sort(s);

    int child = 0;
    int cookie = 0;

    while (child < g.length && cookie < s.length) {
        if (s[cookie] >= g[child]) {
            child++; // cet enfant est satisfait
        }
        cookie++; // cookie utilisé ou trop petit, on passe au suivant
    }

    return child;
    }
}