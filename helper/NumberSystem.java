package helper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Random;
import java.util.Map.Entry;

class NumberTheory {

    /**
     * Modular Arithmetic:
     * 1. (a+b)%c=(a%c+b%c)%c
     * 2. (a*b)%c=(a%c*b%c)%c
     * 3. (a-b)%c=(a%c-b%c+c)%c
     * 4. (a/b)%c=(a%c*(b^-1)%c)%c --   (b^-1 is multiplicative modulo inverse)
     */
    // Modular Addition
    public int modularAddition(int a, int b, int MOD) {
        return (a % MOD + b % MOD) % MOD;
    }

    public long modularAddition(long a, long b, long MOD) {
        return (a % MOD + b % MOD) % MOD;
    }

    // Modular Multiplication
    public int modularMultiplication(int a, int b, int MOD) {
        return ((a % MOD) * (b % MOD)) % MOD;
    }

    public static long modularMultiplication(long a, long b, long MOD) {
        return ((a % MOD) * (b % MOD)) % MOD;
    }

    // Modular Subtraction
    public int modularSubtraction(int a, int b, int MOD) {
        return (a % MOD - b % MOD + MOD) % MOD;
    }

    public long modularSubtraction(long a, long b, long MOD) {
        return (a % MOD - b % MOD + MOD) % MOD;
    }

    /**
     * Binary Exponentiation
     */
    public int binaryExponentiation(int x, int n) {
        if (n == 0)
            return 1;
        else if (n % 2 == 0)
            return binaryExponentiation(x * x, n / 2);
        else
            return x * binaryExponentiation(x * x, (n - 1) / 2);
    }

    public long binaryExponentiation(long x, long n) {
        long result = 1;
        while (n > 0) {
            if (n % 2 == 1)
                result *= x;
            x = x * x;
            n /= 2;
        }
        return result;
    }

    static int countTrailingZero(int x) {

        int lookup[] = { 32, 0, 1, 26, 2, 23,
                27, 0, 3, 16, 24, 30,
                28, 11, 0, 13, 4, 7,
                17, 0, 25, 22, 31, 15,
                29, 10, 12, 6, 0, 21,
                14, 9, 5, 20, 8, 19, 18 };

        return lookup[(-x & x) % 37];
    }
    static long highestPowerof2(long n) {

        n |= n >> 1;
        n |= n >> 2;
        n |= n >> 4;
        n |= n >> 8;
        n |= n >> 16;

        return n ^ (n >> 1);
    }
    public static void rotateMatrix(int[][] matrix)
    {
        int n = matrix.length;
 
       
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                swap(matrix, i, j, j, i);
            }
        }
       
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                swap(matrix, j, i, n - j - 1, i);
            }
        }

    }
 
    private static void swap(int[][] matrix, int i, int j,
                             int k, int l)
    {
        int temp = matrix[i][j];
        matrix[i][j] = matrix[k][l];
        matrix[k][l] = temp;
    }
    /**
     * Modular Exponentiation
     */
    public int modularExponentiation(int x, int n, int MOD) {
        if (n == 0)
            return 1 % MOD;
        else if (n % 2 == 0)
            return modularExponentiation(modularMultiplication(x, x, MOD), n / 2, MOD);
        else
            return modularMultiplication(x, modularExponentiation(modularMultiplication(x, x, MOD), (n - 1) / 2, MOD),
                    MOD);
    }

    public static long modularExponentiation(long x, long n, long MOD) {
        long result = 1;
        while (n > 0) {
            if (n % 2 == 1)
                result = modularMultiplication(result, x, MOD);
            x = modularMultiplication(x, x, MOD);
            n /= 2;
        }
        return result;
    }

    /**
     * Factorial of a number
     */
    public long factorials(long n) {
        if (n == 0)
            return 1;
        return n * factorials(n - 1);
    }

    /**
     * Prime factors of a number
     */
    public ArrayList<Integer> distinctPrimeFactors(int n) {
        ArrayList<Integer> factorials = new ArrayList<>();
        int limit = (int) Math.sqrt(n);
        if (n % 2 == 0) {
            factorials.add(2);
            while (n % 2 == 0)
                n /= 2;
        }
        for (int i = 3; i <= limit; i += 2) {
            if (n % i == 0) {
                factorials.add(i);
                while (n % i == 0)
                    n /= i;
            }
        }
        if (n > 2)
            factorials.add(n);
        return factorials;
    }

    public ArrayList<Long> distinctPrimeFactors(long n) {
        ArrayList<Long> factorials = new ArrayList<>();
        long limit = (long) Math.sqrt(n);
        if (n % 2 == 0) {
            factorials.add((long) 2);
            while (n % 2 == 0)
                n /= 2;
        }
        for (long i = 3; i <= limit; i += 2) {
            if (n % i == 0) {
                factorials.add(i);
                while (n % i == 0)
                    n /= i;
            }
        }
        if (n > 2)
            factorials.add(n);
        return factorials;
    }

    public ArrayList<Integer> primeFactors(int n) {
        ArrayList<Integer> factorials = new ArrayList<>();
        int limit = (int) Math.sqrt(n);
        if (n % 2 == 0) {
            factorials.add(2);
            while (n % 2 == 0)
                n /= 2;
        }
        for (int i = 3; i <= limit; i += 2) {
            if (n % i == 0) {
                factorials.add(i);
                while (n % i == 0)
                    n /= i;
            }
        }
        if (n > 2)
            factorials.add(n);
        return factorials;
    }

    public ArrayList<Long> primeFactors(long n) {
        ArrayList<Long> factorials = new ArrayList<>();
        long limit = (long) Math.sqrt(n);
        if (n % 2 == 0) {
            factorials.add((long) 2);
            while (n % 2 == 0)
                n /= 2;
        }
        for (long i = 3; i <= limit; i += 2) {
            if (n % i == 0) {
                factorials.add(i);
                while (n % i == 0)
                    n /= i;
            }
        }
        if (n > 2)
            factorials.add(n);
        return factorials;
    }

    /**
     * Combination: nCr
     */
    // Naive version
    // (n,r)=(n-1,r-1)+(n-1,r) for r!=0 or r!=n
    // (n,0)=(n,n)=1
    public int binomialCoefficientRecursive(int n, int k) {
        if (k == 0 || k == n)
            return 1;// base case
        return binomialCoefficientRecursive(n - 1, k - 1) + binomialCoefficientRecursive(n - 1, k);// recursion
    }

    // Dynamic Programming version(Uses bottom up approach to fill the table)
    // Time complexity: O(n*k)
    // Space complexity: O(n*k)
    public long binomialCoefficientIterative(int n, int k) {
        long[][] C = new long[n + 1][k + 1];
        for (int i = 0; i <= n; ++i) {
            for (int j = 0; j <= Math.min(n, k); ++j) {
                if (j == 0 || j == i)
                    C[i][j] = 1;
                else
                    C[i][j] = C[i - 1][j - 1] + C[i - 1][j];
            }
        }
        return C[n][k];
    }

    // Pascal's Triangle version(Space efficient program)
    // Time complexity: O(n*k)
    // Space complexity: O(k)
    public long nCr(int n, int r) {
        int[] C = new int[r + 1];
        C[0] = 1;// nC0=1
        for (int i = 1; i <= n; ++i)
            for (int j = Math.min(i, r); j > 0; --j)
                C[j] = C[j] + C[j - 1];
        return C[r];
    }

    /**
     * Catlan number:
     * - Time complexity: O(n*n)
     * - Auxiliary space: O(n)
     *
     * NOTE: Time complexity could be reduced to O(n) but it is
     * possible if and only if n is small or else there is
     * a chance of getting an overflow. To decrease the time
     * complexity to O(n) just remember nCr=nCn-r
     */
    public long catlanNumber(int n) {
        long[] catlan = new long[n + 1];
        catlan[0] = catlan[1] = 1;
        for (int i = 2; i <= n; ++i)
            for (int j = 0; j < i; ++j)
                catlan[i] += catlan[j] * catlan[i - 1 - j];

        return catlan[n];
    }

    /**
     * Greatest Common Divisor(GCD)
     * - It is also known as Highest Common Factor(HCF)
     * - Time complexity: log(min(a,b))
     * - Auxiliary Space: O(1)
     */
    public int gcd(int a, int b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }

    static long sumDigits(long no) {
        if (no == 0) {
            return 0;
        }

        return (no % 10) + sumDigits(no / 10);
    }

    static void reverse(long[] arr, int l, int r) {
        int d = (r - l + 1) / 2;
        for (int i = 0; i < d; i++) {
            long t = arr[l + i];
            arr[l + i] = arr[r - i];
            arr[r - i] = t;
        }

    }

    static long power(long x, long y, long p) {
        long res = 1;

        x = x % p;

        if (x == 0)
            return 0;

        while (y > 0) {

            if ((y & 1) != 0)
                res = (res * x) % p;

            y = y >> 1;
            x = (x * x) % p;
        }
        return res;
    }

    static long modInverse(long b, long m) {

        return (long) power(b, m - 2, m);

    }

    public long gcd(long a, long b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }

    /**
     * Extended Euclid's Algorithm:
     * - ax+by=gcd(a,b)
     * - Time complexity:
     * -
     */

    /**
     * Least Common Multiple(LCM):
     * - Time complexity: log(min(a,b))
     * - Auxiliary Space: O(1)
     */
    public long lcm(long a, long b) {
        return (a * b) / gcd(a, b);
    }

    static boolean isPowerOfTwo(int x) {
        /*
         * First x in the below expression is
         * for the case when x is 0
         */
        return x != 0 && ((x & (x - 1)) == 0);
    }

    static void freq() {
        int n = 0;
        int arr[] = new int[n];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (map.containsKey(arr[i])) {
                map.put(arr[i], map.get(arr[i]) + 1);
            } else {
                map.put(arr[i], 1);
            }
        }
        for (Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }

    }

    static class DisjointSet {
		int[] s;
		
		public DisjointSet(int n) {
			Arrays.fill(s = new int[n], -1);
		}
		
		public int find(int i) {
			return s[i] < 0 ? i : (s[i] = find(s[i]));
		}
		
		public boolean union(int a, int b) {
			if ((a = find(a)) == (b = find(b))) return false;
			if(s[a] == s[b]) s[a]--;
			if(s[a] <= s[b]) s[b] = a; 
			else s[a] = b;
			return true;
		}
	}
    static final Random random=new Random();
	static final int mod=1_000_000_007;
    static long[] factorials=new long[2_000_001];
	static long[] invFactorials=new long[2_000_001];
	static void precompFacts() {
		factorials[0]=invFactorials[0]=1;
		for (int i=1; i<factorials.length; i++) factorials[i]=modularMultiplication(factorials[i-1], i,mod);
		invFactorials[factorials.length-1]=modularExponentiation(factorials[factorials.length-1], mod-2,mod);
		for (int i=invFactorials.length-2; i>=0; i--)
			invFactorials[i]=modularMultiplication(invFactorials[i+1], i+1,mod);
	}
	
	static long nCk(int n, int k) {
		return modularMultiplication(factorials[n], modularMultiplication(invFactorials[k], invFactorials[n-k],mod),mod);
	}
	
	static void sort(int[] a) {
		ArrayList<Integer> l=new ArrayList<>();
		for (int i:a) l.add(i);
		Collections.sort(l);
		for (int i=0; i<a.length; i++) a[i]=l.get(i);
	}
   
	
	static void ruffleSort(int[] a) {
		int n=a.length;//shuffle, then sort 
		for (int i=0; i<n; i++) {
			int oi=random.nextInt(n), temp=a[oi];
			a[oi]=a[i]; a[i]=temp;
		}
		Arrays.sort(a);
	}
    static class Pair implements Comparable<Pair> {
		int i, j;
		long cost;
		public Pair(int i, int j, long cost) {
			this.i=i;
			this.j=j;
			this.cost=cost;
		}
		public int compareTo(Pair o) {
			return -Long.compare(cost, o.cost);
		}
	}

  static int lower_bound(long array[], long key) {

    int low = 0, high = array.length;
    int mid;

    while (low < high) {

        mid = low + (high - low) / 2;

        if (key <= array[mid]) {
            high = mid;
        }

        else {

            low = mid + 1;
        }
    }

    if (low < array.length && array[low] < key) {
        low++;
    }

    return low;
}
}