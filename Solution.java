class Solution {
    int[][]dp;
    public int maxUncrossedLines(int[] num1, int[] num2) {
        dp=new int[num1.length+1][num2.length+1];
        for(int [] arr:dp)
        {
            Arrays.fill(arr,-1);
        }
        return recursion(num1.length,num2.length,num1,num2); 
    }
    int recursion (int i,int j,int[]num1,int[]num2)
    {
        if(i==0)
            return 0;
        if (j==0)
            return 0;
        if (dp[i][j]!=-1)
            return dp[i][j];
        if (num1[i-1]==num2[j-1])
        {
            dp[i][j]=1+recursion(i-1,j-1,num1,num2);
        }
        else 
        {
            dp[i][j]=Math.max(recursion(i,j-1,num1,num2),recursion(i-1,j,num1,num2));
        }
        return dp[i][j];
        
    }
}
