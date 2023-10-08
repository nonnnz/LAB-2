#include <bits/stdc++.h>

using namespace std;

double splineCubic(vector<double> x, vector<double> y, double find) {
    int n_Unknown = 4 * (x.size()-1);
    // initialize matrix
    double m[n_Unknown][n_Unknown+1];
    for(int i = 0; i < n_Unknown; i++) 
        for(int j = 0; j < n_Unknown+1; j++) m[i][j] = 0;
    // through points equations
    for(int i = 0, j = 1; j < x.size()-1; i += 2, j++) {
        m[i][(j-1)*4] = pow(x[j], 3); // a
        m[i][(j-1)*4+1] = pow(x[j], 2); // b
        m[i][(j-1)*4+2] = x[j]; // c
        m[i][(j-1)*4+3] = 1; // d
        m[i][n_Unknown] = y[j]; // B
        m[i+1][j*4] = pow(x[j], 3);
        m[i+1][j*4+1] = pow(x[j], 2); 
        m[i+1][j*4+2] = x[j];
        m[i+1][j*4+3] = 1;
        m[i+1][n_Unknown] = y[j];
    }
    // begin, end
    for(int i = 2*(x.size()-2), j = 0; j < 2; i++, j++) {
        m[i][j*4*(x.size()-2)] = pow(x[j*(x.size()-1)], 3);
        m[i][j*4*(x.size()-2)+1] = pow(x[j*(x.size()-1)], 2); 
        m[i][j*4*(x.size()-2)+2] = x[j*(x.size()-1)];
        m[i][j*4*(x.size()-2)+3] = 1;
        m[i][n_Unknown] = y[j*(x.size()-1)];
    }
    // first derivative
	for (int i = (x.size()-1)*2, j = 0; i < n_Unknown-x.size(); i++, j++) {
		m[i][(j*4)] = 3*pow(x[j+1],2);
        m[i][(j*4)+1] = 2*x[j+1];
		m[i][(j*4)+2] = 1;
		m[i][(j*4)+4] = -3*pow(x[j+1],2);
        m[i][(j*4)+5] = -2*x[j+1];
		m[i][(j*4)+6] = -1;
	}
    // second derivative
	for (int i = (x.size())*2+1, j = 0; i < n_Unknown-2; i++, j++) {
		m[i][(j*4)] = 6*x[j+1];
        m[i][(j*4)+1] = 2;
		m[i][(j*4)+4] = -6*x[j+1];
        m[i][(j*4)+5] = -2;
	}    
    // boundary conditions
    m[n_Unknown-2][0] = 6*x[0];
    m[n_Unknown-2][1] = 2;
    m[n_Unknown-1][n_Unknown-4] = 6*x[x.size()-1];
    m[n_Unknown-1][n_Unknown-4+1] = 2;

    // print
    for (int r = 0; r < n_Unknown; r++) {
        for (int c = 0; c < n_Unknown+1; c++) {
            cout << m[r][c] << "\t";
        }
        cout<<endl;
    }
    cout<<endl;

    // gauss jordan
    // forward
    for (int i = 0; i < n_Unknown - 1; i++) {
        if (m[i][i] == 0)
        {
            int c = 1;
            while ((i + c) < n_Unknown && m[i + c][i] == 0)
                c++;           
            for (int j = i, k = 0; k <= n_Unknown; k++)
                swap(m[j][k], m[j+c][k]);
        }
        for (int j = i + 1; j < n_Unknown; j++) {
                double factor = m[j][i] / m[i][i];
                for (int k = i; k < n_Unknown+1; k++) {
                    m[j][k] = m[j][k] - (m[i][k]) * factor;
                    m[i][j] = abs(m[i][j]) < 1e-6 ? 0 : m[i][j]; // define zero 
                }      
            }
    }
    // back eli
    for (int k = n_Unknown - 1 ; k >= 0; k--) {
        for (int i = k - 1; i >= 0; i--){
            double factor = m[i][k] / m[k][k];
            for (int j = k; j < n_Unknown+1; j++) {
                m[i][j] = m[i][j] - factor * m[k][j];
                m[i][j] = abs(m[i][j]) < 1e-6 ? 0 : m[i][j]; // define zero
            }
        }
    }

    // normalize to 1
    for (int i = 0; i < n_Unknown; i++) {
        double pivot = m[i][i];
        m[i][i] /= pivot;
        m[i][n_Unknown] /= pivot;
    }

    // print
    for (int r = 0; r < n_Unknown; r++) {
        for (int c = 0; c < n_Unknown+1; c++) {
            cout << m[r][c] << "\t";
        }
        cout<<endl;
    }
    cout<<endl;

    double eq[n_Unknown];
    for (int i = 0; i < n_Unknown; i++) {
        eq[i] = m[i][n_Unknown];
    }

    for (int i = 0; i < x.size() - 1; i++) {
        if (find >= x[i] && find <= x[i + 1]) {
            return eq[i*4]*pow(find,3)+eq[i*4+1]*pow(find,2)+eq[i*4+2]*find+eq[i*4+3];
        }
    }

    return 0;
}

int main() {
    vector<double> x = {2, 4, 6, 8, 10};
    vector<double> y = {9.5, 8, 10.5, 39.5, 72.5};
    double find = 4.5;

    cout << splineCubic(x, y, find) << endl;
    
    return 0;
}
