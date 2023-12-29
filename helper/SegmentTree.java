package helper;

class SegmentTree {
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
