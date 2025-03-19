package Prime;

import java.util.Arrays;

public class Eratosthenes {
    // 埃氏筛质数法
    final int N = 4000001;
    boolean[] isPrime = new boolean[N];

    public Eratosthenes(){
        //初始时所有数均为质数
        Arrays.fill(isPrime, true);
        //将0和1标记为非质数
        isPrime[0] = false;
        isPrime[1] = false;
        //遍历标记后面的数
        for(int i = 2; i < N; i++){
            if(isPrime[i]){
                for(int j = i * i ; j < N && j > 0 ; j += i){
                    isPrime[j] = false;
                }
            }
        }
    }
    public boolean isPrime(int n){
        return isPrime[n];
    }
}