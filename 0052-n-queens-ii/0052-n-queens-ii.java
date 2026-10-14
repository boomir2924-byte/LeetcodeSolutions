class Solution {
    public int totalNQueens(int n) {
        return solve(0, n, new boolean[n],
                     new boolean[2 * n],
                     new boolean[2 * n]);
    }

    private int solve(int row, int n, boolean[] columns,
                      boolean[] diagonals1, boolean[] diagonals2) {

        if (row == n) {
            return 1;
        }

        int count = 0;

        for (int col = 0; col < n; col++) {
            int d1 = row - col + n;
            int d2 = row + col;

            if (columns[col] || diagonals1[d1] || diagonals2[d2]) {
                continue;
            }

            columns[col] = true;
            diagonals1[d1] = true;
            diagonals2[d2] = true;

            count += solve(row + 1, n, columns, diagonals1, diagonals2);

            columns[col] = false;
            diagonals1[d1] = false;
            diagonals2[d2] = false;
        }

        return count;
    }
}