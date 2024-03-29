#include <bits/stdc++.h>

using namespace std;

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
    vector<int> coins = {1, 3, 4, 5};
    int target = 7;

    cout << "Minimum number of coins required: " << minCoins(coins, target) << endl;

    return 0;
}