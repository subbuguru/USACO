import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class cowgymnastics {
	public static void main(String[] args) throws IOException {
		Kattio io = new Kattio("gymnastics");
        int k = io.nextInt();
        int n = io.nextInt();
        int[][] sessions = new int[k][n];
		int count = 0;
		int[][] pairs = new int[n][n];

		for (int i = 0; i <k; i++) {
			for (int j = 0; j < n; j++) {
				sessions[i][j] = io.nextInt();
			}
		}

		// go through each pair in 1,4
		// see if, in each session, one pair is always better than other
		//if so, increment 1

		for (int i = 1; i < n; i++) {
			for (int j = i + 1; j <=n; j++) {
				//if one cow is always better than other, increment
				int temp = 0;
				for (int m = 0; m < k; m++) {
					List<Integer> list = Arrays.stream(sessions[m]).boxed().collect(Collectors.toList());
				if (list.indexOf(i) < list.indexOf(j)) {
				    temp++;
				}
				}
				
				if (temp ==0 || temp==k) {
					count++;
				}
				
			}
		}

		

        
		io.println(count);
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