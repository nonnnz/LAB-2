#include <bits/stdc++.h>

using namespace std;

void gaussJordan(double a[3][6], double b[3]) {
    int n = 3;

    for (int i = 0; i < n; i++) {
        double pivot = a[i][i];
        for (int j = i; j < n * 2; j++) {
            a[i][j] /= pivot;
        }

        cout<<"normalize r"<<i+1<<"/"<<pivot<<endl;
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n * 2; c++) {
                cout << a[r][c] << "\t";
            }
            cout<<endl;
        }
        cout<<endl;

        // eliminate
        for (int j = 0; j < n; j++) {
            if (j != i) {
                double factor = a[j][i];
                for (int k = i; k < n * 2; k++) {
                    a[j][k] -= factor * a[i][k];
                }
            }
        }
        cout<<"reduction x"<<i+1<<endl;
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n * 2; c++) {
                cout << a[r][c] << "\t";
            }
            cout<<endl;
        }
        cout<<endl;
    }

    // a^-1
    double inv[3][3];
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            inv[i][j] = a[i][j + n];
        }
    }

    // a^1 * b
    double x[3] = {0};
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            x[i] += inv[i][j] * b[j];
        }
    }

    for (int i = 0; i < n; i++) {
        cout << "x" << i + 1 << " = " << x[i] << endl;
    }
}

int main() {
    double a[3][6] = {
        {-2, 3, 1, 1, 0, 0},
        {3, 4, -5, 0, 1, 0},
        {1, -2, 1, 0, 0, 1}
    };

    double b[3] = {9, 0, -4};

    gaussJordan(a, b);

    return 0;
}
