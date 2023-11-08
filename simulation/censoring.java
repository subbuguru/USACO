package simulation;
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) {
		Kattio io = new Kattio();
		
        String s = io.next();
		String t = io.next();

		StringBuilder build = new StringBuilder();

		for (int i = 0; i < s.length(); i++) {
			build.append(s.substring(i, i+1));
			if (build.length() >= t.length() && 
			build.substring(build.length()-t.length()).contentEquals(t)) {
				build.delete(build.length()-t.length(), build.length());
			}

		}
		

       io.println(build.toString());

		io.println();
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
