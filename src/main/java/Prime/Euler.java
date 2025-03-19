package Prime;

import java.util.Arrays;

public class Euler {
    // 欧拉筛质数法(线性筛)
    final int N = 4000001;
    boolean[] isPrime = new boolean[N];
    int[] primes = new int[N]; // 用于存储质数
    int count = 0; // 质数的数量

    public Euler() {
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

    public boolean isPrime(int n) {
        return isPrime[n];
    }
}
