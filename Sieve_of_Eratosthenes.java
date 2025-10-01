class Main {
    static int[] sieve(int n) {
        
        // creation of boolean array
        boolean[] prime = new boolean[n + 1];
        for (int i = 0; i <= n; i++) {
            prime[i] = true;
        }
 
        for (int p = 2; p * p <= n; p++) {
            if (prime[p]) {
                // marking as false
                for (int i = p * p; i <= n; i += p)
                    prime[i] = false;
            }
        }
 
        // Count number of primes
        int count = 0;
        for (int p = 2; p <= n; p++) {
            if (prime[p])
                count++;
        }
 
        // Store primes in an array
        int[] res = new int[count];
        int index = 0;
        for (int p = 2; p <= n; p++) {
            if (prime[p])
                res[index++] = p;
        }
 
        return res;
    }
 
    public static void main(String[] args) {
        int n = 35;
        int[] res = sieve(n);
        for (int ele : res) {
            System.out.print(ele + " ");
        }
    }
}

// Output
// 2 3 5 7 11 13 17 19 23 29 31 

// Time Complexity: O(n*log(log(n))). For each prime number, we mark its multiples, which takes around n/p steps. The total time is proportional to n*(1/2 + 1/3 + 1/5 + ....).
// This sum over primes grows slowly and is approximately O(n*log(log(n))) making the algorithm very efficient.

// Auxiliary Space: O(n)
