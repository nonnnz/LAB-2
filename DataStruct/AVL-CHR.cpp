#include <bits/stdc++.h>

using namespace std;

class node {
	public:
	node *right;
	node *left;
	int value = 0;
	int height;
	node(int h = 0) {
		value = 0;
		left = NULL;
		right = NULL;
		height = h;
	}
	node(int v, int h = 0) {
		value = v;
		left = NULL;
		right = NULL;
		height = h;
	}
	node(int v, node *lt, node *rt, int h = 0) {
		value = v;
		left = lt;
		right = rt;
		height = h;
	}
};

class tree {
	public:
	node *r;

	int max( int lhs, int rhs ) const {
	    return lhs > rhs ? lhs : rhs;
	}
	
	node* findMin( node *t ) const {
    if ( t == NULL)
        return t;
    while ( t->left != NULL )
        t = t->left;
    return t;
	}
	
	int height( node *t ) const{
		return t == NULL ? -1 : t->height;
	}
	
	void insert( int x, node *&t) {
		node* k;
		cout<<(k->value == -1)<<endl;
		cout<<(t == NULL);
		if( t == NULL ) {
			cout<<"first";
			t = new node{ x, NULL, NULL };
		}
		else if( x < t->value )
			insert( x, t->left );
		else if( t->value < x )
			insert( x, t->right );
		balance( t );
	}
	
	static const int ALLOWED_IMBALANCE = 1;
	
	void balance( node *&t)
	{
	if( t == NULL )
		return;

	if( height( t->left ) - height( t->right ) > ALLOWED_IMBALANCE )
		if( height( t->left->left ) >= height( t->left->right ) )
			rotateWithLeftChild( t );
		else
			doubleWithLeftChild( t );
	else
	if( height( t->right ) - height( t->left ) > ALLOWED_IMBALANCE )
		if( height( t->right->right ) >= height( t->right->left ) ) {
//			cout<<t->value<<endl;
			rotateWithRightChild( t );
		}
		else
			doubleWithRightChild( t );

	t->height = max( height( t->left ), height( t->right ) ) + 1;
	}
	
	void rotateWithLeftChild( node * & k2 ) {
		node *k1 = k2->left;
		k2->left = k1->right;
		k1->right = k2;
		k2->height = max( height( k2->left ), height( k2->right ) ) + 1;
		k1->height = max( height( k1->left ), k2->height ) + 1;
		k2 = k1;
	}
	
	void doubleWithLeftChild( node * & k3 )
	{
		rotateWithRightChild( k3->left );
		rotateWithLeftChild( k3 );
	}
	
	void rotateWithRightChild( node * & k1 ) {
//		cout<<k1->value<<endl;
		node *k2 = k1->right;
//		cout<<k2->value<<endl;
		k1->right = k2->left;
		k2->left = k1;
		k1->height = max( height( k1->left ), height( k1->right ) ) + 1;
		k2->height = max( height( k2->left ), k1->height ) + 1;
		k1 = k2;
	}
	
	void doubleWithRightChild( node * & k1 )
	{
//		cout<<k1->value<<endl;
		rotateWithLeftChild( k1->right );
		rotateWithRightChild( k1 );
	}	

	void remove( int x, node *&t)
	{
		if( t == NULL )
			return; // Item not found; do nothing
	
		if( x < t->value )
			remove( x, t->left );
		else if( t->value < x )
			remove( x, t->right );
		else if( t->left != NULL && t->right != NULL ) // Two children
		{
			t->value = findMin( t->right )->value;
			remove( t->value, t->right );
		}
		else
		{
			node *oldNode = t;
			t = ( t->left != NULL ) ? t->left : t->right;
			delete oldNode;
		}
	
		balance( t );
	}
	
	bool search(int value) {
		node *n = r;
		while (true)
		{
			if (n->value > value && n->left != NULL) {
				n = n->left;
			}
			else if(n->value < value && n->right != NULL) {
				n = n->right;
			}
			else if(n->value == value) {
				return true;
			}
			else {
				return false;	
			}
		}
	
	}
	
	void preorder_traversal(node *n) {
		if(n != NULL) {
			cout<<n->value<<" ";
			preorder_traversal(n->left);
			preorder_traversal(n->right);
		}
	}
	
	void inorder_traversal(node *n) {
		if(n != NULL) {
			inorder_traversal(n->left);
			cout<<n->value<<",";
			inorder_traversal(n->right);
		}
	}
	
	void postorder_traversal(node *n) {
		if(n != NULL) {
			postorder_traversal(n->left);
			postorder_traversal(n->right);
			cout<<n->value<<",";
		}
	}
};

int main() {
	tree t;
	char cm;
	while(cm!='x') {
		cin>>cm;
		if(cm=='a') {
			int ele;
			cin>>ele;
			t.insert(ele, t.r);
		}
		else if(cm=='d') {
			int ele;
			cin>>ele;
			t.remove(ele, t.r);
		}
		else if(cm=='p') {
			t.preorder_traversal(t.r);
			cout<<endl;
		}
	}
}
