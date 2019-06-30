class Solution {
public:
    vector<int> distributeCandies(int candies, int num_people) {
        vector<int> result(num_people, 0);
        
        int count = 1;
        
        while(candies > 0) {
            for(int i=0;i<num_people;++i) {
                if(candies < count) {
                    result[i] += candies;
                    candies = 0;
                    
                    break;
                }
                
                result[i] += count;
                candies -= count;
                count++;
            }
        }
        
        return result;
    }
};
