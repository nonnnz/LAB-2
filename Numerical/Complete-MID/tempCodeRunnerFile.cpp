#include <bits/stdc++.h>

using namespace std;

double det(double mat[3][3]) {
    return mat[0][0] * (mat[1][1] * mat[2][2] - mat[1][2] * mat[2][1]) -
           mat[0][1] * (mat[1][0] * mat[2][2] - mat[1][2] * mat[2][0]) +
           mat[0][2] * (mat[1][0] * mat[2][1] - mat[1][1] * mat[2][0]);
}

void cramerrule(double a[3][3], double b[3]) {
    int n = 3;
    double A[3][3];
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            A[i][j] = a[i][j];
        }
    }

    double detA = det(A);
    if (detA == 0) return;

    double x[n];
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            A[j][i] = b[j];
        }
        x[i] = det(A) / detA;
        cout << "x" << i + 1 << " = " << det(A) << "/" << detA << " = " << x[i] << endl;
        for (int j = 0; j < n; j++) {
            A[j][i] = a[j][i];
        }
    }
}

int main() {
    double a[3][3] = {
        {-2, 3, 1},
        {3, 4, -5},
        {1, -2, 1}
    };

    double b[3] = {9, 0, -4};

    cramerrule(a, b);

    return 0;
}