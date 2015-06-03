/**
 * The NQueens class uses the backtracking algorithm to find a solution to
 * the N Queens problem, whether or not a certain number, n, queens 
 * can be placed on an nxn grid so they would not be able to attack
 * each other in one move.
 * 
 * @author Lauren Ryan
 *
 */

public class NQueens {
	private int[] queens;
	private GUI gui;
	
	/**
	 * Entry point for NQueens 
	 * @param args
	 */
	public static void main(String[] args){
		NQueens queens = new NQueens();
	}
	
	/**
	 * Constructor, creates GUI and passes itself as a handle
	 */
	public NQueens(){
		gui = new GUI(this);
	}

	/**
	 * Creates the game 
	 * 
	 * @param n
	 */
	public void create(int n) {
		queens = new int[n];
		placeQueens(n);
	}
/**
 * Checks for valid positions of the queen
 * @param k
 * @return false if the queen is occupying a space which is already filled or
 * 				is in line with another queen
 * @return true if the queen is occupying a valid position
 */
	public boolean validPosition(int k) {
		for (int i = 0; i < k; i++) {
			if ((queens[i] == queens[k])
					|| (Math.abs(queens[i] - queens[k]) == Math.abs(i - k))) {
				return false;
			}
		}
		return true;

	}
	
/**
 * Appropriately positions the queens or tells you that no solution is possible
 * @param N
 */
	public void placeQueens(int N) {
		queens[0] = 0;
		int k = 0;

		while (k < N) {
			while (!((k < N) & (validPosition(k)))) {
				queens[k] = queens[k] + 1;
			}
			if ((k == N - 1) && (queens[k] < N)) {
				for (int i = 0; i < N; i++) {
					gui.println("" + queens[i]);
				}
				return;
			} else if ((k < N - 1) && (queens[k] < N)) {
				k = k + 1;
				queens[k] = 0;
			} else {
				k = k - 1;
				if (k < 0) {
					System.out.println("No Possible Solution");
				} else {
					queens[k] = queens[k] + 1;
				}
			}
		}
	}
}