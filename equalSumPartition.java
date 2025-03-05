
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

//LOGIC
//if two equal set exists then say s1 = s2 = 2s so sum of whole set divisible by 2 
//otherwise if it is odd then false;
//if yes sum is divisible by 2 then we are needed to find a set whole sum is is exactly half the sum of whole set 
//{2,4,6}=[{2,4},{6}] sum of whole set =12;
//so we will find set with sum = 12/2 => 6 so that half sum exist in 1 set other half will definitely exist in other set 

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
    System.out.println("IS Equal Sum Partiotion Possible : git"+isEqualSumPartitionPossible(arr));
    
}
// public static boolean isSubsetExists1(int [] nums , int n , int sum){
//  boolean dp [][] = new boolean[n+1][sum+1];
//  int w = sum;
//  for( int j=0 ;j<sum+1;j++){
//     dp[0][j]=false;
//  }
//  for(int i=0 ;i<n+1 ;i++){
//     dp[i][0]=true;
//  }
//  for( int i=1 ;i< n+1 ;i++){
//     for( int j=1;j<sum+1;j++){
//         if(nums[i-1]<=j){
//             dp[i][j]=dp[i-1][j-nums[i-1]]||dp[i-1][j];
//          }else{
//             dp[i][j]=dp[i-1][j];
//          }
//     }
//  }

 





// return dp[n][sum];
// }
}
