class CustomStack {
public:
    int size = 0;
    stack<pair<int, int>> s;
    CustomStack(int maxSize) {
        size = maxSize;
    }
    
    void push(int x) {
        if(s.size() >= size) {
            return;
        }
        if(s.empty()) {
           s.push({x, 1});
        } else {
            s.push({x, s.top().second+1});
        }
    }
    
    int pop() {
        if(s.empty()) {
            return -1;
        }
        auto ret = s.top();
        s.pop();
        return ret.first;
    }
    
    void increment(int k, int val) {
        stack<pair<int, int>> temp;

        while(!s.empty()) {
            auto v = s.top();
            s.pop();
            if(v.second <= k) {
                temp.push({v.first+val, v.second});
            } else {
                temp.push({v.first, v.second});
            }
        }

        while(!temp.empty()) {
            auto v = temp.top();
            temp.pop();
            s.push({v.first, v.second});
        }
    }
};

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack* obj = new CustomStack(maxSize);
 * obj->push(x);
 * int param_2 = obj->pop();
 * obj->increment(k,val);
 */
