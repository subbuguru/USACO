import java.io.*;
import java.util.*;

public class tictactoe {
	public static void main(String[] args) throws IOException {
		Kattio io = new Kattio("tttt");
		
        

        char[][] board = new char[3][3]; // read input from board
        for (int i = 0; i < 3; i ++) {
            String string = io.next();
            for (int j = 0; j < 3; j ++) {
                board[i][j] = string.charAt(j);
            }
        }

        
        Set<Character> individualVictories = new HashSet<>();
        Set<String> teamVictories = new HashSet<>();

        // Checking rows and columns
        for (int i = 0; i < 3; i++) {
            checkVictory(board[i][0], board[i][1], board[i][2], individualVictories, teamVictories);
            checkVictory(board[0][i], board[1][i], board[2][i], individualVictories, teamVictories);
        }

        // Checking diagonals
        checkVictory(board[0][0], board[1][1], board[2][2], individualVictories, teamVictories);
        checkVictory(board[0][2], board[1][1], board[2][0], individualVictories, teamVictories);

        io.println(individualVictories.size());
        io.println(teamVictories.size());

		io.close();
	}

    private static void checkVictory(char c1, char c2, char c3, Set<Character> individualVictories, Set<String> teamVictories) {
        Set<Character> chars = new HashSet<>();
        chars.add(c1);
        chars.add(c2);
        chars.add(c3);

        if (chars.size() == 1) {
            individualVictories.addAll(chars);
        } else if (chars.size() == 2) {
            StringBuilder sb = new StringBuilder();
            for (char c : chars) {
                sb.append(c);
            }
            teamVictories.add(sb.toString());
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