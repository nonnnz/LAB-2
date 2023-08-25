#include <bits/stdc++.h>
using namespace std;

class open_addressing
{
	public:
		int hash_key[100];
		string hash_table[100];
		int n = 0;
		int r = 0;
		
	open_addressing(int p_n, int p_r)
	{
		n = p_n;
		r = p_r;
		for(int i=0;i<n;i++)
		{
			hash_key[i] = -1;
			hash_table[i] = "-";
		}
	}
	
	void add_double_hashing(int key, string data)
	{
		int hash2 = r - (key % r);
		for(int i=0; i<n;i++)
		{
			int j = (key + (i*hash2)) % n;
			if(hash_key[j] == -1)
			{
				hash_key[j] = key;
				hash_table[j] = data;;
				break;
			}
		}
	}
	
	string search_double_hashing(int key)
	{
		int hash2 = r - (key % r);
		for(int i=0;i<n;i++)
		{
			int j = (key + (i*hash2)) % n;
			if(hash_key[j] == key)
			{
				return hash_table[j];
			}
			if(hash_key[j] == -1)
			{
				return "-";
			}
		}
	}
	
	void print()
	{
		for(int i=0;i<n;i++)
		{
			cout<<"("<<hash_key[i]<<","<<hash_table[i]<<")";
			cout<<endl;
		}
	}
};

int main()
{
	open_addressing h(17, 11);
	char s, v[100];
	int k;
	while(s != 'e'){
		cin>>s;
		if(s == 'a') {
			cin>>k>>v;
			h.add_double_hashing(k, v);
		}
		else if(s == 'p') {
			h.print();
		}
		else if(s == 's') {
			cin>>k;
			cout<<h.search_double_hashing(k)<<endl;
		}
	}
    return 0;
}
