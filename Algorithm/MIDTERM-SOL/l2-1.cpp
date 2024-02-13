#include <bits/stdc++.h>

using namespace std;

int bs(int a[], int l, int r, int k) {
	if (l < r) {
		int x = l+round(((k-a[l])*(r-l))/(a[r]-a[l]+0.0));
		cout<<x<<" ";
		if (a[x] == k) return x;
		if (a[x] > k) return bs(a, l, x-1, k);
		else return bs(a, x+1, r, k);
	} else return -1;
}

int main() {
	int n,k;
	cin>>n>>k;
	int a[n];
	for(int i=0; i<n; i++) cin>>a[i];
	
	bs(a, 0, n-1, k);
}
