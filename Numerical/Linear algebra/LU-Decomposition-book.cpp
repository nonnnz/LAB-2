#include <iostream>
#include <cmath>

using namespace std;

const int MAX_N = 10; // Maximum matrix size

void Pivot(double a[MAX_N][MAX_N], int o[MAX_N], double s[MAX_N], int n, int k) {
    int p = k;
    double big = abs(a[o[k]][k] / s[o[k]]);
    
    for (int ii = k + 1; ii < n; ++ii) {
        double dummy = abs(a[o[ii]][k] / s[o[ii]]);
        if (dummy > big) {
            big = dummy;
            p = ii;
        }
    }
    
    swap(o[k], o[p]);
}

void Decompose(double a[MAX_N][MAX_N], int n, double tol, int o[MAX_N], double s[MAX_N], int& er) {
    er = 0;
    
    for (int i = 0; i < n; ++i) {
        o[i] = i;
        s[i] = abs(a[i][0]);
        
        for (int j = 1; j < n; ++j) {
            if (abs(a[i][j]) > s[i]) {
                s[i] = abs(a[i][j]);
            }
        }
    }
    
    for (int k = 0; k < n - 1; ++k) {
        Pivot(a, o, s, n, k);
        
        if (abs(a[o[k]][k] / s[o[k]]) < tol) {
            er = -1;
            cout << a[o[k]][k] << " " << k / s[o[k]] << endl;
            return;
        }
        
        for (int i = k + 1; i < n; ++i) {
            double factor = a[o[i]][k] / a[o[k]][k];
            a[o[i]][k] = factor;
            
            for (int j = k + 1; j < n; ++j) {
                a[o[i]][j] -= factor * a[o[k]][j];
            }
        }
    }
    
    if (abs(a[o[n - 1]][n - 1] / s[o[n - 1]]) < tol) {
        er = -1;
        cout << a[o[n - 1]][n - 1] << " " << (n - 1) / s[o[n - 1]] << endl;
    }
}

void Substitute(double a[MAX_N][MAX_N], int o[MAX_N], int n, double b[MAX_N], double x[MAX_N]) {
    for (int i = 1; i < n; ++i) {
        double sum = b[o[i]];
        
        for (int j = 0; j < i; ++j) {
            sum -= a[o[i]][j] * b[o[j]];
        }
        
        b[o[i]] = sum;
    }
    
    x[n - 1] = b[o[n - 1]] / a[o[n - 1]][n - 1];
    
    for (int i = n - 2; i >= 0; --i) {
        double sum = 0;
        
        for (int j = i + 1; j < n; ++j) {
            sum += a[o[i]][j] * x[j];
        }
        
        x[i] = (b[o[i]] - sum) / a[o[i]][i];
        cout<<b[o[i]]<<endl;
    }
}

int main() {
    int n = 3;
    double a[MAX_N][MAX_N] = {
        {-2, 3, 1},
        {3, 4, -5},
        {1, -2, 1}
    };
    double b[MAX_N] = {9, 0, -4};
    double x[MAX_N];
    
    int o[MAX_N];
    double s[MAX_N];
    int er;
    
    Decompose(a, n, 1e-10, o, s, er);
    
    if (er != -1) {
        Substitute(a, o, n, b, x);
        cout << "Solution vector x:" << endl;
        for (int i = 0; i < n; ++i) {
            cout << x[i] << " ";
        }
        cout << endl;
    } else {
        cout << "Decomposition failed." << endl;
    }
    
    return 0;
}
