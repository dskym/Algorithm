class Solution {
public:    
    int parent[1001];
    int rank[1001];

    void makeSet(int n) {
        for(int i=0;i<n;++i) {
            parent[i] = i;
            rank[i] = 0;
        }
    }
    
    int find(int x) {
        if(parent[x] == x)
            return x;
        else
            return parent[x] = find(parent[x]);
    }
    
    void uni(int x, int y) {
        x = find(x);
        y = find(y);
        
        if(x == y)
            return;
        
        if(rank[x] < rank[y])
            parent[x] = y;
        else {
            parent[y] = x;
        
            if(rank[x] == rank[y])
                rank[x]++;
        }
    }
    
    vector<int> findRedundantConnection(vector<vector<int>>& edges) {        
        makeSet(edges.size());
        
        for(vector<int> edge : edges) {
            int u = edge[0];
            int v = edge[1];
            
            int x = find(u);
            int y = find(v);
            
            if(x == y)
                return edge;
            else
                uni(u, v);
        }
        
        return {};
    }
};
