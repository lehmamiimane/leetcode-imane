class Solution {
    public int integerBreak(int n) {
        if (n <= 3) return n - 1;
        long res = 1;
        while (n > 4) {  // peel off 3s
            res *= 3;
            n -= 3;
        }
        return (int)(res * n);
    }
}