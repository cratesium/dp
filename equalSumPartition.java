
public class equalSumPartition {
public static boolean isSubsetExists(int [] nums , int n , int sum){
    boolean dp [][] = new boolean[n+1][sum+1];

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
public  static boolean isEqualSumPartitionPossible(int [] nums  ){
   int sum =0;
   for(int i : nums)
   sum+=i;
   if(sum%2!=0) return false;
   
   else  return isSubsetExists(nums, nums.length, sum/2);

}
public static void main(String[] args) {
    int [] arr ={2,4,6};
    System.out.println(isEqualSumPartitionPossible(arr));
    
}
}
