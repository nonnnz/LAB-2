#include <bits/stdc++.h>

using namespace std;

int main() {
    int n;
    cin >> n;
    int a[n];
    int x;
    cin >> x;
    for (int i = 0; i < n; i++) {
        cin >> a[i];
    }

    int min_i = 9999;
    int s_j, s_i;
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            if(a[i] > a[j] || i == j) {
                continue;
            }

            if (a[i] + a[j] == x) {
                if(a[i] < min_i) {
                    min_i = a[i];
                    s_i = i;
                    s_j = j;
                }
            }
        }            
    }

    if(s_i == 0 && s_j == 0) 
        cout << "-1" << endl;
    else
        cout << s_i << " " << s_j << endl;
}