import java.io.*;
import java.util.*;

public class angrycows {

	final static Set<Integer> exploded = new HashSet<Integer>();
	static List<Integer> bales = new ArrayList<Integer>();
	public static void main(String[] args) throws IOException {

		
		Kattio io = new Kattio("angry");

		int maxsize = 0;

        int z = io.nextInt();
        
		
        for (int i = 0; i < z; i++) {
            bales.add(io.nextInt());
        }

        Collections.sort(bales);
        
		for (int i = 0; i < z; i ++) {
			explode(i, 1);
			maxsize = Math.max(maxsize, explode(i, 1)  + explode(i, -1) + 1);
			exploded.clear();

		}

		
		io.close();

		
	}

	//method to explode a bale
	public static int explode (int start, int direction) {
		
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