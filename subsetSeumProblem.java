public class subsetSeumProblem {
    

//     Input: arr[] = {3, 34, 4, 12, 5, 2}, int n = 6,  sum = 9
// Output: True
// Explanation: There is a subset (4, 5) with sum 9.

// knapsack01
// if(n==0 || w ==0) return 0;
// if(w[n-1]>W)
// dp[n][w]= Math.max(val[n-1]+knapsack(val,wt,n-1,w-wt[n-1])knapsack(val,wt,n-1,w),)
static boolean dp [][];
public static boolean isSubsetExists(int [] nums , int n , int sum){

  //  int w = sum;
    for(int j=0 ;j<sum+1;j++){
        dp[0][j]=false;
    }
    for(int i=0 ;i<n+1;i++){
        dp[i][0]=true;
    }

    for(int i=1 ;i<n+1;i++){

        for(int j=1 ;j<sum+1;j++){

            if(nums[i-1]<=j)
            dp[i][j]=dp[i-1][j-nums[i-1]] || dp[i-1][j];
            else{
            dp[i][j]= dp[i-1][j];
            }
            
        }
       
    }



return dp[n][sum];

}
public static void main(String[] args) {
    int n= 6;
    int sum= 9;
    int [] arr ={3,34,4,12,5,2};
    dp = new boolean[n+1][sum+1];

    System.out.println("Ans is : "+isSubsetExists(arr, n, sum));
    
}

}
