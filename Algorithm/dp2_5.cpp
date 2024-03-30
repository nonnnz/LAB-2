#include <bits/stdc++.h>

using namespace std;

#define INF 99999

// void Path(int path[V][V], int u, int v) {
//     if(u == v) {
//         cout << u << " ";
//         return;
//     }
//     if(path[u][v] == -1) {
//         cout << "No path";
//         return;
//     } else {
//         Path(path, u, path[u][v]);
//         cout << v << " ";
//     }
// }

void floydWarshall(vector<pair<int, int> > adj[], int V) {
    int dist[V][V];
    int path[V][V];
    for(int i=0; i<V; i++) {
        for(int j=0; j<V; j++) {
            dist[i][j] = INF;
            path[i][j] = -1;
        }
    }
    for(int i=0; i<V; i++) {
        dist[i][i] = 0;
    }
    for(int i=0; i<V; i++) {
        for(auto x: adj[i]) {
            dist[i][x.first] = x.second;
            path[i][x.first] = i;
        }
    }
    for(int k=0; k<V; k++) {
        for(int i=0; i<V; i++) {
            for(int j=0; j<V; j++) {
                if(dist[i][j] > dist[i][k] + dist[k][j]) {
                    dist[i][j] = dist[i][k] + dist[k][j];
                    path[i][j] = path[k][j];
                }
            }
        }
    }
    for(int i=0; i<V; i++) {
        for(int j=0; j<V; j++) {
            cout << dist[i][j] << " ";
        }
        cout << endl;
    }

    for(int i=0; i<V; i++) {
        for(int j=0; j<V; j++) {
            cout << path[i][j] << " ";
        }
        cout << endl;
    }
    // Path(path, 0, 3);
    // find path
    int u = 0;
    int v = 3;
    if(u == v) {
        cout << u << " ";
        return;
    }
    if(path[u][v] == -1) {
        cout << "No path";
        return;
    } else {
        int current = v;
        while (current != u) {
            current = path[u][current];
            if (current == -1) {
                cout << "No path";
                return;
            }
            if (current == u) {
                return;
            }
            cout << current << " ";
        }
        cout << v << " ";
    }
}

void add_edge(vector<pair<int, int> > adj[], int u, int v, int w) {
    adj[u].push_back({v, w});
    adj[v].push_back({u, w});
}

void print_graph(vector<pair<int, int> > adj[], int n) {
    for(int i=0; i<n; i++) {
        cout << i << " -> ";
        for(auto x: adj[i]) {
            cout << "(" << x.first << ", " << x.second << ")";
        }
        cout << endl;
    }
}


int main(){
    int f, n;
    cin >> f >> n;
    int flag[f];
    for(int i=0; i<f; i++) {
        cin >> flag[i];
        flag[i]--;
    }
    vector<pair<int, int> > adj[n];
    for(int j=0; j<n; j++) {
        int a, b, w;
        cin >> a >> b >> w;
        add_edge(adj, a-1, b-1, w);
    }
    floydWarshall(adj, n);

    return 0;
}