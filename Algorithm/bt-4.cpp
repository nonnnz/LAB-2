#include <bits/stdc++.h>

using namespace std;

void sol(int n, int k, int index, int count, int ans[]) {
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

    ans[index] = 0;
    sol(n, k, index + 1, count + 1, ans);

    ans[index] = 1;
    sol(n, k, index + 1, count, ans);
}

int main() {
    int n, k;
    cin >> n >> k;

    int ans[n];
    sol(n, k, 0, 0, ans);

    return 0;
}
