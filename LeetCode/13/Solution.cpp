class Solution {
public:
    int romanToInt(string s) {
        int result = 0;
        
        for(int i=0;i<s.size();++i) {
            if(s[i] == 'I') {
                if(i<s.size()-1 && (s[i+1] == 'V' || s[i+1] == 'X')) {
                    continue;
                } else {
                    result += 1;
                }
            } else if(s[i] == 'V') {
                if(i>0 && s[i-1] == 'I') {
                    result += 4;
                } else {
                    result += 5;
                }
            } else if(s[i] == 'X') {
                if(i<s.size()-1 && (s[i+1] == 'L' || s[i+1] == 'C')) {
                    continue;
                } else if(i>0 && s[i-1] == 'I') {
                    result += 9;
                } else {
                    result += 10;
                }
            } else if(s[i] == 'L') {
                if(i>0 && s[i-1] == 'X') {
                    result += 40;
                } else {
                    result += 50;
                }
            } else if(s[i] == 'C') {
                if(i<s.size()-1 && (s[i+1] == 'D' || s[i+1] == 'M')) {
                    continue;
                } else if(i>0 && s[i-1] == 'X') {
                    result += 90;
                } else {
                    result += 100;
                }
            } else if(s[i] == 'D') {
                if(i>0 && s[i-1] == 'C') {
                    result += 400;
                } else {
                    result += 500;
                }
            } else if(s[i] == 'M') {
                if(i>0 && s[i-1] == 'C') {
                    result += 900;
                } else {
                    result += 1000;
                }
            }
        }
        
        return result;
    }
};
