#include <bits/stdc++.h>

using namespace std;

void pivot(double a[3][3], double b[3], double s[3], int n, int k) {
    int p = k;
    double big = abs(a[k][k] / s[k]);
    
    for (int ii = k + 1; ii < n; ii++) {
        double dummy = abs(a[ii][k] / s[ii]);
        if (dummy > big) {
            big = dummy;
            p = ii;
        }
    }
    
    if (p != k) {
        for (int jj = k; jj < n; jj++) {
            double dummy = a[p][jj];
            a[p][jj] = a[k][jj];
            a[k][jj] = dummy;
        }
        
        double dummy = b[p];
        b[p] = b[k];
        b[k] = dummy;
        
        dummy = s[p];
        s[p] = s[k];
        s[k] = dummy;
    }
}

void gaussianJordan(double a[3][3], double b[3]) {
    int n = 3;
    double s[n];
    
    for (int i = 0; i < n; i++) {
        s[i] = 0.0;
        for (int j = 0; j < n; j++) {
            s[i] = max(s[i], abs(a[i][j]));
        }
    }
    
    for (int k = 0; k < n; k++) {
        pivot(a, b, s, n, k);
        
        double pivotValue = a[k][k];
        for (int j = k; j < n; j++) {
            a[k][j] /= pivotValue;
        }
        b[k] /= pivotValue;
        
        for (int i = 0; i < n; i++) {
            if (i != k) {
                double factor = a[i][k];
                for (int j = k; j < n; j++) {
                    a[i][j] -= factor * a[k][j];
                }
                b[i] -= factor * b[k];
            }
        }
    }
    
    for (int i = 0; i < n; i++) {
        cout << "x" << i + 1 << " = " << b[i] << endl;
    }
}

int main() {
    double a[3][3] = {
        {-2, 3, 1},
        {3, 4, -5},
        {1, -2, 1}
    };

    double b[3] = {9, 0, -4};

    gaussianJordan(a, b);

    return 0;
}
