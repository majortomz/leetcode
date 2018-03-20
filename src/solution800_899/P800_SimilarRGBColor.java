package solution800_899;

/**
 * Created by zjw on 2018/03/18 10:01
 * Description:
 */
public class P800_SimilarRGBColor {

    public String similarRGB(String color) {
        StringBuilder sb = new StringBuilder();
        char[] words = color.toCharArray();
        sb.append("#");
        for(int i = 1; i < words.length; i += 2) {
            int a = cToI(words[i]), b = cToI(words[i + 1]), c = a, d = a;
            int k = a * 16 + b;
            int p = (a - 1) * 16 + (a - 1), q = a * 16 + a, r = (a + 1) * 16 + a + 1;
            int sim = (q - k) * (q - k);
            if(a >= 1 && (p - k) * (p - k) < sim) {
                c = a - 1;
                d = a - 1;
            }
            if(a < 15 && (r - k) * (r - k) < sim) {
                c = a + 1;
                d = a + 1;
            }
            sb.append(iToC(c));
            sb.append(iToC(d));
        }
        return sb.toString();
    }

    private char iToC(int a) {
        if(a >= 0 && a <= 9)    return (char)(a + '0');
        else return (char)('a' + a - 10);
    }

    private int cToI(char c) {
        if(c >= '0' && c <= '9')
            return c - '0';
        else
            return c - 'a' + 10;
    }
}
