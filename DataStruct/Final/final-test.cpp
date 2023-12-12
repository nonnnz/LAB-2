#include <bits/stdc++.h>

using namespace std;

class Graph {
    public:
        int edges[100][100];
        int s_v;
        Graph(int n) {
            s_v = n;
            for(int i=0; i<s_v; i++) {
                for(int j=0; j<s_v; j++) {
                    edges[i][j] = 0;
                }
            }
        }

        void add_edge(int x, int y, int w) {
            edges[x][y] = w;
        }

        void print() {
            for(int i=0; i<s_v; i++) {
                cout<<i<<":";
                for(int j=0; j<s_v; j++) {
                    if(edges[i][j] > 0) {
                        cout<<j<<","<<edges[i][j]<<" ";
                    }
                }
                cout<<endl;
            }
        }

        void bft(int start) {
            bool visited_bft[100];
            for(int i=0; i<100; i++) {
                visited_bft[i] = 0;
            }
            visited_bft[start] = 1;
            vector<int> q;
            q.push_back(start);
            while(q.empty() == 0) {
                start = q.front();
                cout<<start<<" ";
                q.erase(q.begin());
                for(int y=0; y<s_v; y++) {
                    if(visited_bft[y] == 0 && edges[start][y] > 0) {
                        visited_bft[y] = 1;
                        q.push_back(y);
                    }
                }
            }
        }

        bool visited_dft[100];
        void sub_dft(int start) {
            if(visited_dft[start] == 1) {
                return;
            }
            // cout<<start<<" ";
            visited_dft[start] = 1;
            for(int y=0; y<s_v; y++) {
                if(visited_dft[y] == 0 && edges[start][y] > 0) {
                    cout<<"sent next"<<y<<endl;
                    sub_dft(y);
                }
            }
        }

        void dft(int start) {
            for(int i=0; i<100; i++) {
                visited_dft[i] = 0;
            }
            sub_dft(start);
        }

        void connectComponectsCount() {
            int count = 0;
            for(int i=0; i<100; i++) {
                visited_dft[i] = 0;
            }
            for(int i=0; i<s_v; i++) {
                if(visited_dft[i] == 0) {
                    count++;
                    sub_dft(i);
                }
            }
            cout<<count<<endl;
        }
};

int main() {
    Graph g(5);
    g.add_edge(0, 1, 1);
    g.add_edge(0, 2, 1);
    g.add_edge(1, 3, 1);
    g.add_edge(2, 4, 1);
    g.add_edge(3, 4, 1);
    // g.add_edge(4, 0, 1);
    g.add_edge(5, 0, 0);
    g.print();
    g.bft(0);
    cout<<endl;
    // g.dft(0);
    cout<<endl;
    g.connectComponectsCount();
    return 0;
}