class Solution {
public:
    int furthestBuilding(vector<int>& heights, int bricks, int ladders) {
        priority_queue<int> s;
        for(int i=0;i<heights.size()-1;++i) {
            int diff = heights[i+1] - heights[i];

            if(diff <= 0)
                continue;
            
            s.push(-diff);
            
            if(s.size() <= ladders)
                continue;
            
            bricks -= -s.top();
            s.pop();
            
            if(bricks < 0)
                return i;
        }
        return heights.size()-1;
    }
};
