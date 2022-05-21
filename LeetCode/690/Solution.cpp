class Solution {
public:
    map<int, Employee*> m;
    int solve(Employee* employee) {
        int result = employee->importance;
        for(int i=0;i<(employee->subordinates).size();++i) {
            result += solve(m[(employee->subordinates)[i]]);
        }
        return result;
    }
    int getImportance(vector<Employee*> employees, int id) {        
        for(int i=0;i<employees.size();++i) {
            m[employees[i]->id] = employees[i];
        }
        return solve(m[id]);
    }
};
