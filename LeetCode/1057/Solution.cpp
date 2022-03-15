class Node
{
    public:
        int dist;
        int worker;
        int bike;
};

struct cmp {
    bool operator()(Node a, Node b)
    {
        if(a.dist > b.dist) {
            return true;
        } else if(a.dist == b.dist) {
            if(a.worker > b.worker) {
                return true;
            } else if(a.worker == b.worker) {
                if(a.bike > b.bike) {
                    return true;
                }
            }
        }
        return false;
    }
};

class Solution {
public:
    vector<int> assignBikes(vector<vector<int>>& workers, vector<vector<int>>& bikes) {
        int n = workers.size();
        int m = bikes.size();
        
        vector<int> ret(n);
        vector<int> use_worker(n, false);
        vector<int> use_bike(m, false);
        
        priority_queue<Node, vector<Node>, cmp> pq;
        
        for(int i=0;i<n;++i) {
            for(int j=0;j<m;++j) {
                int dist = abs(workers[i][0] - bikes[j][0]) + abs(workers[i][1] - bikes[j][1]);
                Node node;
                node.dist = dist;
                node.worker = i;
                node.bike = j;
                pq.push(node);
            }
        }
        
        while(!pq.empty()) {
            auto t = pq.top();
            pq.pop();
            
            if(use_worker[t.worker] || use_bike[t.bike]) {
                continue;
            }
            
            use_worker[t.worker] = true;
            use_bike[t.bike] = true;
            ret[t.worker] = t.bike;
        }
        
        return ret;
    }
};
