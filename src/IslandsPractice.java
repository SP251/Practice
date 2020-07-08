
public class IslandsPractice {
	static int m = 5;
	static int n = 5;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int mat[][] = { { 1, 1, 0, 0, 0 }, { 0, 1, 0, 0, 1 }, { 1, 0, 0, 1, 1 }, { 0, 0, 0, 0, 0 }, { 1, 0, 1, 0, 1 } };
		System.out.println(countOfIslands(mat, m, n));

	}

	static int countOfIslands(int mat[][], int m, int n) {
		boolean visited[][] = new boolean[m][n];
		int count = 0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (mat[i][j] == 1 && !visited[i][j]) {
					DFS(mat, i, j, visited);
					++count;
				}
			}
		}
		return count;
	}

	static void DFS(int mat[][], int i, int j, boolean[][] visited) {
		int rowNbr[] = { -1, -1, -1, 0, 0, 1, 1, 1 };
		int colNbr[] = { -1, 0, 1, -1, 1, -1, 0, 1 };

		visited[i][j] = true;

		for (int k = 0; k < 8; k++) {
			if (isSafe(mat, i + rowNbr[k], j + colNbr[k], visited)) {
				DFS(mat, i + rowNbr[k], j + colNbr[k], visited);
			}
		}
	}

	static boolean isSafe(int mat[][], int i, int j, boolean[][] visited) {
		return ((i >= 0) && (i < m) && (j >= 0) && (j < n) && (mat[i][j] == 1 && !visited[i][j]));
	}
}
