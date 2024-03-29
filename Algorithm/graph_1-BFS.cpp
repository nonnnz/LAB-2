#include <bits/stdc++.h>

using namespace std;

void BFS(vector<vector<int> >g, int start, int dest, vector<bool> visited) {
	vector<int> parent_child(g.size(), -1);
	queue<int> q;
	q.push(start);
	visited[start] = true;
	
	while(!q.empty()) {
		int cur = q.front();
		q.pop();
//		cout << cur << " ";
		for(int i=0; i<g.size(); i++) {
			if(g[cur][i] && !visited[i]) {
				q.push(i);
				parent_child[i] = cur;
				visited[i] = true;
			}
		}
	}
	
//	cout<<endl;
//	for(int i=0; i<g.size(); i++) cout << parent_child[i] << " ";
	// find path
	int count = -1;
	int d = dest;
	while(d!=-1) {
		d = parent_child[d];
		count++;
	}
	cout<<count;
}

int main() {
	vector<vector<int> > g;
	int n;
	cin >> n;
	for(int i=0; i<n; i++) {
		g.push_back(vector<int>(n, 0));
	}
	
	for(int i=0; i<n; i++) {
		int t;
		while(true) {
			cin >> t;
			if(t == -1) break;
			g[i][t] = 1;
		}
	}
	int s,d;
	cin >> s >> d;
	
//	for(int i=0; i<n; i++) {
//		for(int j=0; j<n; j++) {
//			cout<<g[i][j]<<" ";
//		}
//		cout<<endl;
//	}

	vector<bool> visited(g.size(), false);
	BFS(g,s,d,visited);
	
	return 0;
}
