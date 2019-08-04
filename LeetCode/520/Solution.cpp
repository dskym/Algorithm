class Solution {
public:
    bool detectCapitalUse(string word) {
        bool case1 = true;
        bool case2 = true;
        bool case3 = true;
        
        if(word[0] >= 'A' && word[0] <= 'Z') {
            for(int i=0;i<word.size();++i)
                if(word[i] < 'A' || word[i] > 'Z')
                    case1 = false;
        } else
            case1 = false;
        
        if(word[0] >= 'a' && word[0] <= 'z') {
            for(int i=0;i<word.size();++i)
                if(word[i] < 'a' || word[i] > 'z')
                    case2 = false;
        } else
            case2 = false;

        if(word[0] < 'A' && word[0] > 'Z')
            case3 = false;
        
        for(int i=1;i<word.size();++i)
            if(word[i] < 'a' || word[i] > 'z')
                case3 = false;        
        
        return case1 || case2 || case3;
    }
};
