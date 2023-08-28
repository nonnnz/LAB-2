#include <bits/stdc++.h>

using namespace std;

double f(double x) {
    return log(x);
}

double df(double x, double i, double n) {
    return i/pow(x,n);
}

double factorial(double n) {
  if(n > 1)
    return n * factorial(n - 1);
  else
    return 1;
}

void taylor(double x0, double x) {
    double sum = f(x);
    double true_value = f(x0);
    double et = abs((true_value - sum)/true_value)*100;
    double i=-1;
    int n=1;
    i=i*-n;
    cout<<"n = "<<n-1<<" f(4) = "<<sum<<" et = "<<et<<"%"<<endl;
    while(et > 0.21) {
        sum += pow((x0-x),n) / factorial(n) * df(x,i,n);
        i=i*-n;
        n++;
        et = abs((true_value - sum)/true_value)*100;
        cout<<"n = "<<n<<" f(4) = "<<sum<<" et = "<<et<<"%"<<endl;
    }
}



int main() {
    double x0=4, x=2;
    cout<<fixed<<setprecision(6);
    taylor(x0, x);

    return 0;
}