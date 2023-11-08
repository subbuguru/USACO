package simulation;
import java.io.*;
import java.util.*;


    

public class Main {
	public static void main(String[] args) {
		Kattio io = new Kattio();
		
        int n = io.nextInt();
        Sensor[] sensors = new Sensor[n];


        for (int i = 0; i < n; i++) {
            String type = io.next();
            int min = io.nextInt();
            int max = io.nextInt();
            sensors[i] = new Sensor(type, min, max);
        }
		// first find first none segment
		
		 // find init range
		 int[] range = {-99999999, 9999999};

		 //init range 
		 for (int i = n-1; i >= 0; i--) {
			Sensor sensor = sensors[i];
			if (sensor.type.equals("on")) {
				range[0] -= sensor.max;
				range[1] -= sensor.min;
				range[0] = Math.max(0, range[0]);
				
			} else if (sensor.type.equals("off")) {
				range[0] += sensor.min;
				range[1] += sensor.max;
			} else if (sensor.type.equals("none")) {
				range[0] = Math.max(sensor.min, range[0]);
				range[1] = Math.min(sensor.max, range[1]);
			}
		 }
		 io.println(range[0] + " " + range[1]);

		 range[0] = -9999999;
		 range[1] = 9999999;

		 //fina lrange

		 for (int i = 0; i < n; i++) {
			Sensor sensor = sensors[i];
			if (sensor.type.equals("on")) {
				range[0] += sensor.min;
				range[1] += sensor.max;
			} else if (sensor.type.equals("off")) {
				range[0] -= sensor.max;
				range[1] -= sensor.min;
				range[0] = Math.max(0, range[0]);
			} else if (sensor.type.equals("none")) {
				range[0] = Math.max(sensor.min, range[0]);
				
				range[1] = Math.min(sensor.max, range[1]);

			}
		 }
		 io.println(range[0] + " " + range[1]);
		 
		 io.println();


        
		io.close();
	}

    
    // public class sensor with a string parameter called type, int min, int max
static class Sensor {

    public String type;
    public int min;
    public int max;

    public Sensor(String type, int min, int max) {
        this.type = type;
        this.min = min;
        this.max = max;
    }
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