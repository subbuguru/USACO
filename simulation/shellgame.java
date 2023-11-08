package simulation;
import java.io.*;
import java.util.*;

//tips: make a boolean array, swap between based on ur swap 2d array
// use guess of same index to check and see if we should add a point

public class Main {
	public static void main(String[] args) {
		Kattio io = new Kattio();
		
        int g = io.nextInt();

        int[][] swaps = new int[g][2];
        int[] guesses = new int[g];
        int maxpoints = 0;

        for (int i = 0; i < g; i++) {
            swaps[i][0] = io.nextInt();
            swaps[i][1] = io.nextInt();
            guesses[i] = io.nextInt();
        }

        for (int i = 1; i <= 3; i++) {
            
			boolean[] shells = new boolean[4];
			shells[i] = true;
			int points = 0;

            for (int j = 0; j < g; j++) {
				boolean temp = shells[swaps[j][0]];
				shells[swaps[j][0]] = shells[swaps[j][1]];
				shells[swaps[j][1]] = temp;

				if (shells[guesses[j]]) {
					points ++;
				}
            }
			maxpoints = Math.max(points, maxpoints);
        }

		io.println(maxpoints);
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