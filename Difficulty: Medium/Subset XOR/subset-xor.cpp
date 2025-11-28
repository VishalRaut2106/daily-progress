class Solution {
public:
    vector<int> subsetXOR(int n) {
        int xr;
        
        // XOR from 1 to n using known pattern
        if(n % 4 == 0) xr = n;
        else if(n % 4 == 1) xr = 1;
        else if(n % 4 == 2) xr = n + 1;
        else xr = 0;

        vector<int> ans;

        // If XOR from 1 to n already equals n
        if(xr == n) {
            for(int i = 1; i <= n; i++) ans.push_back(i);
            return ans;
        }

        // Otherwise, remove the value
        int removeEle = xr ^ n;

        for(int i = 1; i <= n; i++) {
            if(i != removeEle)
                ans.push_back(i);
        }

        return ans;
    }
};