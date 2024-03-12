#include <bits/stdc++.h>

using namespace std;

int main() {
	int n = 4;
	int W = 25;
	int a[][2] = {{18,25}, {15, 24}, {10, 5}, {5, 8}};
	float t[n]; // t, index
	int t_i[n];
	for(int i=0; i<n; i++) {
		t[i] = a[i][1]/(a[i][0]+0.0);
		t_i[i] = i;
	}
	
	for(int i = 0 ; i < n - 1; i++){
	    for(int j = 0 ; j < n - 1 ; j++){
	        if(t[j] < t[j + 1]) {
	        	swap(t[j],t[j + 1]);
	        	swap(t_i[j],t_i[j+1]);
			}  
	    }
	}
    
//    for(int i=0; i<n; i++) {
//    	cout<<t[i]<<endl;
//    	cout<<a[t_i[i]][0]<<", "<<a[t_i[i]][1]<<endl;
//	}
	int w_cal = 0;
	float p = 0;
	float ans[n]={0};
	for(int i = 0; i<n; i++) {
		if(w_cal<W) {
			w_cal += a[t_i[i]][0];
			if(w_cal > W) {
				w_cal-= a[t_i[i]][0];
				int temp = a[t_i[i]][0]*((W-w_cal)/a[t_i[i]][0]);
				w_cal += temp;
				ans[t_i[i]] = ((W-w_cal)/(a[t_i[i]][0]+0.0));
				int temp_p = a[t_i[i]][1]*((W-w_cal)/a[t_i[i]][1]);
				p += ans[t_i[i]]*a[t_i[i]][1];
				break;
			}
			ans[t_i[i]] = 1;
			p += a[t_i[i]][1];
		}
	}
	
	
    for(int i=0; i<n; i++) {
    	cout<<fixed<<setprecision(2)<<ans[i]<<" ";
	}	
	cout<<endl<<p;
	
	return 0;
}
