#include <bits/stdc++.h>

using namespace std;

int partition(int a[], int l, int r) {
	int pivot = a[r];
	int i = l-1;
	
	for(int j = l; j < r; j++) {
		if(a[j] <= pivot) {
			i++;
			swap(a[i], a[j]);
		}
	}
	
	swap(a[i+1], a[r]);
	
	return i + 1;
}

void quickSort(int a[], int l, int r) {
	int p;
	if(l < r) {
		p = partition(a, l, r);
		quickSort(a, l, p-1);
		quickSort(a, p+1, r);
	}
}

int bs(int a[], int l, int r, int k) {
	if(l <= r) {
		int m = (l+r)/2;
		if(a[m] > k) return bs(a, l, m-1, k);
		else if (a[m] < k) return bs(a, m+1, r, k);
		else return m;
	}
	else -1;
}

int main() {
	int n, k;
	cin>>n>>k;
	int a[n];
	for(int i = 0; i < n; i++) cin>>a[i];
	
	quickSort(a, 0, n-1);
	
	int min = 9999, p1, p2;
	for(int i = 0; i < n-1; i++) {
		if(a[i] > k) continue;
		int closest = bs(a,i+1,n,k-a[i]);
		if(closest == -1) continue;
		int curDiff = abs(a[closest] - a[i]);
		if(curDiff < min){
			min = curDiff;
			p1 = a[i];
			p2 = a[closest];
		}
	}
	
	cout<<p1<<" "<<p2;
}
