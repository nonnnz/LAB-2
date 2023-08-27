#include <bits/stdc++.h>

using namespace std;

void show(double a[3][3], double b[3]) {
    int n = 3;
    for (int r = 0; r < n; r++) {
        for (int c = 0; c < n; c++) {
            cout << a[r][c] << "\t";
        }
        cout << "| " << b[r] << endl;
    }
}

void gaussianElimination(double a[3][3], double b[3]) {
    int n = 3;

    cout << "Initial Matrix:" << endl;
    show(a,b);

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
            show(a,b);

        }
        cout << endl;
    }
    cout<<"BACK"<<endl;
    // back eli
    for (int k = n - 1 ; k >= 0; k--) {
        for (int i = k - 1; i >= 0; i--){
            double factor = a[i][k] / a[k][k];
            // cout<<a[i][k];
            cout << "Row " << i + 1 << " -= Row " << k + 1 << " * " << factor << endl;
            for (int j = k; j < n; j++) {
                a[i][j] = a[i][j] - factor * a[k][j];
                a[i][j] = abs(a[i][j]) < 1e-6 ? 0 : a[i][j]; // define zero
            }
            b[i] = b[i] - factor * b[k];

            cout << "Updated Matrix:" << endl;
            show(a,b);
        }
        cout << endl;
    }

    // normalize to 1
    for (int i = 0; i < n; i++) {
        double pivot = a[i][i];
        a[i][i] /= pivot;
        b[i] /= pivot;

        cout << "Updated Matrix:" << endl;
        show(a,b);
        cout << endl;
    }

    // Print the solution
    cout << "Solution: " << endl;
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
    
    // cout<<fixed<<setprecision(2);

    double b[3] = {9, 0, -4};

    gaussianElimination(a, b);

    return 0;
}