import java.io.*;
import java.util.*;

public class lifeguards {
	public static void main(String[] args) throws IOException {
		Kattio io = new Kattio("lifeguards");

        int n = io.nextInt();
        int[][] guards = new int[n][2];
        int maxtime = 0;

        for ( int i = 0; i < n; i++) {
            guards[i][0] = io.nextInt();
            guards[i][1] = io.nextInt();
        }

        for ( int i = 0; i < n; i++) { // the illegal number
            int[] time = new int[1001]; //time array for thisset
			int timevalue = 0;
            for (int j = 0; j <n; j++) { // go through all to add tiem
                if (j != i) { // don t add if illegal num
					for (int k = guards[j][0]; k < guards[j][1]; k++) {
						time[k] = 1; // set to 1 if it is a time (if it repeat it will just set 1 again)
					}
                }
            }
			for (int t : time) {
				timevalue += t;
			}
			maxtime = Math.max(maxtime, timevalue);

        }
		io.println(maxtime);
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
