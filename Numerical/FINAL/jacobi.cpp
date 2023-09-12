#include <bits/stdc++.h>

using namespace std;

void jacobi(double a[][4], double b[], double x[], double es) {
    int n = 4;
    int k = 1;
    double ea = 1;
    double x_new[n];
    cout<<"ITER\t"<<"X1\t"<<"X2\t"<<"X3"<<"\t""X4"<<endl;
    cout<<k<<"\t"<<x[0]<<"\t"<<x[1]<<"\t"<<x[2]<<"\t"<<x[3]<<endl;
    while(ea > es) {
        k++;

        // reset ea for check ea max
        ea = 0;
        for(int i = 0; i < n; i++) {
            double sum = b[i];
            for(int j = 0; j < n; j++) if(i != j) sum -= a[i][j]*x[j];
            x_new[i] = sum / a[i][i];
            double ea_t = abs((x_new[i] - x[i])/x_new[i]) * 100;
            // ea max
            if(ea_t > ea) ea = ea_t;
        }
        for(int i = 0; i < n; i++) x[i] = x_new[i];

        cout<<k<<"\t"<<x[0]<<"\t"<<x[1]<<"\t"<<x[2]<<"\t"<<x[3]<<endl;
    }
    
}


int main() {
    double a[4][4] = {
        {5, 2, 0, 0},
        {2, 5, 2, 0},
        {0, 2, 5, 2},
        {0, 0, 2, 5}
    };

    double b[4] = {12, 17, 14, 7};

    double es = 0.001;

    double x[4] = {0, 0, 0, 0};

    jacobi(a, b, x, es);

    return 0;
}