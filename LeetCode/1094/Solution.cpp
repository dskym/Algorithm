class Solution {
public:
    bool carPooling(vector<vector<int>>& trips, int capacity) {
        priority_queue<pair<int, int>> start;
        priority_queue<pair<int, int>> end;
        
        for(int i=0;i<trips.size();++i) {
            start.push({-trips[i][1], trips[i][0]});
            end.push({-trips[i][2], trips[i][0]});
        }
        
        int people = 0;
        
        while(!start.empty() && !end.empty()) {
            auto s = start.top();
            auto e = end.top();
            
            if(-s.first < -e.first) {
                people += s.second;
                
                start.pop();
            } else if(-s.first > -e.first) {
                people -= e.second;
                
                end.pop();
            } else {
                people += s.second;
                people -= e.second;                

                start.pop();
                end.pop();
            }
            
            if(people > capacity)
                return false;
        }
        
        return true;
    }
};
