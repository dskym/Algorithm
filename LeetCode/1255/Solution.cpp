class Solution {
public:
    bool isValid(string word, vector<int>& letters_count) {
        for(char c : word)
            letters_count[c-'a']--;

        for(int i=0;i<26;++i)
            if(letters_count[i] < 0)
                return false;
        
        return true;
    }
    
    int solve(vector<string>& words, vector<int> letters_count, vector<int>& score, int index) {
        if(index >= words.size())
            return 0;
        
        int t1 = solve(words, letters_count, score, index+1);
        int t2 = 0;
        
        if(isValid(words[index], letters_count)) {
            int result = 0;
            
            for(char c : words[index])
                result+=score[c-'a'];
            
            t2 = solve(words, letters_count, score, index+1) + result;
        }
        
        return max(t1, t2);
    }
    
    int maxScoreWords(vector<string>& words, vector<char>& letters, vector<int>& score) {
        vector<int> letters_count(26, 0);
        
        for(char c : letters)
            letters_count[c-'a']++;

        int t1 = solve(words, letters_count, score, 1);
        int t2 = 0;
        
        if(isValid(words[0], letters_count)) {
            int result = 0;
            
            for(char c : words[0])
                result+=score[c-'a'];
            
            t2 = solve(words, letters_count, score, 1) + result;
        }
        
        return max(t1, t2);
    }
};
