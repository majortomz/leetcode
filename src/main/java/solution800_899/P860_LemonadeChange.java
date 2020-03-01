package solution800_899;

/**
 * Created by zjw on 2018/07/01 9:31
 * Description:
 */
public class P860_LemonadeChange {

    public boolean lemonadeChange(int[] bills) {
        int[] money = new int[21];
        for(int bill: bills) {
            if(bill == 10) {
                if(money[5] > 0) {
                    money[5] -= 1;
                } else {
                    return false;
                }
            } else if(bill == 20){
                if(money[10] > 0 && money[5] > 0) {
                    money[10] -= 1;
                    money[5] -= 1;
                } else if(money[5] >= 3) {
                    money[5] -= 3;
                } else {
                    return false;
                }
            }
            money[bill] += 1;
        }
        return true;
    }

}
