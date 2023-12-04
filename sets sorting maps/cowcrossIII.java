import java.io.*;
import java.util.*;

public class cowcrossIII {
	public static void main(String[] args) throws IOException {
		Kattio io = new Kattio("cowqueue");
		
        int n = io.nextInt();
        int[][] cows = new int[n][2];

        int starttime = 0;
        int endtime = 0;

        // read input 
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                cows[i][j] = io.nextInt();
            }
        }

        //sort the arrays with custom comparator
        Arrays.sort(cows, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return Integer.compare(a[0], b[0]);
            }
        });

        //iterate through each cow, simulating each
        for (int[] cow : cows) {
            starttime = Math.max(cow[0], endtime); // start time for a cow is the max of its earliest time and current tally
            endtime = starttime + cow[1]; // add the cow's time to current tally
        }

        io.println(endtime);



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
