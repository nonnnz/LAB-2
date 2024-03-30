#include <bits/stdc++.h>

using namespace std;

int coin_changingBFS(int W, vector<int>& coins) {
    // BFS, graph search. Keep records of visited nodes
    vector<bool> visited(W + 1, false);
    visited[0] = true;
    
    vector<int> par = {0};  // parents
    vector<int> child;       // children
    int step = 0;
    
    while (!par.empty()) {
        step++;
        for (int p : par) {
            for (int c : coins) {
                int tmp = p + c;
                if (tmp == W) {
                    return step;
                } else if (tmp < W && !visited[tmp]) {
                    visited[tmp] = true;
                    child.push_back(tmp);
                }
            }
        }
        swap(par, child);
        child.clear();
    }
    
    return (W == 0) ? 0 : -1;
}

void coinChangeBacktrack(vector<int>& coins, int amount, int& minCoins, int currentCoins, int start) {
    if (amount == 0) {
        minCoins = min(minCoins, currentCoins); // Update minCoins with the minimum number of coins found
        return;
    }

    for (int i = start; i < coins.size(); ++i) {
        if (amount - coins[i] >= 0 && currentCoins + 1 < minCoins) {
            coinChangeBacktrack(coins, amount - coins[i], minCoins, currentCoins + 1, i); // Explore using the current coin
        }
    }
}

int coinChange(vector<int>& coins, int amount) {
    int minCoins = INT_MAX;
    coinChangeBacktrack(coins, amount, minCoins, 0, 0); // Start backtracking from the first coin
    return (minCoins == INT_MAX) ? -1 : minCoins;
}

int main() {
    // int d[] = {1, 3, 4, 5};
    int d[] = {1, 4, 5, 10};
    vector<int> coins{1, 4, 5, 10};
    int n = sizeof(d) / sizeof(d[0]);
    
    cout<<coin_changingBFS(8, coins);
    // 7 not works for 1, 3, 4, 5
    
    return 0;
}