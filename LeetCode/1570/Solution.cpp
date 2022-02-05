class SparseVector {
public:
    vector<int> temp;
    SparseVector(vector<int> &nums) {
        temp = nums;
    }
    
    // Return the dotProduct of two sparse vectors
    int dotProduct(SparseVector& vec) {
        int ret=0;
        for(int i=0;i<vec.temp.size();++i)
            ret += temp[i] * vec.temp[i];
        return ret;
    }
};
