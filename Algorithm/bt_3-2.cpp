#include <bits/stdc++.h>

using namespace std;

int V[] = {12, 5, 4, 2};
int W[] = {8, 7, 4, 2};
int max_v = -1;
int ans[4];
int K = 18;

void print_sol(int x[], int n) {
    int w_temp = 0, v_temp = 0;
    for(int i = 0; i < n; i++) {
        if(x[i] == 1) {
            w_temp += W[i];
            v_temp += V[i];
        }
    }

    if(w_temp <= K && v_temp > max_v) {
        max_v = v_temp;
        for(int j = 0; j < n; j++) {
            ans[j] = x[j];
        }
    }
}

void Subset1(int x[], int l, int r) {
    if(l == r) {
        print_sol(x, r);
    } else {
        x[l+1] = 1;
        Subset1(x, l+1, r);
        x[l+1] = 0;
        Subset1(x, l+1, r);
    }
}

int main() {
    Subset1(ans, 0, 3); // pass 3 instead of 4

    cout << "Selected items in the knapsack: ";
    for(int i = 0; i < 4; i++) {
        ans[i];
    }

    cout << "\nTotal value in the knapsack: " << max_v << endl;

    return 0;
}