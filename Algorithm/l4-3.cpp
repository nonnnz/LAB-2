#include <bits/stdc++.h>

using namespace std;

void n_queens(int n, int k, vector<int>& x) {
    if(k == n) {
        int flag = 0;

        for(int j = 1; j < k; j++) {
            for(int p = 0; p < j; p++) {
                if(abs(p - j) == abs(x[p] - x[j]) || (x[j] == x[p]))
                    flag = 1;
            }
        }

        if(flag == 0) {
            for(int i = 0; i < k; i++)
                cout << x[i] << " ";
            cout << endl;
        }
    } else {
        for(int row = 0; row < n; row++) {
            x[k] = row;
            n_queens(n, k + 1, x); // place next queen
        }
    }
}

int main() {
    int n;
    cin >> n;
    
    vector<int> x(n);
    
    if(n > 3) n_queens(n, 0, x);
    else cout << "-1" << endl;
    
    return 0;
}