class Solution {
public:
    bool isLongPressedName(string name, string typed) {
        int left = 0, right = 0;
        
        int n = name.size();
        int m = typed.size();
        
        while(left < n && right < m) {            
            if(name[left] == typed[right]) {
                left++;
                right++;
            } else {
                while(right < m && name[left] != typed[right])
                    right++;
            }
        }
        
        return (left == n);
    }
};

