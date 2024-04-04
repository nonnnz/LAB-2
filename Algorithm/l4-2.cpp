#include <bits/stdc++.h>

using namespace std;

void print_sol(int x[], int n, int k, int arr[]) {
    int sum = 0;
    for (int i = 0; i < n; i++) {
        if (x[i] == 1) {
            sum += arr[i];
        }
    }

    if (sum == k) {
        for (int i = 0; i < n; i++) {
            if (x[i] == 1) {
                cout << arr[i] << " ";
            }
        }
        cout << endl;
    }
}

void Subset1(int x[], int l, int r, int k, int arr[]) {
    if (l == r) {
        print_sol(x, r, k, arr);
    } else {
        x[l] = 1;
        Subset1(x, l + 1, r, k, arr);
        x[l] = 0;
        Subset1(x, l + 1, r, k, arr);
    }
}

int main() {
    int n, k;
    cin >> n >> k;
    int x[n] = {0};
    int arr[n];
    for (int i = 0; i < n; i++) {
        cin >> arr[i];
    }
    Subset1(x, 0, n, k, arr);
}