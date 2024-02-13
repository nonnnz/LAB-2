#include <bits/stdc++.h>

using namespace std;

void print(int a[], int n) {
	for(int i = 0; i < n; i++) cout<<a[i]<<" ";
	cout<<endl;
}

int findMax(int a[], int l, int r) {
	if(l == r) return a[l];
	
	int m = (l + r) / 2;
	int m1 = findMax(a, l, m);
	int m2 = findMax(a, m+1, r);
	cout<<m1<<">"<<m2<<endl;
	return (m1 > m2) ? m1: m2;
}

int main() {
	int a[] = {34, 3, 47, 91, 32, 0};
	int n = sizeof(a) / sizeof(a[0]);
	
	findMax(a, 0, n);
	
	return 0;
}
