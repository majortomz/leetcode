package solution600_699;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zjw on 2017/12/5.
 */
public class P690_EmployeeImportance {

    class Employee {
        // It's the unique id of each node;
        // unique id of this employee
        public int id;
        // the importance value of this employee
        public int importance;
        // the id of direct subordinates
        public List<Integer> subordinates;
    };

    public int getImportance(List<Employee> employees, int id) {
        if(employees == null) return 0;

        Map<Integer, Employee> map = new HashMap<>();

        for(Employee employee : employees) {
            map.put(employee.id, employee);
        }

        return helper(map, id);
    }

    public int helper(Map<Integer, Employee> map, int id) {
        Employee emp = map.getOrDefault(id, null);
        if(emp == null) return 0;
        int total = emp.importance;
        for(Integer sub : emp.subordinates) {
            total += helper(map, sub);
        }
        return total;
    }

}
