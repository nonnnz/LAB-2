#include <bits/stdc++.h>

using namespace std;

void show(double a[3][3]) {
    int n = 3;
    for (int r = 0; r < n; r++) {
        for (int c = 0; c < n; c++) {
            cout << a[r][c] << "\t";
        }
        cout<<endl;
    }
    cout<<endl;
}

void gaussJordan(double a[3][3], double b[3], double id[3][3]) {
    int n = 3;

    // Forward Elimination
    for (int k = 0; k < n - 1; k++) {
        for (int i = k + 1; i < n; i++) {
            double factor = a[i][k] / a[k][k];
            cout << "Row " << i + 1 << " -= Row " << k + 1 << " * " << factor << endl;
            for (int j = k; j < n; j++) {
                a[i][j] = a[i][j] - factor * a[k][j];
            }
            for (int j = 0; j < n; j++) {
                id[i][j] = id[i][j] - factor * id[k][j];
            }

            cout << "Updated Matrix:" << endl;
            show(a);
            show(id);

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
            for (int j = 0; j < n; j++) {
                id[i][j] = id[i][j] - factor * id[k][j];
            }

            cout << "Updated Matrix:" << endl;
            show(a);
            show(id);
        }
        cout << endl;
    }

    // normalize to 1
    for (int i = 0; i < n; i++) {
        double pivot = a[i][i];
        a[i][i] /= pivot;
        for (int j = 0; j < n; j++) {
            id[i][j] /= pivot;
        }

        cout << "Updated Matrix:" << endl;
        show(a);
        show(id);
        cout << endl;
    }

    // a^1 * b
    double x[3] = {0};
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            x[i] += id[i][j] * b[j];
        }
    }

    for (int i = 0; i < n; i++) {
        cout << "x" << i + 1 << " = " << x[i] << endl;
    }
}

int main() {
    double a[3][3] = {
        {-2, 3, 1,},
        {3, 4, -5},
        {1, -2, 1}
    };

    double id[3][3] = {
        {1, 0, 0},
        {0, 1, 0},
        {0, 0, 1}
    };

    double b[3] = {9, 0, -4};

    gaussJordan(a, b, id);

    return 0;
}
