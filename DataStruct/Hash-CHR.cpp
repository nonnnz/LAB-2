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
	
	void add_modulo_division(int key, string data)
	{
		hash_key[key%n] = key;
		hash_table[key%n] = data;
	}
	
	string search_modulo_division(int key)
	{
		if(key == hash_key[key%n])
		{
			return hash_table[key%n];
		}
		else
		{
			return "-";
		}
	}
	
	void add_linear_probling(int key, string data)
	{
		for(int i=0; i<n; i++)
		{
			int j = (key + i) % n;
			if(hash_key[j] == -1)
			{
				hash_key[j] = key;
				hash_table[j] = data;
				break;
			}
		}
	}
	
	string search_linear_probing(int key)
	{
		for(int i=0;i<n;i++)
		{
			int j = (key + i) % n;
			if(hash_key[j] == key)
			{
				return hash_table[j];
			}
			if(hash_key[j] == -1)
			{
				return "-";
			}
		}
        return "";
	}
	
	void add_quadratic_probing(int key, string data)
	{
		for(int i=0; i<n; i++)
		{
			int j = (key + (i*i)) % n;
			if(hash_key[j] == -1)
			{
				hash_key[j] = key;
				hash_table[j] = data;;
				break;
			}
		}
	}
	
	string search_quadratic_probing(int key)
	{
		for(int i=0;i<n;i++)
		{
			int j = (key + (i*i)) % n;
			if(hash_key[j] == key)
			{
				return hash_table[j];
			}
			if(hash_key[j] == -1)
			{
				return "-";
			}
		}
        return "";
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
		}
		cout<<endl;
	}
};

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
			cout<<"("<<hash_table[i].data<<","<<hash_table[i].key<<")";
            if(hash_table[i].next != NULL)
            {
                node *t_node = hash_table[i].next;
                while(t_node->next != NULL)
                {
                    cout<<"("<<t_node->data<<","<<t_node->key<<")";
                    t_node = t_node->next;
                }
            }
            cout<<"|";
		}
        cout<<endl;
	}
};

int main()
{
    open_addressing h1(13,7);
    h1.add_modulo_division(62,"cat");
    h1.add_modulo_division(77,"b");
    h1.add_modulo_division(56,"a");
    h1.add_modulo_division(55,"d");
    h1.add_modulo_division(132,"f");
    h1.print();
    cout<<h1.search_modulo_division(62)<<endl;
    cout<<h1.search_modulo_division(3)<<endl;
    open_addressing h2(11,5);
    h2.add_linear_probling(62,"cat");
    h2.add_linear_probling(77,"b");
    h2.add_linear_probling(56,"a");
    h2.add_linear_probling(55,"d");
    h2.add_linear_probling(132,"f");
    h2.print();
    cout<<h2.search_linear_probing(132)<<endl;
    cout<<h2.search_linear_probing(35)<<endl;
    open_addressing h3(11,5);
    h3.add_quadratic_probing(62,"cat");
    h3.add_quadratic_probing(77,"b");
    h3.add_quadratic_probing(56,"a");
    h3.add_quadratic_probing(55,"d");
    h3.add_quadratic_probing(132,"f");
    h3.print();
    cout<<h3.search_quadratic_probing(55)<<endl;
    cout<<h3.search_quadratic_probing(165)<<endl;

    return 0;
}