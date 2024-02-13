#include <bits/stdc++.h>

using namespace std;

void print(int a[], int n, int min, bool isCount = false) {
	
    for(int i = min; i < n; i++) if(isCount) {if(a[i] > 0) cout<<a[i]<<" ";}
    else cout<<a[i]<<" ";
	cout<<endl;
}

int main() {
	// int a[] = {-1, 0, 4, 2, 2, 0, 0, 1, 1, 0, 1, 0, 2, 4, 2};
	// int n = sizeof(a) / sizeof(a[0]);
	int n, k;
	cin>>n>>k;
	int a[n];
	for(int i = 0; i < n; i++) cin>>a[i];
	
	// int max = *min_element(a, a + n);
	int max = 9999, min = a[0];
	int Count[max+1] = {0};
	
	for(int i = 0; i < n; i++) {
        if(a[i] < min) min = a[i];
        Count[a[i]]++;
    }

	// print(Count, max+1, min, true);
	
	int output[n];
	int p = 0;
	for(int i = min; i < max+1; i++) {
		while(Count[i] > 0) {
			output[p] = i;
			Count[i]--;
			p++;
		}
	}
	
	// print(output, n, 0);
	cout<<output[k-1];

	
	return 0;
}
