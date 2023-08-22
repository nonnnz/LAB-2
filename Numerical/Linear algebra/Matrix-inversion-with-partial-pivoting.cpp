#include <bits/stdc++.h>

using namespace std;

void pivot(double a[3][6], int n, int k) {
    int p = k;
    double big = abs(a[k][k]);
    
    for (int ii = k + 1; ii < n; ii++) {
        double dummy = abs(a[ii][k]);
        if (dummy > big) {
            big = dummy;
            p = ii;
        }
    }
    
    if (p != k) {
        for (int jj = k; jj < 2 * n; jj++) {
            double dummy = a[p][jj];
            a[p][jj] = a[k][jj];
            a[k][jj] = dummy;
        }
    }
}

void gaussianJordan(double a[3][6], int n) {
    for (int k = 0; k < n; k++) {
        pivot(a, n, k);
        
        double pivotValue = a[k][k];
        for (int j = k; j < 2 * n; j++) {
            a[k][j] /= pivotValue;
        }
        
        for (int i = 0; i < n; i++) {
            if (i != k) {
                double factor = a[i][k];
                for (int j = k; j < 2 * n; j++) {
                    a[i][j] -= factor * a[k][j];
                }
            }
        }
    }
    
    for (int i = 0; i < n; i++) {
        for (int j = n; j < 2 * n; j++) {
            cout << a[i][j] << " ";
        }
        cout << endl;
    }
}

int main() {
    int n = 3;
    double a[3][6] = {
        {-2, 3, 1, 1, 0, 0},
        {3, 4, -5, 0, 1, 0},
        {1, -2, 1, 0, 0, 1}
    };

    gaussianJordan(a, n);

    return 0;
}
