#include <bits/stdc++.h>

using namespace std;

class heap {
    public:
        int arr[100];
        heap() {
            arr[0] = 0;
        }

        void insert(int x) {
            arr[0] += 1;
            arr[arr[0]] = x;
            int i = arr[0];
            while(i > 1 && arr[i/2] < arr[i]) {
                swap(arr[i/2], arr[i]);
                i = i/2;
            }
        }

        int del() {
            if(arr[0] == 0) {
                return -1;
            }
            int s = arr[1];
            arr[1] = arr[arr[0]];
            arr[0] -= 1;
            int p = 1;
            while(p <= arr[0]) {
                int l = 2*p;
                int r = 2*p+1;
                if(l <= arr[0] && arr[l] > arr[p] && arr[l] > arr[r]) {
                    swap(arr[l], arr[p]);
                    p = l;
                } else if(r <= arr[0] && arr[r] > arr[p] && arr[r] > arr[l]) {
                    swap(arr[r], arr[p]);
                    p = r;
                } else {
                    break;
                }
            }
            return s;
        }

        void sort() {
            int n = arr[0];
            for(int i=n; i>=1; i--) {
                arr[i] = del();
            }
            arr[0] = n;
        }

        void print() {
            for(int i=1; i<=arr[0]; i++) {
                cout<<arr[i]<<" ";
            }
            cout<<endl;
        }
};

int main() {
    heap h;
    h.insert(1);
    h.insert(2);
    h.insert(3);
    h.insert(4);
    h.insert(5);
    h.print();
    h.sort();
    h.print();
}