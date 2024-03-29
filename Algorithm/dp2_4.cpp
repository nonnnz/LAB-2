#include <bits/stdc++.h>

using namespace std;

void printTable(vector<vector<int>>& dp, int target) {
    cout << "Dynamic Programming Table:\n";
    cout << "Amount | 0 | 1 | 2 | 3 | 4\n";
    cout << "-----------------------------\n";
    for (int i = 0; i <= 4; ++i) {
        cout << "  " << i << "   | ";
        for (int j = 0; j <= 4; ++j) {
            if (dp[i][j] == INT_MAX) {
                cout << "INF ";
            } else {
                cout << dp[i][j] << "  ";
            }
        }
        cout << endl;
    }
}

int minCoins2D(vector<int>& coins, int target) {
    int n = coins.size();
    vector<vector<int>> dp(target + 1, vector<int>(target + 1, INT_MAX));
    dp[0][0] = 0;

    for (int i = 1; i <= target; ++i) {
        for (int j = 0; j < n; ++j) {
            if (coins[j] <= i && dp[i - coins[j]][0] != INT_MAX) {
                dp[i][0] = min(dp[i][0], 1 + dp[i - coins[j]][0]);
            }
        }
    }

    printTable(dp, target);

    return dp[target][0];
}

int minCoins(vector<int>& coins, int target) {
    int n = coins.size();
    vector<int> dp(target + 1, INT_MAX); 

    dp[0] = 0; // Base case

    for (int i = 1; i <= target; ++i) {
        for (int j = 0; j < n; ++j) {
            if (coins[j] <= i && dp[i - coins[j]] != INT_MAX) {
                dp[i] = min(dp[i], 1 + dp[i - coins[j]]);
            }
        }
    }

    return dp[target];
}

int main() {
    vector<int> coins = {1, 4, 5, 10};
    int target = 8;

    cout << "Minimum number of coins required: " << minCoins2D(coins, target) << endl;

    return 0;
}