#include <bits/stdc++.h>

using namespace std;

void gaussJordan(double a[3][3], double b[3]) {
    int n = 3;

    for (int i = 0; i < n; i++) {
        double pivot = a[i][i];
        for (int j = i; j < n; j++) {
            a[i][j] /= pivot;
        }
        b[i] /= pivot;
        cout<<"normalize r"<<i+1<<"/"<<pivot<<endl;
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                cout << a[r][c] << "\t";
            }
            cout<<"| "<<b[r]<<endl;
        }
        cout<<endl;

        // eliminate
        for (int j = 0; j < n; j++) {
            if (j != i) {
                double factor = a[j][i];
                for (int k = i; k < n; k++) {
                    a[j][k] -= factor * a[i][k];
                }
                b[j] -= factor * b[i];
            }
        }
        cout<<"reduction x"<<i+1<<endl;
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                cout << a[r][c] << "\t";
            }
            cout<<"| "<<b[r]<<endl;
        }
        cout<<endl;
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

    gaussJordan(a, b);

    return 0;
}