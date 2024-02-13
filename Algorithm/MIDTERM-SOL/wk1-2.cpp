#include <bits/stdc++.h>

using namespace std;

int main() {
	int n, _max = 0, sum;
	cin>>n;
	int a[n];
	for(int i = 0; i<n; i++) {
		cin >> a[i];
		_max += a[i];
	}
	
	int ans = _max;
	
	for(int i =  0; i < n; i++) {
		for(int j = 0; j < n; j++) {
			sum = 0;
			for(int k = i; k < j + 1; k++) {
				sum += a[k];
				if (sum > ans) ans = sum;
			}
		}
	}
	
	cout<<ans<<endl;
	
	
}
