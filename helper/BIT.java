package helper;

class BIT {
    int n;
    long tree[];

    public BIT(int n) {
        this.n = n;
        tree = new long[n + 1];
    }

    void update(int i, long val) {
        for (i++; i <= n; i += i & -i)
            tree[i] += val;
    }

    long read(int i) {
        long sum = 0;
        for (i++; i > 0; i -= i & -i)
            sum += tree[i];
        return sum;
    }

    long query(int l, int r) {
        return read(r) - read(l - 1);
    }

    int getKth(int k) {
        if (k < 0)
            return -1;
        int i = 0;
        for (int p = Integer.highestOneBit(n); p > 0; p >>= 1)
            if (i + p <= n && tree[i + p] <= k)
                k -= tree[i += p];
        return i;
    }
}
