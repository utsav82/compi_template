package helper;

class Hashing {
    String str;
    int n;
    long m;
    long p = 30;
    long[] powers;
    long[] inversePowers;
    long[] prefixHash;

    Hashing(String str, long m) {
        this.str = str;
        this.m = m;
        n = str.length();
        powers = new long[n];
        inversePowers = new long[n];
        prefixHash = new long[n];
        calcPowers();
        calcHash();
    }

    void calcPowers() {
        powers[0] = 1L;
        for (int i = 1; i < n; i++) {
            powers[i] = (powers[i - 1] * p) % m;
        }
        inversePowers[n - 1] = modularInverse(powers[n - 1], m);
        for (int i = n - 2; i >= 0; i--) {
            inversePowers[i] = (inversePowers[i + 1] * p) % m;
        }
    }

    void calcHash() {
        long hash = 0;
        for (int i = 0; i < n; i++) {
            hash = (hash + ((str.charAt(i) - 'a' + 1) * powers[i]) % m) % m;
            prefixHash[i] = hash;
        }
    }

    long substringHash(int l, int r) {
        long substr1 = prefixHash[r];
        long substr2 = l > 0 ? prefixHash[l - 1] : 0;
        return ((substr1 - substr2 + m) % m * inversePowers[l]) % m;
    }

    long exp(long a, long b, long m) {
        a = a % m;
        long ans = 1;
        while (b != 0) {
            if ((b & 1) != 0)
                ans = ((ans % m) * (a % m)) % m;
            a = ((a % m) * (a % m)) % m;
            b = b >> 1;
        }
        return ans;
    }

    long modularInverse(long a, long m) {
        return exp(a, m - 2, m);
    }
}
// static long subssii(Hashing str1, Hashing str2, int i, int j) {
// long subHash1 = str1.substringHash(i, j);
// long subHash2 = str2.substringHash(i, j);
// long prime = (long) 1e9 + 21;
// long finalHash = subHash1 * prime + subHash2;
// return finalHash;
// }