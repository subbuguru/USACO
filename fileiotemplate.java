import java.io.*;
import java.util.*;

public class fileiotemplate {
	public static void main(String[] args) throws IOException {
		Kattio io = new Kattio("problemname");
		int a = io.nextInt();
		int b = io.nextInt();
		int c = io.nextInt();
		io.print("The sum of these three numbers is ");
		io.println(a + b + c);
		/*
		 * Make sure to include the line below, as it
		 * flushes and closes the output stream.
		 */
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