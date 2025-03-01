
// Input: N = 3, W = 4, profit[] = {1, 2, 3}, weight[] = {4, 5, 1}
// Output: 3
import java.util.*;
class knapsackTopDown{
    static int [][] dp;
    public static int knapsack(int[] weight, int[] profit, int w, int n) {
        // if (n == 0 || w == 0) return 0;
        // if (dp[n][w] != -1) return dp[n][w];

        // if (weight[n - 1] <= w) {
        //     return dp[n][w] = Math.max(
        //         profit[n - 1] + knapsack(weight, profit, w - weight[n - 1], n - 1),
        //         knapsack(weight, profit, w, n - 1)
        //     );
        // } else {
        //     return dp[n][w] = knapsack(weight, profit, w, n - 1);
        // }

        for( int i=0 ;i<n+1 ;i++){
            for( int j=0 ;j< w+1;j++){
                if(i==0 || j==0)
                dp[i][j]=0;
            }
        }

        for( int i=0 ;i<n+1 ;i++){
            for( int j=0 ;j< w+1;j++){
             System.out.print(dp[i][j]+"    ");
            }
            System.out.println();
        }



       for( int i=1;i<n+1 ;i++){
        for( int j=1 ;j<w+1;j++){
            if(weight[i-1]<=j){
                dp[i][j]=Math.max(profit[i-1]+dp[i-1][j-weight[i-1]],dp[i-1][j]);

            }else{
                dp[i][j]=dp[i-1][j];


            }
        }
       }
        return dp[n][w];
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