#include <bits/stdc++.h>

using namespace std;

int bs(int a[], int l, int r, int k) {
	if (l <= r) {
		int mid = (l+r)/2;
		if (a[mid] == k) return mid;
		if (a[mid] > k) return bs(a, l, mid-1, k);
		else return bs(a, mid+1, r, k);
	} else return -1;
}

void bubble_sort(int a[], int n) {
	int i,j;
	for(i=0;i<n;i++)
	for(j=0;j<n-1;j++)
	if(a[j] > a[j+1]) swap(a[j], a[j+1]);
}

int main() {
	int n,k;
	cin>>n>>k;
	int a[n];
	for(int i=0; i<n; i++) cin>>a[i];
	
	bubble_sort(a,n);
	int ans[3];
	ans[2] = 9999;
	
	for(int i=0; i<n; i++) {
		if(k-a[i] >= 0) {
			int find = bs(a, i+1, n-1, k-a[i]);
			if (find != -1)
				if (abs(a[i] - a[find]) < ans[2]) {
					ans[0] = a[i];
					ans[1] = a[find];
					ans[2] = abs(a[i] - a[find]);
				}
			}
		}

		if(ans[2] == 9999) cout<<"-1";
		else cout<<ans[0]<<" "<<ans[1];
	}