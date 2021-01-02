package yunyinyue;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;


// zjw 2018 problem3
public class Problem3 {

    private static class Data implements Comparable{
        int Di;
        int Pi;

        public int getDi() {
            return this.Di;
        }

        public int getPi() {
            return this.Pi;
        }

        public void setPi(int Pi) {
            this.Pi = Pi;
        }

        public Data(int Di, int Pi) {
            this.Di = Di;
            this.Pi = Pi;
        }


        public int compareTo(Object o) {

            if (Di > ((Data)o).Di) {
                return 1;
            }
            else {
                return -1;
            }
        }
    }

    public static int search(int Di, Data[] data, int n) {

        int top = n-1;
        int bot = 0;

        int res = 0;
        while(top >= bot) {
            int mid = (top + bot) / 2;
            if (data[mid].Di <= Di) {
                res = mid;
                bot = mid+1;
            }
            else {
                top = mid-1;
            }
        }
        return data[res].Pi;
    }

    public static void main(String arge[]) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();

        Data data[] = new Data[n];

        for (int i = 0; i < n; i++) {
            data[i] = new Data(scanner.nextInt(), scanner.nextInt());

        }

        Arrays.sort(data);

        for (int i = 1; i < n; i++) {
            if (data[i].getPi() < data[i-1].getPi()) {
                data[i].setPi(data[i-1].getPi());
            }

        }

        for (int i = 0; i < m; i++) {
            int Pi = scanner.nextInt();

            System.out.println(search(Pi, data, n));
        }

    }
}

