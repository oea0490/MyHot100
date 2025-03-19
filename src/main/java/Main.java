import java.util.*;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Solution solution = new Solution();
        int[][] nums = new int[][]{{1,2,3},{4,9,6},{7,8,11}};
        System.out.println(solution.diagonalPrime(nums));
    }
}

class Solution {
//    // 埃氏筛法
//    final int N = 4000001;
//    boolean[] isPrime = new boolean[N];
//    public Solution(){
//        //初始时所有数均为质数
//        Arrays.fill(isPrime, true);
//        //将0和1标记为非质数
//        isPrime[0] = false;
//        isPrime[1] = false;
//        //遍历标记后面的数
//        for(int i = 2; i < N; i++){
//            if(isPrime[i]){
//                for(int j = i * i ; j < N && j > 0 ; j += i){
//                    isPrime[j] = false;
//                }
//            }
//        }
//    }
    // 欧拉筛(线性筛)
    final int N = 4000001;
    boolean[] isPrime = new boolean[N];
    int[] primes = new int[N]; // 用于存储质数
    int count = 0; // 质数的数量

    public Solution() {
        //初始时所有数均为质数
        Arrays.fill(isPrime, true);
        //将0和1标记为非质数
        isPrime[0] = false;
        isPrime[1] = false;
        //遍历标记后面的数
        for (int i = 2; i < N; i++) {
            if (isPrime[i]) {
                primes[count++] = i; // 记录质数
            }
            for (int j = 0; j < count && i * primes[j] < N; j++) {
                isPrime[i * primes[j]] = false; // 标记合数
                if (i % primes[j] == 0) {
                    break; // 保证每个合数只被其最小质因数标记一次
                }
            }
        }
    }
    public int diagonalPrime(int[][] nums) {
        int n = nums.length;
        int ans = 0;
        for (int i = 0; i < n; i++){
            if (isPrime[nums[i][i]]){
                ans = Math.max(ans, nums[i][i]);
            }
            if (isPrime[nums[i][n - i - 1]]){
                ans = Math.max(ans, nums[i][n - i - 1]);
            }
        }
        return ans;
    }
}