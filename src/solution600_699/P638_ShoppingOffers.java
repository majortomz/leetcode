package solution600_699;

import java.util.Comparator;
import java.util.List;

/**
 * Created by zjw on 2017/8/21.
 */
public class P638_ShoppingOffers {

    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
       int res = Integer.MAX_VALUE;
       for(List<Integer> arr: special) {
           boolean isValid = true;
           for(int i = 0; i < needs.size(); i++) {
               int remain = needs.get(i) - arr.get(i);
               needs.set(i, remain);
               if(remain < 0)   isValid = false;
           }
           if(isValid) {
               res = Math.min(res, arr.get(needs.size()) + shoppingOffers(price, special, needs));
           }
           for(int i = 0; i < needs.size(); i++) {
               needs.set(i, arr.get(i) + needs.get(i));
           }
       }
       int nonShopOffer = 0;
       for(int i = 0; i < needs.size(); i++) {
           nonShopOffer += price.get(i) * needs.get(i);
       }
       return Math.min(res, nonShopOffer);
    }
}
