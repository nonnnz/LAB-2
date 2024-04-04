#include <iostream>
#include <vector>
#include <string>

using namespace std;

class Solution {
public:
    vector<vector<vector<int>>> solveNQueens(int n) {
        vector<vector<vector<int>>> res;
        vector<vector<int>> nQueens(n, vector<int>(n, 0));
        vector<int> flag(5 * n - 2, 1);
        solveNQueens(res, nQueens, flag, 0, n);
        return res;
    }
private:
    void solveNQueens(vector<vector<vector<int>>> &res, vector<vector<int>> &nQueens, vector<int> &flag, int row, int &n) {
        if (row == n) {
            res.push_back(nQueens);
            return;
        }
        for (int col = 0; col != n; ++col)
            if (flag[col] && flag[n + row + col] && flag[4 * n - 2 + col - row]) {
                flag[col] = flag[n + row + col] = flag[4 * n - 2 + col - row] = 0;
                nQueens[row][col] = 1; // Marking the position with a queen (1 represents queen)
                solveNQueens(res, nQueens, flag, row + 1, n);
                nQueens[row][col] = 0; // Clearing the position after backtracking
                flag[col] = flag[n + row + col] = flag[4 * n - 2 + col - row] = 1;
            }
    }
};

int main() {
    int n;
    cin >> n;

    Solution solver;
    vector<vector<vector<int>>> solutions = solver.solveNQueens(n);

    // Outputting the solutions
    for (const auto &solution : solutions) {
        for (const auto &row : solution) {
            int count = 0;
            for (int col : row) 
            {
                if (col == 1)
                    cout << count << " ";
                else
                    count++;
            }
        }
        cout << endl;
    }

    return 0;
}
