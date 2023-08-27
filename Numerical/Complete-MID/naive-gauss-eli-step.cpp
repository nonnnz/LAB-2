#include <bits/stdc++.h>

using namespace std;

void gaussianElimination(double a[3][3], double b[3]) {
    int n = 3;

    cout << "Initial Matrix:" << endl;
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            cout << a[i][j] << "\t";
        }
        cout << "| " << b[i] << endl;
    }
    cout << endl;

    // Forward Elimination
    for (int k = 0; k < n - 1; k++) {
        for (int i = k + 1; i < n; i++) {
            double factor = a[i][k] / a[k][k];
            cout << "Row " << i + 1 << " -= Row " << k + 1 << " * " << factor << endl;
            for (int j = k; j < n; j++) {
                a[i][j] = a[i][j] - factor * a[k][j];
            }
            b[i] = b[i] - factor * b[k];

            cout << "Updated Matrix:" << endl;
            for (int r = 0; r < n; r++) {
                for (int c = 0; c < n; c++) {
                    cout << a[r][c] << "\t";
                }
                cout << "| " << b[r] << endl;
            }
        }
        cout << endl;
    }

    // Back Substitution
    double x[n];
    x[n - 1] = b[n - 1] / a[n - 1][n - 1];
    for (int i = n - 2; i >= 0; i--) {
        double sum = b[i];
        for (int j = i + 1; j < n; j++) {
            sum -= a[i][j] * x[j];
        }
        x[i] = sum / a[i][i];
    }

    // Print the solution
    cout << "Solution: " << endl;
    for (int i = 0; i < n; i++) {
        cout << "x" << i + 1 << " = " << x[i] << endl;
    }
}


int main() {
    double a[3][3] = {
        {-2, 3, 1},
        {3, 4, -5},
        {1, -2, 1}
    };

    double b[3] = {9, 0, -4};

    gaussianElimination(a, b);

    return 0;
}