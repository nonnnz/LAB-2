#include <bits/stdc++.h>

using namespace std;

void bubble_sort(int a[][2], int n) {
	int i,j;
	for(i=0;i<n;i++)
	for(j=0;j<n-1;j++)
	if(a[j][0] > a[j+1][0]) swap(a[j], a[j+1]);
}

void countingSort(int arr[][2], int n) {
    const int maxHour = 100;
    int count[maxHour] = {0};
    int result[n][2];

    for (int i = 0; i < n; i++) {
        count[arr[i][0]]++;
    }

    for (int i = 1; i < maxHour; i++) {
        count[i] += count[i - 1];
    }

    for (int i = n - 1; i >= 0; i--) {
        result[count[arr[i][0]] - 1][0] = arr[i][0];
        result[count[arr[i][0]] - 1][1] = arr[i][1];
        count[arr[i][0]]--;
    }

    // Copy the result back to the original array
    for (int i = 0; i < n; i++) {
        arr[i][0] = result[i][0];
        arr[i][1] = result[i][1];
    }
}

int main() {
	int n;
	cin>>n;
	int a[n][2];
	for(int i=0; i<n; i++) cin>>a[i][0]>>a[i][1];
	
	countingSort(a,n);

    // for(int i=0; i<n; i++) cout<<a[i][0]<<a[i][1]<<endl;

    int max_count = -1, start = a[0][0], end = a[0][1];
    int count = 1;

    for(int i=0; i<n-1; i++) {
        if(a[i][1] <= a[i+1][1] && a[i][1] >= a[i+1][0]) {
            count++;
            start = a[i+1][0];
            end = a[i][1];
        }
        else if(a[i+1][0] >= a[i][0] && a[i+1][1] <= a[i][1]) {
            count++;
            start = a[i+1][0];
            end = a[i+1][1];
        }
        else {
            count = 1;
        }
        if(count > max_count) max_count = count;
    }
    cout<<start<<" "<<end<<" "<<max_count;
	}