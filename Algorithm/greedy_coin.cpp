#include <bits/stdc++.h>

using namespace std;

int coin_changing(int W, int D[], int n) {
	int num=0, i=n-1;
	
	sort(D, D + n);
	
	while((W>0) && (i>=0)) {
		int coin=W/D[i];
		num = num + coin;
		cout<<D[i]<<"x"<<coin<<endl;
		W = W - coin * D[i--];
	}
	
	return num;
}

int main() {
	int d[] = {1, 3, 4, 5};
	int n = sizeof(d) / sizeof(d[0]);
	
	cout<<coin_changing(7, d, n);
	// 7 not works for 1, 3, 4, 5
	
	return 0;
}
