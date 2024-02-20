#include <bits/stdc++.h>

using namespace std;

void backtrack(int n, int k, int index, int count, int ans[]) {
    if (index == n) {
        if (count == k) {
            for (int i = 0; i < n; i++) {
                cout << ans[i];
            }
            cout << endl;
        }
        // for (int i = 0; i < n; i++) {
        //         cout << ans[i];
        //     }
        // cout << endl;
        return;
    }

    if (count > k) {
        return;
    }

    ans[index] = 0;
    backtrack(n, k, index + 1, count + 1, ans);

    ans[index] = 1;
    backtrack(n, k, index + 1, count, ans);
}

int main() {
    int n, k;
    cin >> n >> k;

    int ans[n];
    backtrack(n, k, 0, 0, ans);

    return 0;
}
