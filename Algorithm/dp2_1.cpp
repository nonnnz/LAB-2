#include <bits/stdc++.h>

using namespace std;

void knapsackBU(int wt[], int val[], int n, int w) {
    int dp[n+1][w+1];

    for(int i=0; i<=n; i++) {
        for(int j=0; j<=w; j++) {
            if(i == 0 || j == 0) {
                dp[i][j] = 0;
            } else if(wt[i-1] <= j) {
                dp[i][j] = max(val[i-1] + dp[i-1][j-wt[i-1]], dp[i-1][j]);
            } else {
                dp[i][j] = dp[i-1][j];
            }
        }
    }

    cout << dp[n][w] << endl;
}

int knapsackTD(int wt[], int val[], int n, int w, vector<vector<int>>& memo) {
    // base case
    if (n == 0 || w == 0) {
        return 0;
    }

    // if already calculated
    if (memo[n][w] != -1) {
        return memo[n][w];
    }

    // if weight > capacity
    if (wt[n - 1] > w) {
        return memo[n][w] = knapsackTD(wt, val, n - 1, w, memo);
    }

    return memo[n][w] = max(val[n - 1] + knapsackTD(wt, val, n - 1, w - wt[n - 1], memo),knapsackTD(wt, val, n - 1, w, memo));
}

int main() {
    int n = 4;
    int w = 10;
    int wt[] = {5, 4, 6, 3};
    int val[] = {10, 40, 30, 50};
    // knapsackBU(wt, val, n, w);
    vector<vector<int>> memo(n + 1, vector<int>(w + 1, -1));
    cout << knapsackTD(wt, val, n, w, memo);

    return 0;
}