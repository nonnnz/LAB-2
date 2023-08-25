#include <bits/stdc++.h>
using namespace std;

class node
{
	public:
		int key;
		string data;
		node *next;
		node()
		{
			key = -1;
			data = "-";
			next = NULL;
		}
		
		node(string s, int k)
		{
			key = k;
			data = s;
			next = NULL;
		}
};

class separate_chaining
{
	public:
		int n;
		node hash_table[100];
		separate_chaining(int p_n)
		{
			n = p_n;
		}
		
	void add(int key, string data)
	{
		int j = key%n;
		if(hash_table[j].next == NULL)
		{
			hash_table[j].data = data;
			hash_table[j].key = key;
			hash_table[j].next = new node();
		}
		else
		{
			node *t_node = hash_table[j].next;
			while(t_node->next != NULL)
			{
				t_node = t_node->next;
			}
			t_node->data = data;
			t_node->key = key;
			t_node->next = new node();
		}
	}
	
	string search(int key)
	{
		int j = key%n;
		if(hash_table[j].key == -1) return "-";
		if(hash_table[j].key == key)
		{
			return hash_table[j].data;
		}
		else
		{
			node *t_node = hash_table[j].next;
			
			while(t_node->next != NULL)
			{
				if(key == t_node->key)
				{
					return t_node->data;
				}
				t_node = t_node->next;
			}
		}
		return "-";
	}
	
	void print()
	{
		for(int i=0;i<n;i++)
		{
			cout<<"("<<hash_table[i].key<<","<<hash_table[i].data<<")";
            if(hash_table[i].next != NULL)
            {
                node *t_node = hash_table[i].next;
                while(t_node->next != NULL)
                {
                    cout<<" "<<"("<<t_node->key<<","<<t_node->data<<")";
                    t_node = t_node->next;
                }
            }
            cout<<endl;
		}
        
	}
};

int main()
{
	separate_chaining h(17);
	char s, v[100];
	int k;
	while(s != 'e'){
		cin>>s;
		if(s == 'a') {
			cin>>k>>v;
			h.add(k, v);
		}
		else if(s == 'p') {
			h.print();
		}
		else if(s == 's') {
			cin>>k;
			cout<<h.search(k)<<endl;
		}
	}
    return 0;
}
