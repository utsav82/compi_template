package helper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Random;
import java.util.TreeMap;
import java.util.Map.Entry;

class NumberTheory {

    /**
     * Modular Arithmetic:
     * 1. (a+b)%c=(a%c+b%c)%c
     * 2. (a*b)%c=(a%c*b%c)%c
     * 3. (a-b)%c=(a%c-b%c+c)%c
     * 4. (a/b)%c=(a%c*(b^-1)%c)%c -- (b^-1 is multiplicative modulo inverse)
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

    public static void rotateMatrix(int[][] matrix) {
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
            int k, int l) {
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

    static public ArrayList<Long> primeFactors(long n) {
        ArrayList<Long> factors = new ArrayList<>();
        long limit = (long) Math.sqrt(n);
        while (n % 2 == 0) {
            factors.add((long) 2);
            n /= 2;
        }
        for (long i = 3; i <= limit; i += 2) {
            while (n % i == 0) {
                factors.add(i);
                n /= i;
            }
        }
        if (n > 2)
            factors.add(n);
        return factors;
    }

    public ArrayList<Long> AllprimeFactors(long n) {
        ArrayList<Long> factors = new ArrayList<>();
        long limit = (long) Math.sqrt(n);
        for (long i = 2; i <= limit; i += 1) {
            while (n % i == 0) {
                factors.add(i);
                n /= i;
            }
        }
        if (n > 1) {
            factors.add(n);
        }
        return factors;
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

    static long ncr(long n, long r) {
        return (((factorials[(int) n] * invFactorials[(int) r]) % mod) * invFactorials[(int) (n - r)]) % mod;
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
            if ((a = find(a)) == (b = find(b)))
                return false;
            if (s[a] == s[b])
                s[a]--;
            if (s[a] <= s[b])
                s[b] = a;
            else
                s[a] = b;
            return true;
        }
    }

    static final Random random = new Random();
    static final int mod = 1_000_000_007;
    static long[] factorials = new long[2_000_001];
    static long[] invFactorials = new long[2_000_001];

    static void precompFacts() {
        factorials[0] = invFactorials[0] = 1;
        for (int i = 1; i < factorials.length; i++)
            factorials[i] = modularMultiplication(factorials[i - 1], i, mod);
        invFactorials[factorials.length - 1] = modularExponentiation(factorials[factorials.length - 1], mod - 2, mod);
        for (int i = invFactorials.length - 2; i >= 0; i--)
            invFactorials[i] = modularMultiplication(invFactorials[i + 1], i + 1, mod);
    }

    static long nCk(int n, int k) {
        return modularMultiplication(factorials[n], modularMultiplication(invFactorials[k], invFactorials[n - k], mod),
                mod);
    }

    static void sort(int[] a) {
        ArrayList<Integer> l = new ArrayList<>();
        for (int i : a)
            l.add(i);
        Collections.sort(l);
        for (int i = 0; i < a.length; i++)
            a[i] = l.get(i);
    }

    static void ruffleSort(int[] a) {
        int n = a.length;// shuffle, then sort
        for (int i = 0; i < n; i++) {
            int oi = random.nextInt(n), temp = a[oi];
            a[oi] = a[i];
            a[i] = temp;
        }
        Arrays.sort(a);
    }

    static class Pair implements Comparable<Pair> {
        int i, j;
        long cost;

        public Pair(int i, int j, long cost) {
            this.i = i;
            this.j = j;
            this.cost = cost;
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

class Pair implements Comparable<Pair> {
    int i, j;
    long cost;

    public Pair(int i, int j, long cost) {
        this.i = i;
        this.j = j;
        this.cost = cost;

    }

    public Pair(int x, int y) {
        this.i = x;
        this.j = y;
    }

    public int compareTo(Pair o) {

        int x = Long.compare(i, o.i);

        if (x == 0) {
            x = Long.compare(j, o.j);
        }

        return x;

    }

    // @Override
    // public boolean equals(Object obj) {
    // if (this == obj)
    // return true;
    // if (obj == null)
    // return false;
    // if (getClass() != obj.getClass())
    // return false;
    // Pair other = (Pair) obj;
    // if (i != other.i)
    // return false;
    // if (j != other.j)
    // return false;
    // return true;
    // }

    // @Override
    // public int hashCode() {
    // final int prime = 31;
    // int result = 1;
    // result = prime * result + i;
    // result = prime * result + j;
    // return result;
    // }

    static int lower_bound(int[] array, int key) {

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

    public static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void swap(char[] a, int i, int j) {
        char temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static class Multiset<T> {
        public TreeMap<T, Integer> map;
        public int size = 0;

        public Multiset() {
            map = new TreeMap<>();
        }

        public Multiset(T[] a) {
            map = new TreeMap<>();
            size = a.length;
            for (int i = 0; i < a.length; i++) {
                map.put(a[i], map.getOrDefault(a[i], 0) + 1);
            }
        }

        void add(T a) {
            size++;
            map.put(a, map.getOrDefault(a, 0) + 1);
        }

        void remove(T a) {
            size--;
            int val = map.get(a);
            map.put(a, val - 1);
            if (val == 1)
                map.remove(a);
        }

        void removeAll(int a) {
            if (map.containsKey(a)) {
                size -= map.get(a);
                map.remove(a);
            }
        }

        T ceiling(T a) {
            return map.ceilingKey(a);
        }

        T floor(T a) {
            return map.floorKey(a);
        }

        T lower(T a) {
            return map.lowerKey(a);
        }

        T higher(T a) {
            return map.higherKey(a);
        }

        T first() {
            return map.firstKey();
        }

        T last() {
            return map.lastKey();
        }

        boolean contains(T a) {
            return map.containsKey(a);
        }

        int size() {
            return size;
        }

        void clear() {
            map.clear();
        }

        T poll() {
            if (map.size() == 0) {
                return null;
            }
            size--;
            T first = map.firstKey();
            if (map.get(first) == 1) {
                map.pollFirstEntry();
            } else
                map.put(first, map.get(first) - 1);
            return first;
        }

        T polllast() {
            if (map.size() == 0) {
                return null;
            }
            size--;
            T last = map.lastKey();
            if (map.get(last) == 1) {
                map.pollLastEntry();
            } else
                map.put(last, map.get(last) - 1);
            return last;
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

    static int arraySortedOrNot(int arr[], int n) {

        if (n == 1 || n == 0)
            return 1;

        if (arr[n - 1] >= arr[n - 2])
            return 0;

        return arraySortedOrNot(arr, n - 1);
    }

    public static <T extends Comparable<T>> T max(T a, T b) {
        if (a.compareTo(b) >= 0) {
            return a;
        } else {
            return b;
        }
    }

    public static <T extends Comparable<T>> T min(T a, T b) {
        if (a.compareTo(b) < 0) {
            return a;
        } else {
            return b;
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
            if ((a = find(a)) == (b = find(b)))
                return false;
            if (s[a] == s[b])
                s[a]--;
            if (s[a] <= s[b])
                s[b] = a;
            else
                s[a] = b;
            return true;
        }
    }

    public static long gcd(long a, long b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }

    public static int gcd(int a, int b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }

    public static long lcm(long a, long b) {
        return (a * b) / gcd(a, b);
    }

    public int lcm(int a, int b) {
        return (a * b) / gcd(a, b);
    }

    static boolean isPrime(long n) {
        for (long i = 2; i <= n / 2; i++)
            if (n % i == 0)
                return false;

        return true;
    }

    static boolean isPrime(int n) {
        for (int i = 2; i <= Math.sqrt(n); i++)
            if (n % i == 0)
                return false;
        return n > 1;
    }

    static class SegmentTree {
        long[] seg, lazy;

        SegmentTree(int n) {
            seg = new long[4 * n];
            lazy = new long[4 * n];
        }

        void build(int low, int high, int ind, long[] arr) {
            if (low == high) {
                seg[ind] = arr[low];
                return;
            }

            int mid = low + ((high - low) >> 1);

            build(low, mid, 2 * ind + 1, arr);
            build(mid + 1, high, 2 * ind + 2, arr);

            seg[ind] = seg[2 * ind + 1] + seg[2 * ind + 2];
        }

        void rangeUpdate(int l, int r, int low, int high, int ind, long val) {
            if (lazy[ind] != 0) {
                seg[ind] += (high - low + 1) * lazy[ind];
                if (low != high) {
                    lazy[2 * ind + 1] += lazy[ind];
                    lazy[2 * ind + 2] += lazy[ind];
                }
                lazy[ind] = 0;
            }

            if (l > high || r < low)
                return;

            if (l <= low && high <= r) {
                seg[ind] += (long) (high - low + 1) * val;

                if (low != high) {
                    lazy[2 * ind + 1] += val;
                    lazy[2 * ind + 2] += val;
                }
                return;
            }

            int mid = low + ((high - low) >> 1);

            rangeUpdate(l, r, low, mid, 2 * ind + 1, val);
            rangeUpdate(l, r, mid + 1, high, 2 * ind + 2, val);

            seg[ind] = seg[2 * ind + 1] + seg[2 * ind + 2];
        }

        long query(int l, int r, int low, int high, int ind) {
            if (lazy[ind] != 0) {
                seg[ind] += (high - low + 1) * lazy[ind];

                if (low != high) {
                    lazy[2 * ind + 1] += lazy[ind];
                    lazy[2 * ind + 2] += lazy[ind];
                }
                lazy[ind] = 0;
            }

            if (r < low || l > high)
                return 0;

            if (l <= low && high <= r) {
                return seg[ind];
            }

            int mid = low + ((high - low) >> 1);
            long left = query(l, r, low, mid, 2 * ind + 1);
            long right = query(l, r, mid + 1, high, 2 * ind + 2);

            return left + right;
        }
    }

    public static int countSetBits(long number) {
        int count = 0;
        while (number > 0) {
            ++count;
            number &= number - 1;
        }
        return count;
    }

    static boolean isPowerOfTwo(long x) {

        return x != 0 && ((x & (x - 1)) == 0);
    }

    static public ArrayList<Long> primeFactors(long n) {
        ArrayList<Long> factorials = new ArrayList<>();
        long limit = (long) Math.sqrt(n);
        while (n % 2 == 0) {
            factorials.add((long) 2);
            n /= 2;
        }
        for (long i = 3; i <= limit; i += 2) {
            while (n % i == 0) {
                factorials.add(i);
                n /= i;
            }
        }
        if (n > 2)
            factorials.add(n);
        return factorials;
    }

    public static int max(int[] elementData) {

        int max = elementData[0];
        for (int i = 1; i < elementData.length; i++) {
            if (elementData[i] > max) {
                max = elementData[i];
            }
        }
        return max;
    }

    public static int min(int[] array) {
        int min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (min > array[i]) {
                min = array[i];
            }
        }
        return min;
    }

    public static long max(long[] elementData) {

        long max = elementData[0];
        for (int i = 1; i < elementData.length; i++) {
            if (elementData[i] > max) {
                max = elementData[i];
            }
        }
        return max;
    }

    public static long min(long[] array) {
        long min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (min > array[i]) {
                min = array[i];
            }
        }
        return min;
    }

    public static long max(int i, long l) {
        return Math.max(i, l);

    }

    public static void reverse(int[] array) {

        int n = array.length;

        for (int i = 0; i < n / 2; i++) {

            int temp = array[i];

            array[i] = array[n - i - 1];

            array[n - i - 1] = temp;
        }
    }

    public static void reverse(long[] array) {

        int n = array.length;

        for (int i = 0; i < n / 2; i++) {

            long temp = array[i];

            array[i] = array[n - i - 1];

            array[n - i - 1] = temp;
        }
    }

    static void sort(int[] a) {
        ArrayList<Integer> l = new ArrayList<>();
        for (int i : a)
            l.add(i);
        Collections.sort(l);
        for (int i = 0; i < a.length; i++)
            a[i] = l.get(i);
    }

    static void sort(long[] a) {
        ArrayList<Long> l = new ArrayList<>();
        for (long i : a)
            l.add(i);
        Collections.sort(l);
        for (int i = 0; i < a.length; i++)
            a[i] = l.get(i);
    }

    static public int modularAddition(int a, int b, int MOD) {
        return (a % MOD + b % MOD) % MOD;
    }

    static public long modularAddition(long a, long b, long MOD) {
        return (a % MOD + b % MOD) % MOD;
    }

    static public int modularMultiplication(int a, int b, int MOD) {
        return ((a % MOD) * (b % MOD)) % MOD;
    }

    static public long modularMultiplication(long a, long b, long MOD) {
        return ((a % MOD) * (b % MOD)) % MOD;
    }

    static public int modularSubtraction(int a, int b, int MOD) {
        return (a % MOD - b % MOD + MOD) % MOD;
    }

    static public long modularSubtraction(long a, long b, long MOD) {
        return (a % MOD - b % MOD + MOD) % MOD;
    }

    public static int binaryExponentiation(int x, int n) {
        if (n == 0)
            return 1;
        else if (n % 2 == 0)
            return binaryExponentiation(x * x, n / 2);
        else
            return x * binaryExponentiation(x * x, (n - 1) / 2);
    }

    public static long binaryExponentiation(long x, long n) {
        long result = 1;
        while (n > 0) {
            if (n % 2 == 1)
                result *= x;
            x = x * x;
            n /= 2;
        }
        return result;
    }

    public static int modularExponentiation(int x, int n, int MOD) {
        if (n == 0)
            return 1 % MOD;
        else if (n % 2 == 0)
            return modularExponentiation(modularMultiplication(x, x, MOD), n / 2, MOD);
        else
            return modularMultiplication(x,
                    modularExponentiation(modularMultiplication(x, x, MOD), (n - 1) / 2, MOD),
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
}
