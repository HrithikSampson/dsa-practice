class Solution {
public:
    int maxProduct(vector<int>& nums) {
        int maxm = INT_MIN;
        int prod = 1;
        int i,n = nums.size();
        int prev_prod = 1;
        for(i = 0; i <n ; i++){
            prod = prod * nums[i];
            
            // cout<<prev_prod<<" "<<prod<<endl;
            if(nums[i] == 0){
                prod = 1;
                prev_prod = 1;
                maxm = max(maxm,0);
            }
            else if(prod<0){
                maxm = max(maxm, prod/prev_prod);
                prev_prod = (prev_prod==1)?prod:max(prev_prod,prod);
            }
            else{
                maxm = max(maxm,prod);
            }
        }
        return maxm;
    }
};