class MyCalendar {
public:
    vector<pair<int,int>> list;
    MyCalendar() {
        list.push_back({0, 1000000000});
    }
    
    bool book(int start, int end) {
        for(int i=0;i<list.size();++i) {
            pair<int,int> temp = list[i];
            if(temp.first <= start && temp.second >= end) {
                list.insert(list.begin()+i, {end, temp.second});
                list.insert(list.begin()+i, {temp.first, start});
                list.erase(list.begin()+i+2);
                return true;
            }
        }
        return false;
    }
};
