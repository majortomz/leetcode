package solution300_399;

/**
 * Created by zjw on 2017/12/5.
 */
public class P331_VerifyPreorderSBT {

    // "#,#,3,5,#"
    // "#,7,6,9,#,#,#"
    public boolean isValidSerialization(String preorder) {
        if(preorder == null || preorder.length() == 0)  return false;
        int node = 1;
        for(String c : preorder.split(",")) {
            if(node <= 0)   return false;
            node = c.equals("#") ? node - 1 : node + 1;
        }
        return node == 0;
    }

}
