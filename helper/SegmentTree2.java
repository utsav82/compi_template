package helper;

public class SegmentTree2 {
    static final int INF = Integer.MAX_VALUE;
    static final int MAXN = 2 * 100000;
    static int[][] t = new int[4 * MAXN + 1][4];

    int[] combine(int[] a, int[] b) {

        if (a[0] == -1)
            return b;
        if (b[0] == -1)
            return a;

        if (a[0] == b[0]) {

            if (a[1] > b[1]) {
                return new int[] { a[0], a[1], a[2] + b[2], a[3] };
            }
            if (a[1] < b[1]) {
                return new int[] { b[0], b[1], a[2] + b[2], b[3] };
            }
            return new int[] { a[0], a[1], a[2] + b[2], a[3] + b[3] };

        } else {

            if (a[0] > b[0]) {

                if (a[1] > b[0]) {
                    return new int[] { a[0], a[1], a[2], a[3] };
                }
                if (a[1] < b[0]) {
                    return new int[] { a[0], b[0], a[2], b[2] };
                }
                return new int[] { a[0], a[1], a[2], a[3] + b[2] };

            } else {

                if (b[1] > a[0]) {
                    return new int[] { b[0], b[1], b[2], b[3] };
                }
                if (b[1] < a[0]) {
                    return new int[] { b[0], a[0], b[2], a[2] };
                }
                return new int[] { b[0], b[1], b[2], b[3] + a[2] };
            }
        }

    }

    void build(int[] a, int v, int tl, int tr) {
        if (tl == tr) {
            t[v] = new int[] { a[tl], 0, 1, 0 };
        } else {
            int tm = (tl + tr) / 2;
            build(a, v * 2 + 1, tl, tm);
            build(a, v * 2 + 2, tm + 1, tr);
            t[v] = combine(t[v * 2 + 1], t[v * 2 + 2]);
        }
    }

    int[] getMax(int v, int tl, int tr, int l, int r) {

        if (r < tl || l > tr)
            return new int[] { -1, -1, -1, -1 };

        if (l <= tl && tr <= r) {
            return t[v];
        }

        int tm = (tl + tr) / 2;
        return combine(getMax(v * 2 + 1, tl, tm, l, r),
                getMax(v * 2 + 2, tm + 1, tr, l, r));
    }

    void update(int v, int tl, int tr, int pos, int new_val) {
        if (tl == tr) {
            t[v] = new int[] { new_val, 0, 1, 0 };
        } else {
            int tm = (tl + tr) / 2;
            if (pos <= tm)
                update(v * 2 + 1, tl, tm, pos, new_val);
            else
                update(v * 2 + 2, tm + 1, tr, pos, new_val);
            t[v] = combine(t[v * 2 + 1], t[v * 2 + 2]);
        }
    }
}
