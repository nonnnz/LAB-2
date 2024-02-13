#include <bits/stdc++.h>

using namespace std;

void bubble_sort(int a[], int n) {
	int i,j;
	for(i=0;i<n;i++)
	for(j=0;j<n-1;j++)
	if(a[j] > a[j+1]) swap(a[j], a[j+1]);
}



int main() {
	int n;
	cin>>n;
	int a[n];
	for(int i=0; i<n; i++) cin>>a[i];
	
	bubble_sort(a,n);
	int count = 1;
	for(int i=0;i<n-1;i++) 
	if(a[i]-a[i+1] != 0) 
	count++;
	cout<<count;
}
