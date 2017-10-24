package solution300_399;

/**
 * Created by zjw on 2017/10/23.
 */
public class P393_UTF8Validation {

    public boolean validUtf8(int[] data) {
        int[] heads = {0xdf, 0xef, 0xf7}, forms = {0x1f, 0xf, 0x7};

        for(int i = 0; i < data.length; i++) {
            // handle 1 byte
            if( (data[i] | 0x7f) == 0x7f) {
                continue;
            }
            int j;
            for(j = 0; j < forms.length; j++) {
                // System.out.println("j: " + j);
                if((data[i] | forms[j]) == heads[j]) {
                    for(int k = 0; k <= j; k++) {
                        i++;
                        // can not match predefined format
                        if(i >= data.length || (data[i] | 0x3f) != 0xbf)    return false;
                    }
                    break;
                }
            }
            // can not find predefined format
            if(j >= forms.length)   return false;
        }
        return true;

    }

}
