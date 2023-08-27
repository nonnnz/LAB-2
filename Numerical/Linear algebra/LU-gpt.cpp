#include <iostream>
#include <vector>

using namespace std;

const int n = 3;

// Forward declaration of functions
void LU(double a[n][n], double l[n][n], double u[n][n]);
void ForwardSubstitution(double l[n][n], double b[n], double y[n]);
void BackSubstitution(double u[n][n], double y[n], double x[n]);

int main() {
    double a[n][n] = {
        {-2, 3, 1},
        {3, 4, -5},
        {1, -2, 1}
    };

    double b[n] = {9, 0, -4};
    double l[n][n];  // Lower triangular matrix
    double u[n][n];  // Upper triangular matrix
    double y[n];     // Intermediate vector
    double x[n];     // Solution vector

    // Step 1: LU Decomposition
    LU(a, l, u);

    // Step 4: Forward Substitution (LY = B)
    ForwardSubstitution(l, b, y);

    // Step 5: Back Substitution (UX = Y)
    BackSubstitution(u, y, x);

    // Printing the solution vector x
    cout << "Solution vector x:" << endl;
    for (int i = 0; i < n; ++i) {
        cout << x[i] << " ";
    }
    cout << endl;

    return 0;
}

// Function to perform LU decomposition
void LU(double a[n][n], double l[n][n], double u[n][n]) {
    // Initialize L and U matrices
    for (int i = 0; i < n; ++i) {
        for (int j = 0; j < n; ++j) {
            if (i == j) {
                l[i][j] = 1; // Diagonal elements of L are 1
                u[i][j] = a[i][j];
            } else if (i < j) {
                l[i][j] = 0;
                u[i][j] = a[i][j];
            } else {
                l[i][j] = a[i][j];
                u[i][j] = 0;
            }
        }
    }

    // Gaussian elimination to get LU decomposition
    for (int k = 0; k < n; ++k) {
        for (int i = k + 1; i < n; ++i) {
            l[i][k] = u[i][k] / u[k][k];
            for (int j = k; j < n; ++j) {
                u[i][j] -= l[i][k] * u[k][j];
            }
        }
    }
}

// Function for forward substitution
void ForwardSubstitution(double l[n][n], double b[n], double y[n]) {
    y[0] = b[0] / l[0][0];
    for (int i = 1; i < n; ++i) {
        double sum = 0;
        for (int j = 0; j < i; ++j) {
            sum += l[i][j] * y[j];
        }
        y[i] = (b[i] - sum) / l[i][i];
    }
}

// Function for back substitution
void BackSubstitution(double u[n][n], double y[n], double x[n]) {
    x[n - 1] = y[n - 1] / u[n - 1][n - 1];
    for (int i = n - 2; i >= 0; --i) {
        double sum = 0;
        for (int j = i + 1; j < n; ++j) {
            sum += u[i][j] * x[j];
        }
        x[i] = (y[i] - sum) / u[i][i];
    }
}
