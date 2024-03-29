#include <iostream>

using namespace std;

int dp[10][10]; // table for memorization C(n, k)

int C(int n, int k) {
    // base case
    if (k == 0 || k == n) {
        dp[n][k] = 1;
        return dp[n][k];
    }

    // pick up the result of C(n, k) if it exists
    if (dp[n][k] != 0)
        return dp[n][k];

    // recurrence relation for C(n, k)
    dp[n][k] = C(n - 1, k - 1) + C(n - 1, k);
    return dp[n][k];
}

int main() {
    cout << C(7, 5) << endl;
    return 0;
}
