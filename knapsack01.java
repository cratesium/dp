// Input: N = 3, W = 4, profit[] = {1, 2, 3}, weight[] = {4, 5, 1}
// Output: 3
import java.util.*;
class knapsack01{
    static int [][] dp;
    public static int knapsack(int[] weight, int[] profit, int w, int n) {
        if (n == 0 || w == 0) return 0;
        if (dp[n][w] != -1) return dp[n][w];

        if (weight[n - 1] <= w) {
            return dp[n][w] = Math.max(
                profit[n - 1] + knapsack(weight, profit, w - weight[n - 1], n - 1),
                knapsack(weight, profit, w, n - 1)
            );
        } else {
            return dp[n][w] = knapsack(weight, profit, w, n - 1);
        }
    }


    public static void main(String[] args) {
       
        int n =3;
        int w=50;
        int profit [] = {60,100,120};
        int weight[]={10,20,30};
        dp = new int [n+1][w+1];
        for( int i =0 ; i< n+1 ;i++){
            Arrays.fill(dp[i], -1);
        }
     //   System.out.println(dp[0][0]+" "+dp[1][1]);

        int max = knapsack(weight , profit , w ,n);
        System.out.println("max profit is  :-> "+max);
        
        
    }

}