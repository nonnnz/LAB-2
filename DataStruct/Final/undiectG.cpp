#include <bits/stdc++.h>

using namespace std;

class undiect_graph {
    public:
    int edges[100][100];
    int s_v;

    void bulit_graph(vector<vector<int>> ed) {
        for(int i=0; i<100; i++) {
            for(int j=0; j<100; j++) {
                edges[i][j] = 0;
            }
        }
        s_v = ed.size();
        for(int i=0; i<s_v; i++) {
            edges[ed[i][0]][ed[i][1]] = 1;
            edges[ed[i][1]][ed[i][0]] = 1;
        }
    }

    void print() {
        for(int i=0; i<100; i++) {
            bool has_edges = false;
            for(int j=0; j<100; j++) {
                if(edges[i][j] > 0) {
                    has_edges = true;
                    break;
                }
            }
            if (has_edges) {
                cout<<i<<":";
                for(int j=0; j<100; j++) {
                    if(edges[i][j] > 0) {
                        cout<<j<<","<<edges[i][j]<<" ";
                    }
                }
                cout<<endl;
            }
        }
    }

    void sub_dft(int start, bool visited[]) {
        if(visited[start] == 1) {
            count = 0;
            return;
        }
        cout<<start<<" ";
        visited[start] = 1;
        for(int y=0; y<s_v; y++) {
            if(visited[y] == 0 && edges[start][y] > 0) {
                count++;
                sub_dft(y, visited);
            }
        }
    }

    void connectedComponent() {
        bool visited[100];
        for(int i=0; i<100; i++) {
            visited[i] = 0;
        }
        for(int i=0; i<s_v; i++) {
            if(visited[i] == 0) {
                cout<<"{";
                sub_dft(i, visited);
                cout<<"}"<<endl;
            }
        }
    }
    int count = 0;

    void largestComponent() {
        bool visited[100];
        for(int i=0; i<100; i++) {
            visited[i] = 0;
        }
        int max = 0;
        int max_i = 0;
        for(int i=0; i<s_v; i++) {
            if(visited[i] == 0) {
                sub_dft(i, visited);
                cout<<endl;
                if(count > max) {
                    max = count;
                    max_i = i;
                }
            }
        }
        cout<<max_i<<endl;
    }

    void shortestPath(int start, int end) {
        queue<int> q;
        bool visited[100] = {false};
        int distance[100] = {0};
        int parent[100] = {-1};

        q.push(start);
        visited[start] = true;

        while (!q.empty()) {
            int current = q.front();
            q.pop();

            if (current == end) {
                // Build and print the shortest path
                cout << "Shortest path from " << start << " to " << end << ": ";
                vector<int> path;
                int node = end;
                while (node != -1) {
                    path.push_back(node);
                    node = parent[node];
                }
                for (int i = path.size() - 1; i >= 0; i--) {
                    cout << path[i];
                    if (i > 0) cout << " -> ";
                }
                cout << endl;
                return;
            }

            for (int neighbor = 0; neighbor < s_v; neighbor++) {
                if (edges[current][neighbor] && !visited[neighbor]) {
                    visited[neighbor] = true;
                    distance[neighbor] = distance[current] + 1;
                    parent[neighbor] = current;
                    q.push(neighbor);
                }
            }
        }

        cout << "No path found from " << start << " to " << end << endl;
    }
};

int main() {
    undiect_graph g;
    vector<vector<int>> ed = {
        {0, 1},
        {0, 2},
        // {1, 3},
        {1, 4},
        {2, 5},
        {2, 6},
        // {3, 7},
        {4, 7},
        {8, 9},
        {9, 10},
        {10, 8}
    };
    g.bulit_graph(ed);
    g.print();
    g.connectedComponent();
    g.largestComponent();
    g.shortestPath(0, 7);
    return 0;
}