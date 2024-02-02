#include <bits/stdc++.h>

using namespace std;


void printA(int a[], int n) {
	for(int i=0;i<n;i++) cout<<a[i]<<" ";
	cout<<endl;
}

int partitionM(int a[],int l, int r) {
	int c = (l + r) / 2; // center
	
	if(a[l] > a[c])  // l < c < r
		swap(a[l], a[c]);
	if(a[c] > a[r])
		swap(a[c], a[r]);
	if(a[l] > a[c])
		swap(a[l], a[c]);
	swap(a[c], a[r]); // c to r
	
	int pivot = a[r];
	int i = (l-1);
	// loop i->r-1
	for(int j = l; j <= r-1; j++) {
		if(a[j] < pivot) {
			i++;
			swap(a[i], a[j]);
		}
	}
	swap(a[i+1], a[r]);
	cout<<pivot<<endl;
	
	return (i + 1);
}

int quickSelect(int a[], int l, int h, int k) {
	if(l == h) return a[l];
	printA(a, 9);
	int index = partitionM(a,l,h);
	cout<<"i="<<index<<" a="<<a[index]<<endl;
	
	if(k==index) return a[index];
	else if(k < index) 
	return quickSelect(a,l, index -1, k); // right
	else {
		k = k - index + 1;
		cout<<k<<endl;
		return quickSelect(a,index +1, h, k); // left
	}
}

int main() {
	int a[] = {1, 5, 10, 4, 8, 2, 6, 9, 20};
	int k=4;
	int n = sizeof(a) / sizeof(a[0]);
	cout<<quickSelect(a,0,n-1,k);
}
