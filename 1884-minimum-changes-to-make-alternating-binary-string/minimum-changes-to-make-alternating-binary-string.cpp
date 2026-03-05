class Solution {
public:
    int minOperations(string s) {
        int prev = 0 ;
        int count = 0;
        int n = s.size();
        for(int i = 0 ; i < s.size(); i++){
            int bit = s[i] - '0';
            if(bit ==prev){
                bit = 1 - prev;
                count++;
            }
            prev = bit;
        }
        return min(n - count, count);
    }
};