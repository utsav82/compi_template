package helper;

import java.util.*;
import java.io.*;
import java.math.*;

public class Copy {

    static long mod = (long) (1e9 + 7);
    static final Random random = new Random();
    static long[] factorials;
    static long[] invFactorials;

    public static void main(String[] args) throws IOException {

        // precompFacts();
        boolean multiple = true;
        InputReader sc = new InputReader(System.in);
        OutputWriter out = new OutputWriter(System.out);
        Problem solver = new Problem();
        int testCount = 1;
        if (multiple) {
            testCount = sc.nextInt();
        }

        for (int i = 1; i <= testCount; i++) {
            // out.print("Case #" + i + ": ");
            solver.solve(i, sc, out);
        }

        out.close();
    }

    static class Problem {

        public void solve(int testNumber, InputReader sc, OutputWriter out) {

            int n = sc.nextInt();
        }
    }

    static class Pair implements Comparable<Pair> {
        long i;
        long j;
        long cost;

        public Pair(long i, long j) {
            this.i = i;
            this.j = j;
        }

        public Pair(long i, long j, long cost) {
            this.i = i;
            this.j = j;
            this.cost = cost;
        }

        @Override
        public int compareTo(Pair o) {
            int cmp = Long.compare(i, o.i);
            return cmp != 0 ? cmp : Long.compare(j, o.j);
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null || getClass() != obj.getClass())
                return false;
            Pair pair = (Pair) obj;
            return i == pair.i && j == pair.j;
        }

        @Override
        public int hashCode() {
            return Objects.hash(i, j, cost);
        }

        @Override
        public String toString() {
            return "(" + i + " " + j + ")";
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

    public static long gcd(long a, long b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }

    public static <T> void reverse(T[] array) {
        for (int i = 0; i < array.length / 2; i++) {
            T temp = array[i];
            array[i] = array[array.length - i - 1];
            array[array.length - i - 1] = temp;
        }
    }

    public static void reverse(long[] array) {
        for (int i = 0; i < array.length / 2; i++) {
            long temp = array[i];
            array[i] = array[array.length - i - 1];
            array[array.length - i - 1] = temp;
        }
    }

    static void precompFacts() {
        factorials = new long[2_000_001];
        invFactorials = new long[2_000_001];
        factorials[0] = invFactorials[0] = 1;
        for (int i = 1; i < factorials.length; i++)
            factorials[i] = modularMultiplication(factorials[i - 1], i, mod);
        invFactorials[factorials.length - 1] = modularExponentiation(factorials[factorials.length - 1], mod - 2,
                mod);
        for (int i = invFactorials.length - 2; i >= 0; i--)
            invFactorials[i] = modularMultiplication(invFactorials[i + 1], i + 1, mod);
    }

    static public int modularAddition(int a, int b, int mod) {
        return (a % mod + b % mod) % mod;
    }

    static public long modularAddition(long a, long b, long mod) {
        return (a % mod + b % mod) % mod;
    }

    static public int modularMultiplication(int a, int b, int mod) {
        return ((a % mod) * (b % mod)) % mod;
    }

    static public long modularMultiplication(long a, long b, long mod) {
        return ((a % mod) * (b % mod)) % mod;
    }

    static public int modularSubtraction(int a, int b, int mod) {
        return (a % mod - b % mod + mod) % mod;
    }

    static public long modularSubtraction(long a, long b, long mod) {
        return (a % mod - b % mod + mod) % mod;
    }

    static long modularDivision(long a, long b, long mod) {
        return modularMultiplication(a, modInverse(b, mod), mod);
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

    static long ncr(long n, long r) {
        return (((factorials[(int) n] * invFactorials[(int) r]) % mod) * invFactorials[(int) (n - r)]) % mod;
    }

    public static int modularExponentiation(int x, int n, int mod) {
        if (n == 0)
            return 1 % mod;
        else if (n % 2 == 0)
            return modularExponentiation(modularMultiplication(x, x, mod), n / 2, mod);
        else
            return modularMultiplication(x,
                    modularExponentiation(modularMultiplication(x, x, mod), (n - 1) / 2, mod),
                    mod);
    }

    public static long modularExponentiation(long x, long n, long mod) {
        long result = 1;
        while (n > 0) {
            if (n % 2 == 1)
                result = modularMultiplication(result, x, mod);
            x = modularMultiplication(x, x, mod);
            n /= 2;
        }
        return result;
    }

    static class InputReader {
        private InputStream stream;
        private byte[] buffer = new byte[1024];
        private int currentCharacter;
        private int numberOfCharacters;
        private SpaceCharFilter filter;

        public InputReader(InputStream stream) {
            this.stream = stream;
        }

        public int read() {
            if (numberOfCharacters == -1) {
                throw new InputMismatchException();
            }
            if (currentCharacter >= numberOfCharacters) {
                currentCharacter = 0;
                try {
                    numberOfCharacters = stream.read(buffer);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (numberOfCharacters <= 0) {
                    return -1;
                }
            }
            return buffer[currentCharacter++];
        }

        public int peek() {
            if (numberOfCharacters == -1) {
                return -1;
            }
            if (currentCharacter >= numberOfCharacters) {
                currentCharacter = 0;
                try {
                    numberOfCharacters = stream.read(buffer);
                } catch (IOException e) {
                    return -1;
                }
                if (numberOfCharacters <= 0) {
                    return -1;
                }
            }
            return buffer[currentCharacter];
        }

        public int nextInt() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            int sum = 0;
            do {
                if (c < '0' || c > '9') {
                    throw new InputMismatchException();
                }
                sum *= 10;
                sum += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return sum * sgn;
        }

        public long nextLong() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            long sum = 0;
            do {
                if (c < '0' || c > '9') {
                    throw new InputMismatchException();
                }
                sum *= 10;
                sum += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return sum * sgn;
        }

        public String next() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            StringBuilder sum = new StringBuilder();
            do {
                if (Character.isValidCodePoint(c)) {
                    sum.appendCodePoint(c);
                }
                c = read();
            } while (!isSpaceChar(c));
            return sum.toString();
        }

        public boolean isSpaceChar(int c) {
            if (filter != null) {
                return filter.isSpaceChar(c);
            }
            return isWhitespace(c);
        }

        public static boolean isWhitespace(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        private String readLine0() {
            StringBuilder buf = new StringBuilder();
            int c = read();
            while (c != '\n' && c != -1) {
                if (c != '\r') {
                    buf.appendCodePoint(c);
                }
                c = read();
            }
            return buf.toString();
        }

        public String readLine() {
            String s = readLine0();
            while (s.trim().length() == 0) {
                s = readLine0();
            }
            return s;
        }

        public String readLine(boolean ignoreEmptyLines) {
            if (ignoreEmptyLines) {
                return readLine();
            } else {
                return readLine0();
            }
        }

        public String nextLine() {
            return readLine();
        }

        public BigInteger readBigInteger() {
            try {
                return new BigInteger(nextLine());
            } catch (NumberFormatException e) {
                throw new InputMismatchException();
            }
        }

        public char nextCharacter() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            return (char) c;
        }

        public double nextDouble() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            double sum = 0;
            while (!isSpaceChar(c) && c != '.') {
                if (c == 'e' || c == 'E') {
                    return sum * Math.pow(10, nextInt());
                }
                if (c < '0' || c > '9') {
                    throw new InputMismatchException();
                }
                sum *= 10;
                sum += c - '0';
                c = read();
            }
            if (c == '.') {
                c = read();
                double m = 1;
                while (!isSpaceChar(c)) {
                    if (c == 'e' || c == 'E') {
                        return sum * Math.pow(10, nextInt());
                    }
                    if (c < '0' || c > '9') {
                        throw new InputMismatchException();
                    }
                    m /= 10;
                    sum += (c - '0') * m;
                    c = read();
                }
            }
            return sum * sgn;
        }

        public boolean isExhausted() {
            int value;
            while (isSpaceChar(value = peek()) && value != -1) {
                read();
            }
            return value == -1;
        }

        public SpaceCharFilter getFilter() {
            return filter;
        }

        public void setFilter(SpaceCharFilter filter) {
            this.filter = filter;
        }

        public interface SpaceCharFilter {
            public boolean isSpaceChar(int ch);
        }

        public int[] nextIntArray(int n) {
            int[] array = new int[n];
            for (int i = 0; i < n; ++i)
                array[i] = nextInt();
            return array;
        }

        public long[] nextLongArray(int n) {
            long[] array = new long[n];
            for (int i = 0; i < n; ++i)
                array[i] = nextLong();
            return array;
        }
    }

    static class OutputWriter {
        private final PrintWriter writer;

        public OutputWriter(OutputStream outputStream) {
            writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));
        }

        public OutputWriter(Writer writer) {
            this.writer = new PrintWriter(writer);
        }

        public void print(Object... objects) {
            for (int i = 0; i < objects.length; i++) {
                if (i != 0) {
                    writer.print(' ');
                }
                writer.print(objects[i]);
            }
        }

        public void println(Object... objects) {
            print(objects);
            writer.println();
        }

        public void println() {
            writer.println();
        }

        public void print(int[] array) {
            for (int i = 0; i < array.length; i++) {
                if (i != 0) {
                    writer.print(' ');
                }
                writer.print(array[i]);
            }
        }

        public void println(int[] array) {
            print(array);
            writer.println();
        }

        public void print(long[] array) {
            for (int i = 0; i < array.length; i++) {
                if (i != 0) {
                    writer.print(' ');
                }
                writer.print(array[i]);
            }
        }

        public void println(long[] array) {
            print(array);
            writer.println();
        }

        public <T> void print(List<T> array) {
            for (int i = 0; i < array.size(); i++) {
                if (i != 0) {
                    writer.print(' ');
                }
                writer.print(array.get(i));
            }
        }

        public <T> void println(List<T> array) {
            print(array);
            writer.println();
        }

        public void close() {
            writer.close();
        }

        public void flush() {
            writer.flush();
        }

    }

}