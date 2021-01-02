package qq;

import java.util.*;

/**
 * Created by zjw on 2018/08/21 19:49
 * Description:
 */
public class CheckInHelper {

    private class Employee {
        int id;
        String time;

        public Employee(int id, String time) {
            this.id = id;
            this.time = time;
        }
    }

    List<Employee> employeeList;
    List<Employee> managerList;
    Set<Integer> managerSet;

    public CheckInHelper(List<Integer> managerIds) {
        employeeList = new ArrayList<>();
        managerList = new ArrayList<>();
        managerSet = new HashSet<>();
        managerSet.addAll(managerIds);
    }

    public void checkIn(int id, String time) {
        if(managerSet.contains(id)) {
            managerList.add(new Employee(id, time));
        } else {
            employeeList.add(new Employee(id, time));
        }
    }


    public List<Integer> printById() {
        PriorityQueue<Employee> queue = new PriorityQueue<>((a, b) -> (a.id - b.id));
        queue.addAll(employeeList);

        List<Integer> res = new ArrayList<>();
        while(!queue.isEmpty()) {
            res.add(queue.poll().id);
        }
        return res;
    }

    public List<Integer> printByTime() {
        PriorityQueue<Employee> queue = new PriorityQueue<>((a, b) -> a.time.compareTo(b.time));
        queue.addAll(employeeList);

        List<Integer> res = new ArrayList<>();
        while(!queue.isEmpty()) {
            res.add(queue.poll().id);
        }
        return res;
    }

    public List<Integer> lookUpTopK(int k) {
        PriorityQueue<Employee> queue = new PriorityQueue<>((a, b) -> a.time.compareTo(b.time));
        queue.addAll(employeeList);

        int i = 0;
        List<Integer> res = new ArrayList<>();
        while(!queue.isEmpty()) {
            i++;
            res.add(queue.poll().id);
            if(i >= k) {
                break;
            }
        }
        return res;
    }

    public List<Integer> lookUpLastK(int k) {
        PriorityQueue<Employee> queue = new PriorityQueue<>((a, b) -> b.time.compareTo(a.time));
        queue.addAll(employeeList);

        int i = 0;
        List<Integer> res = new ArrayList<>();
        while(!queue.isEmpty()) {
            i++;
            res.add(queue.poll().id);
            if(i >= k) {
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        CheckInHelper checkInHelper = new CheckInHelper(Arrays.asList(3));
        checkInHelper.checkIn(2, "07:00:01");
        checkInHelper.checkIn(1, "08:04:01");
        checkInHelper.checkIn(3, "07:06:01");
        checkInHelper.checkIn(4, "07:10:01");

        System.out.println(checkInHelper.printById());
        System.out.println(checkInHelper.printByTime());
        System.out.println(checkInHelper.lookUpTopK(5));
        System.out.println(checkInHelper.lookUpLastK(5));
    }

}
