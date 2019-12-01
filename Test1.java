如果序列 X_1, X_2, ..., X_n 满足下列条件，就说它是 斐波那契式 的：

n >= 3
对于所有 i + 2 <= n，都有 X_i + X_{i+1} = X_{i+2}
给定一个严格递增的正整数数组形成序列，找到 A 中最长的斐波那契式的子序列的长度。如果一个不存在，返回  0 。

（回想一下，子序列是从原序列 A 中派生出来的，它从 A 中删掉任意数量的元素（也可以不删），而不改变其余元素的顺序。例如， [3, 5, 8] 是 [3, 4, 5, 6, 7, 8] 的一个子序列）

 
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/length-of-longest-fibonacci-subsequence
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
class Solution {
    public int lenLongestFibSubseq(int[] A) {
        int[][] dp=new int[A.length+1][A.length+1];
        int res=0;
        for(int i=1;i<A.length;i++){
                int l=0;
                int r=i-1;
                while(l<r){
                    int sum=A[l]+A[r];
                    if(sum==A[i]){
                        dp[r][i]=Math.max(dp[r][i],dp[l][r]+1);
                        res=Math.max(res,dp[r][i]);
                        l++;
                        r--;
                    }else if(sum<A[i]){
                        l++;
                    }else{
                        r--;
                    }
            }
        }
        return res==0?0:res+2;
    }
}

给定一个整数数组  nums 和一个正整数 k，找出是否有可能把这个数组分成 k 个非空子集，
其总和都相等。

class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
        }
        if(sum%k!=0){
            return false;
        }
        sum/=k;
        Arrays.sort(nums);
        int[] res=new int[k];
        return canPartitionKSubsets(nums.length-1,res,nums,k,sum);
    }
    private boolean canPartitionKSubsets(int n,int[] res,int[] nums, int k,int sum){
        if(n<0){
            int i=0;
            for(;i<res.length;i++){
                if(res[i]!=sum){
                    break;
                }
            }
            return i==res.length;
        }
        for(int i=0;i<k;i++){
            if(res[i]+nums[n]>sum){
                continue;
            }
            res[i]+=nums[n];
            if(canPartitionKSubsets(n-1,res,nums,k,sum)){
                return true;
            }
            res[i]-=nums[n];
        }
        return false;
    }
}


