import java.io.*;
import java.util.*;

public class genomics {
	public static void main(String[] args) throws IOException {
		Kattio io = new Kattio("cownomics");
		// read in spotted/clear array
        //iterate for each m
        // for each m see if all of the spotted differ from each plain
        // if there is no difference, we add +1
        int num = io.nextInt();
        int pos = io.nextInt();
        int count = 0;
        char[][] spotted = new char[num][];
        char[][] plain = new char[num][];

        // read in input
        for (int i = 0; i < num; i++) {
            spotted[i] = io.next().toCharArray();
        }
        for (int i = 0; i < num; i++) {
            plain[i] = io.next().toCharArray();
        }

        for (int i =0; i<pos; i++) { // for each pos
            boolean possible = true;
            for (int j = 0; j < num; j++) { // go thru each plain/spotted
                for (int k = 0; k < num; k ++) {
                    if (spotted[j][i] == plain[k][i]) {
                        possible = false; // if any 2 are the same this is not a possible place
                    }
                }
            }
            if (possible) { // if it holds then increment count
                count++;
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
