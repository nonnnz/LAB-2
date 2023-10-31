#include <bits/stdc++.h>

using namespace std;

class Heap {
	public:
		int q[1000];
		
		Heap() {
			q[0] = 0;
		}

		void add(int n) {
			q[0] += 1;
			q[q[0]] = n;
			int i = q[0];
		}
		
		void heapify() {
			int j = q[0];
			if(j%2==0) {
				q[j+1] = -INT_MAX;
			} else {
				j = j-1;
			}
			while(j >= 1) {
                cout<<"j = "<<j<<endl;
				int i = j;
				while(i <= q[0]) {
					int p = i/2;
					int r = i+1;
					int l = i;
					if(q[l] >= q[r] && q[l] > q[p]) {
						int t = q[l];
						q[l] = q[p];
						q[p] = t;
						i = 2*l;
					} else if (q[r] > q[l] && q[r] > q[p]) {
						int t = q[r];
						q[r] = q[p];
						q[p] = t;
						i = 2*r;
					} else {
						break;
					}
                    cout<<"i = "<<i<<endl;
                    print();
				}
				j = j-2;
			}
		}

        // BEGIN: heap-sort
        void heapSort() {
            int n = q[0];
            for (int i = n; i >= 1; i--) {
                q[i] = del();
            }
            q[0] = n;
        }
        // END: heap-sort
		
		void insert(int n) {
			if(q[0] < 999) {
				q[0] = q[0] + 1;
				q[q[0]] = n;
				int i = q[0];
				while(i > 1 && q[i/2] < q[i]) { // move
					int t = q[i/2];
					q[i/2] = q[i];
					q[i] = t;
//					cout<<"move "<<t<<" to "<<i<<endl;
					i = i/2;
				}
			}
		}
		
		int del() {
			if(q[0] > 0) {
				int s = q[1];
				q[1] = q[q[0]]; // last
				q[0] = q[0]-1;
				int p = 1;
				while(p <= q[0]) {
//					print();
					int l = p*2;
					int r = (p*2)+1;
					// swap if > parent
					if(l <= q[0] && q[l] > q[p] && q[l] >= q[r]) {
						int t = q[l];
						q[l] = q[p];
						q[p] = t;
						p = l;
                        cout<<r<<":"<<q[r]<<endl;
					} else if(r <= q[0] && q[r] > q[p] && q[r] > q[l]) {
						int t = q[r];
						q[r] = q[p];
						q[p] = t;
						p = r;
					} else {
						break;
					}
//					cout<<"p = "<<p<<endl;
				}
				return s;
			}
			else {
				return -1;
			}
		}
		
		void print() {
			for(int i = 1; i <= q[0]; i++) {
				if(i==q[0])cout<<q[i];
				else cout<<q[i]<<" ";
			}
			cout<<endl;
		}
};

// BEGIN: min-heap
class MinHeap {
    public:
        int q[1000];
        
        MinHeap() {
            q[0] = 0;
        }

        void add(int n) {
            q[0] += 1;
            q[q[0]] = n;
            int i = q[0];
            while (i > 1 && q[i/2] > q[i]) {
                int t = q[i/2];
                q[i/2] = q[i];
                q[i] = t;
                i = i/2;
            }
        }

        int del() {
            if (q[0] > 0) {
                int s = q[1];
                q[1] = q[q[0]];
                q[0] = q[0] - 1;
                int p = 1;
                while (p <= q[0]) {
                    int l = p*2;
                    int r = (p*2) + 1;
                    if (l <= q[0] && q[l] < q[p] && q[l] <= q[r]) {
                        int t = q[l];
                        q[l] = q[p];
                        q[p] = t;
                        p = l;
                    } else if (r <= q[0] && q[r] < q[p] && q[r] < q[l]) {
                        int t = q[r];
                        q[r] = q[p];
                        q[p] = t;
                        p = r;
                    } else {
                        break;
                    }
                }
                return s;
            } else {
                return -1;
            }
        }

        void print() {
            for (int i = 1; i <= q[0]; i++) {
                if (i == q[0]) {
                    cout << q[i];
                } else {
                    cout << q[i] << " ";
                }
            }
            cout << endl;
        }
};
// END: min-heap

int main() {
	Heap h;
	char c;
	int n;

	while(c!='e') {
		cin>>c;
		if(c=='a') {
			cin>>n;
			h.insert(n);
		}
        if(c=='n') {
			cin>>n;
			h.add(n);
		}
		else if(c=='p') h.print();
		else if(c=='d') cout<<h.del()<<endl;
        else if(c=='h') h.heapify();
        else if(c=='s') h.heapSort();
	}
}
