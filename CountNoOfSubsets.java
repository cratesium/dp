public class CountNoOfSubsets {
//     Input: arr[] = [1, 2, 3, 3], target = 6 
// Output: 3 
// Explanation:// All the possible subsets are [1, 2, 3], [1, 2, 3] and [3, 3]

public static int solve(int [] nums , int n , int w){
    int dp[][] = new int [n+1][w+1];
    for( int j=0 ;j<w+1 ;j++){
        dp[0][j]=0;

    }
    for(int i=0 ;i< n+1 ;i++){
       dp[i][0]=1;
    }
    for( int i=1 ;i< n+1;i++){
        for( int j =1 ;j<w+1 ;j++){
            if(nums[i-1]<=j){
                 dp[i][j]=dp[i-1][j-nums[i-1]]+dp[i-1][j];
            }else{
                    dp[i][j] = dp[i-1][j];
            }
        }
    }

    return dp [n][w];
}
 public static void main(String[] args) {
    
int [] arr ={1,2,3,3};
int w =6 ;
int n = arr.length;
System.out.println("total no of possible subsets are : "+solve(arr, n, w));
//
/**n==0 w ==0 return 0
 * if(wt[n-1]<=w)
 * 
 * 
 * 
 * 
 * 
 * 
 *  ; */


 }

    
}
