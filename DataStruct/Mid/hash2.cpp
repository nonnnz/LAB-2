#include <iostream>

using namespace std;

class open_addressing {
    public:
        int h_k[100];
        string h_t[100];
        int n = 0;
        int r = 0;

        open_addressing(int p_n, int p_r) {
            n = p_n;
            r = p_r;
            for(int i=0;i<n;i++) {
                h_k[i] = -1;
                h_t[i] = "-";
            }
        }

        void add_db(int key, string data) {
            int hash2 = r - (key% r);

        }

};