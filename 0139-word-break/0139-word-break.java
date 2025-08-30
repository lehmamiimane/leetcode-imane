class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
          int n = s.length();
    Set<String> dict = new HashSet<>(wordDict);

    int maxLen = 0;                          // optional optimization
    for (String w : wordDict) maxLen = Math.max(maxLen, w.length());

    boolean[] dp = new boolean[n + 1];
    dp[0] = true;

    for (int i = 1; i <= n; i++) {
        // Only check up to maxLen chars back
        int start = Math.max(0, i - maxLen);
        for (int j = i - 1; j >= start; j--) {
            if (dp[j] && dict.contains(s.substring(j, i))) {
                dp[i] = true;
                break;                        // no need to check further
            }
        }
    }
    return dp[n];
    }
}