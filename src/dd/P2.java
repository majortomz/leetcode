package dd;

import java.util.Scanner;

/**
 * Created by zjw on 2018/09/18 20:29
 * Description:
 */
public class P2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int np = sc.nextInt(), nq = sc.nextInt(), nr = sc.nextInt();

        if(np == 0 && nq == 0 && nr == 0) {
            System.out.println("0");
        } else {
            System.out.println(helper('0', np, nq, nr));
        }
    }

    public static int calc(char prev, char ca, char cb, int na, int nb) {
        if(na == 0 || nb == 0) {
            return 0;
        }

        if(Math.abs(na - nb) >= 2) {
            return 0;
        } else if (na - nb == 1) {
            return ca == prev ? 0 : 1;
        } else {
            return cb == prev ? 0 : 1;
        }
    }

    public static int helper(char prev, int np, int nq, int nr) {
        if(np == 0 && nq == 0 && nr == 0) {
            return 1;
        }

        int res = 0;

        if(np == 0) {
            calc(prev, 'q', 'r', nq, nr);
        } else if(nq == 0) {
            calc(prev, 'p', 'r', np, nr);
        } else if(nr == 0) {
            calc(prev, 'q', 'p', nq, np);

        } else {
            if(np > 0 && (prev != 'p')) {
                res += helper('p',np - 1, nq, nr);
            }
            if(nq > 0 && (prev != 'q')) {
                res += helper('q', np, nq - 1, nr);
            }
            if(nr > 0 && (prev != 'r')) {
                res += helper('r', np, nq, nr - 1);
            }
        }
        return res;
    }

}
