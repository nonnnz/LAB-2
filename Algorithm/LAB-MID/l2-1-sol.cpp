#include <bits/stdc++.h>

using namespace std;

int interpolation(int a[], int l, int r, int k) {
	if(l <= r) {
		int x = l+round(((k-a[l])*(r-l))/(a[r]-a[l]+0.0));
		cout<<x<<" ";
		if(a[x] == k) return x; // base case
		if(a[x] > k) return interpolation(a, l, x-1, k); // left side
		else return interpolation(a, x+1, r, k); // right
	} 
	else return -1;
}

int main() {
	// interpolation search (near k)
	int n, k;
	cin>>n>>k;
	int a[n];
	for(int i = 0; i < n; i++) cin>>a[i];
	
	interpolation(a, 0, n-1, k);
}
