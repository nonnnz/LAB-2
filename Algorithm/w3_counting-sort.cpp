#include <bits/stdc++.h>

using namespace std;

void print(int a[], int n) {
	for(int i = 0; i < n; i++) cout<<a[i]<<" ";
	cout<<endl;
}

int main() {
	int a[] = {0, 4, 2, 2, 0, 0, 1, 1, 0, 1, 0, 2, 4, 2};
	int n = sizeof(a) / sizeof(a[0]);
	
	int max = *max_element(a, a + n);
	
	int Count[max+1] = {0};
	
	for(int i = 0; i < n; i++) Count[a[i]]++;

	print(Count, max+1);
	
	int output[n];
	int p = 0;
	for(int i = 0; i < max+1; i++) {
		while(Count[i] > 0) {
			output[p] = i;
			Count[i]--;
			p++;
		}
	}
	
	print(output, n);
	
	return 0;
}
