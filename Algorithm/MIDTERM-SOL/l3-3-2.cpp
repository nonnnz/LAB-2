#include <bits/stdc++.h>

using namespace std;

void bubble_sort(int a[], int n) {
	int i,j;
	for(i=0;i<n;i++)
	for(j=0;j<n-1;j++)
	if(a[j] > a[j+1]) swap(a[j], a[j+1]);
}

int main() {
	int n, k;
	cin>>n>>k;
	int a[n];
	for(int i=0; i<n; i++) cin>>a[i];
	
	bubble_sort(a,n);

    cout<<a[k-1];

    return 0;
}