import java.io.*;
import java.util.*;

public class promotion {
	public static void main(String[] args) throws IOException {
		Kattio io = new Kattio("promote");
		int[] before = new int[4];
        int[] after = new int[4];

        for (int i = 0; i < 4; i++) {
            before[i] = io.nextInt();
            after[i] = io.nextInt();
        }

        int platpromotions = after[3] - before[3];

        int goldtemp = before[2] - platpromotions;
        int goldpromotions = after[2] - goldtemp;

        int silvertemp = before[1] - goldpromotions;
        int silverpromotions = after[1] - silvertemp;

        io.println(silverpromotions);
        io.println(goldpromotions);
        io.println(platpromotions);

		io.close();
	}

	//BeginCodeSnip{Kattio}
	static class Kattio extends PrintWriter {
		private BufferedReader r;
		private StringTokenizer st;
		// standard input
		public Kattio() { this(System.in, System.out); }
		public Kattio(InputStream i, OutputStream o) {
			super(o);
			r = new BufferedReader(new InputStreamReader(i));
		}
		// USACO-style file input
		public Kattio(String problemName) throws IOException {
			super(problemName + ".out");
			r = new BufferedReader(new FileReader(problemName + ".in"));
		}
		// returns null if no more input
		public String next() {
			try {
				while (st == null || !st.hasMoreTokens())
					st = new StringTokenizer(r.readLine());
				return st.nextToken();
			} catch (Exception e) { }
			return null;
		}
		public int nextInt() { return Integer.parseInt(next()); }
		public double nextDouble() { return Double.parseDouble(next()); }
		public long nextLong() { return Long.parseLong(next()); }
	}
	//EndCodeSnip
}