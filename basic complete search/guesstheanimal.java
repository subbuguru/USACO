import java.io.*;
import java.util.*;

public class guesstheanimal {
	public static void main(String[] args) throws IOException {
		Kattio io = new Kattio("guess");

		int max = 0;
		
		List<Set<String>> animals = new ArrayList<Set<String>>();
		int n = io.nextInt();
		for (int i = 0; i < n; i++) {
			var characteristics = new HashSet<String>();
			var junk = io.next();
			int j = io.nextInt();
			for (int k = 0; k < j; k++) {
				var characteristic = io.next();
				characteristics.add(characteristic);
			}
			animals.add(characteristics);
		}
		int maxShared = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int shared = 0;
                for (String characteristic : animals.get(i)) {
                    if (animals.get(j).contains(characteristic)) {
                        shared++;
                    }
                }
                maxShared = Math.max(maxShared, shared);
            }
        }

        io.println(maxShared + 1); // +1 because Elsie can guess before asking about the last distinguishing characteristic
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