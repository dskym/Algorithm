class Solution {
public:
    bool canReach(vector<int>& arr, int start) {
        queue<int> q;
        
        bool visited[50001];
        
        for(int i=0;i<arr.size();++i)
            visited[i] = false;
        
        visited[start] = true;
        q.push(start);
        
        while(!q.empty()) {
            int curr = q.front();
            q.pop();
                        
            int pos = arr[curr];
            
            if(pos == 0)
                return true;

            if(curr+pos < arr.size() && visited[curr+pos] == false) {
                q.push(curr+pos);
                visited[curr+pos] = true;
            }
            
            if(curr-pos >= 0 && visited[curr-pos] == false) {
                q.push(curr-pos);
                visited[curr-pos] = true;
            }
        }
        
        return false;
    }
};
