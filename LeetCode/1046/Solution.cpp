class Solution {
public:
    int lastStoneWeight(vector<int>& stones) {
        priority_queue<int> pq;
        
        for(int stone : stones)
            pq.push(stone);
        
        while(pq.size() > 1) {
            int x = pq.top();
            pq.pop();
            
            int y = pq.top();
            pq.pop();
            
            if(x == y)
                continue;
            else if(x > y)
                pq.push(x - y);
            else if(x < y)
                pq.push(y - x);
        }
        
        if(pq.size() == 0)
            return 0;
        else
            return pq.top();
    }
};
