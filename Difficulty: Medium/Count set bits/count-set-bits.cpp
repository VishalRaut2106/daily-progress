class Solution {
  public:
    using ll=long long;
    int countSetBits(int n) {
        // code here
        int ans=0;
        for(int b=0;b<32;b++){
            ll group_size=1ll<<(b+1),cnt_1s=1ll<<b;
            ll num_groups=n/group_size;
            ans+=num_groups*cnt_1s;
            ll pos_n=n%group_size;
            // cout<<group_size<<" "<<cnt_1s<<" "<<num_groups<<" "<<pos_n<<endl;
            if(pos_n>=cnt_1s)
                ans+=(pos_n-cnt_1s+1);
        }
        return ans;
    }
};

// need to solve again