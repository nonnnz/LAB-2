#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        map<char, int> v;

        int max = 0;
        v.insert({s[0], 0});
        for(int i = 1; i < s.length(); i++) {
            cout<<v.cbegin()->first<<v.cend()->first<<endl;
            // cout<<v.find(s[i])<<endl;
            if(v.find(s[i]) != v.end()) {
                v.erase(v.find(s[i]));
            } else v.insert({s[i], i});
            if(v.size() > max) max = v.size();
        }
        return max;
    }
};

int main() {
    int ans = Solution().lengthOfLongestSubstring("pwwkew");
    cout<<ans<<endl;
}

