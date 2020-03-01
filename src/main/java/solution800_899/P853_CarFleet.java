package solution800_899;

import java.util.*;

/**
 * Created by zjw on 2018/06/19 13:57
 * Description:
 */
public class P853_CarFleet {

    class Car implements Comparable<Car>{
        double time;
        int index;

        public Car() {
        }

        public Car(double time, int index) {
            this.time = time;
            this.index = index;
        }

        @Override
        public int compareTo(Car b) {
            return index == b.index ? Double.compare(time, b.time) : index - b.index;
        }
    }

    class Counter implements Comparable<Counter> {
        double time;
        int count;

        public Counter(double time, int count) {
            this.time = time;
            this.count = count;
        }

        public Counter() {
        }

        @Override
        public int compareTo(Counter o) {
            return Double.compare(time, o.time);
        }
    }

    public int carFleet(int target, int[] position, int[] speed) {
        if(position == null || position.length == 0) {
            return 0;
        }
        int n = position.length;

        List<Car> cars = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            cars.add(new Car((target - position[i]) / (double)speed[i], position[i]));
        }

        Collections.sort(cars);

        Queue<Counter> queue = new PriorityQueue<>();
        for(Car car : cars) {
            int count = 1;
            while(!queue.isEmpty() && Double.compare(car.time, queue.peek().time) >= 0) {
                count += queue.poll().count;
            }
            queue.offer(new Counter(car.time, count));
        }
        return queue.size();
    }

    class Solution2 {
        class Car {
            int position;
            double time;

            public Car(int position, double time) {
                this.position = position;
                this.time = time;
            }
        }

        public int carFleet(int target, int[] position, int[] speed) {
            if(position == null || position.length == 0) {
                return 0;
            }

            int n = position.length;
            Car[] cars = new Car[n];
            for(int i = 0; i < n; i++) {
                cars[i] = new Car(position[i], (double)(target - position[i]) / speed[i]);
            }

            Arrays.sort(cars, (a, b) -> (a.position - b.position));

            int count = 0, i;
            for(i = n - 1; i >= 1; i--) {
                if(cars[i].time < cars[i - 1].time) {
                    count++;
                } else {
                    cars[i - 1] = cars[i];
                }
            }

//            return count + (i == 0 ? 1 : 0);
            return count + 1;
        }
    }

}
