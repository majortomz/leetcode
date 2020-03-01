package solution600_699;

/**
 * Created by zjw on 2017/6/7 15:23.
 */
public class P605_CanPlaceFlowers {

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 0, lastI = flowerbed.length - 1;
        for(int i = 0; i <= lastI; i++) {
            if(flowerbed[i] == 0) {
                if(i == 0) count += 1;
                if(i == lastI)  count += 1;
                count += 1;
            }

            if(flowerbed[i] == 1 || i == lastI)   {
                if(count > 2) {
                    count = count % 2 == 0?count - 2:count - 1;
                    n -= (count/ 2);
                }
                count = 0;
                if(n <= 0)  return true;
            }
        }
        return false;
    }

    public boolean canPlaceFlowers2(int[] flowerbed, int n) {
        int count = 0, lastI = flowerbed.length - 1;
        int pre = 0, next;
        for(int i = 0; i < flowerbed.length; i++) {
            next = (i == lastI? 0 : flowerbed[i+1]);
            if(flowerbed[i] == 0 && pre == 0 && next == 0) {
                flowerbed[i] = 1;
                n--;
            }
            pre = flowerbed[i];
            if(n <= 0)  return true;
        }
        return false;
    }
}
