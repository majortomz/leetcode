package solution200_299;

/**
 * Created by zjw on 2017/6/27 11:06.
 */
public class P299_BullsAndCows {

    public String getHint(String secret, String guess) {
        int bull = 0, cow = 0;
        int[] hashA = new int[10], hashB = new int[10];
        for(int i = 0; i < secret.length(); i++) {
            if(secret.charAt(i) == guess.charAt(i))
                bull++;
            else {
                hashA[secret.charAt(i) - '0']++;
                hashB[guess.charAt(i) - '0']++;
            }
        }

        for(int i = 0; i < hashA.length; i++)
            cow += Math.min(hashA[i], hashB[i]);
        return String.format("%dA%dB", bull, cow);
    }


    public String getHint2(String secret, String guess) {
        int bull = 0, cow = 0;
        int[] hash = new int[10];
        for(int i = 0; i < secret.length(); i++) {
            if(secret.charAt(i) == guess.charAt(i))
                bull++;
            else {
                if(hash[secret.charAt(i) - '0']++ < 0) {
                    cow++;
                }
                if(hash[guess.charAt(i) - '0']-- > 0) {
                    cow++;
                }
            }
        }
        return String.format("%dA%dB", bull, cow);
    }

}
