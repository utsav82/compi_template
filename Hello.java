import java.util.Scanner;

public class Hello {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            long k = sc.nextLong();
            int p1 = sc.nextInt() - 1;
            int p2 = sc.nextInt() - 1;
            int p[] = new int[n];
            long a[] = new long[n];
            for (int i = 0; i < n; i++) {
                p[i] = sc.nextInt() - 1;
            }
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextLong();
            }

            int p1copy = p1;
            int p2copy = p2;

            long bodya = a[p1] * k;
            long fx = a[p1];
            long curr = a[p1];
            p1 = p[p1];
            long steps = k - 1;
            int i = p1;
            while (steps > 0 && i != p1copy) {
                curr += a[i];
                fx = Math.max(fx, a[i]);
                i = p[i];
                steps--;
                long temp = curr + (steps * fx);
                bodya = Math.max(bodya, temp);
            }

            long sasha = a[p2] * k;
            long sx = a[p2];
            curr = a[p2];
            p2 = p[p2];
            steps = k - 1;
            i = p2;
            while (steps > 0 && i != p2copy) {
                curr += a[i];
                sx = Math.max(sx, a[i]);
                i = p[i];
                steps--;
                long temp = curr + (steps * sx);
                sasha = Math.max(sasha, temp);
            }

            // out.println(bodya + " " + sasha);
            if (sasha == bodya) {
                System.out.println("Draw");
            } else if (sasha > bodya) {
                System.out.println("Sasha");
            } else {
                System.out.println("Bodya");
            }
        }
        sc.close();
    }
}
