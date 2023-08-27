#include <bits/stdc++.h>

using namespace std;

const int n = 3;

void show(double m[n][n]) {
    for (int r = 0; r < n; r++) {
        for (int c = 0; c < n; c++) {
            cout << m[r][c] << "\t";
        }
        cout<<endl;
    }
    cout<<endl;
}

void Decompose(double a[n][n], double l[n][n], double u[n][n]) {
    for (int i = 0; i < n; i++) {
        // lower
        for (int k = i; k < n; k++) { 
            double sum = 0;
            for (int j = 0; j < i; j++) {
                sum += (l[k][j] * u[j][i]);
            }
            l[i][k] = 0;
            l[k][i] = a[k][i] - sum;
            cout<<"L("<<k+1<<", "<<i+1<<") ";
            cout<<a[i][k]<<" + ("<<sum<<")"<<endl;
        }

        // upper
        for (int k = i; k < n; k++) { 
            if (i == k) {
                u[i][i] = 1;
            } else {
                double sum = 0;
                for (int j = 0; j < i; j++) {
                    sum += (l[i][j] * u[j][k]);
                }
                u[k][i] = 0;
                u[i][k] = (a[i][k] - sum) / l[i][i];
                cout<<"U("<<i+1<<", "<<k+1<<") ";
                cout<<"("<<a[i][k]<<" + ("<<sum<<")" <<") / "<<l[i][i]<<endl;
            }

        }
    }

    cout<<"L:"<<endl;
    show(l);
    cout<<"U:"<<endl;
    show(u);
}

void ForwardSubstitution(double l[n][n], double y[n], double b[n]) {
    y[0] = b[0] / l[0][0];
    for (int i = 1; i < n; i++) {
        double sum = 0;
        for (int j = 0; j < i; j++) {
            sum += l[i][j] * y[j];
        }
        y[i] = (b[i] - sum) / l[i][i];
    }
}

void BackSubstitution(double u[n][n], double y[n], double x[n]) {
    x[n - 1] = y[n - 1] / u[n - 1][n - 1];
    for (int i = n - 2; i >= 0; i--) {
        double sum = 0;
        for (int j = i + 1; j < n; j++) {
            sum += u[i][j] * x[j];
        }
        x[i] = (y[i] - sum) / u[i][i];
    }
}

int main() {
    // cout << fixed << setprecision(6);
    double a[n][n] = {
        {-2, 3, 1},
        {3, 4, -5},
        {1, -2, 1}
    };

    double b[n] = {9, 0, -4};
    double l[n][n], u[n][n], y[n], x[n];

    // A = LU
    Decompose(a, l, u);

    // Forward Sub LY = B
    ForwardSubstitution(l, y, b);

    // Back Sub Ux = Y
    BackSubstitution(u, y, x);

    for (int i = 0; i < n; ++i) 
        cout<<"y"<<i+1<<" = "<<y[i]<<endl;
    cout<<endl;
    for (int i = 0; i < n; ++i) 
        cout<<"x"<<i+1<<" = "<<x[i]<<endl;
    return 0;
}