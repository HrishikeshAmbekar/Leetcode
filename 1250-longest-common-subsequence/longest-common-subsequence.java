class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length()][text2.length()];
        for(int[] row :dp){
            Arrays.fill(row,-1);
        }
        return helper(text1,text2,text1.length()-1,text2.length()-1,dp);
    }
    public int helper(String text1, String text2, int i,int j,int[][] dp){
        if(text1.equals(text2)){
            return text1.length();
        }
        if(i<0 || j<0){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        if(text1.charAt(i)==text2.charAt(j)){
            dp[i][j] =helper(text1,text2,i-1,j-1,dp)+1;
            return dp[i][j];
        }
        else{
            dp[i][j] = Math.max(helper(text1,text2,i,j-1,dp),helper(text1,text2,i-1,j,dp));
            return dp[i][j];
        }
    }
}