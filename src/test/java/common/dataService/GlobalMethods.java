package common.dataService;

import java.util.Random;
import org.apache.commons.codec.binary.Base64;

/**
 *
 * @author Michal.Hryniewiecki
 */
public class GlobalMethods {
    private static final String RANGE = "0123456789abcdefghijklmnopqrstwxyz";
    private static final String PHONE_PREFIX = "+78";
    private static final Random RND = new Random();
    
    public static String getRandomString(int len){
        StringBuilder sb = new StringBuilder(len);
        for(int i=0;i<len;i++){
            sb.append(RANGE.charAt(RND.nextInt(RANGE.length())));     
        }
        return sb.toString();
    }

   
    public static String getRandomPhone() {
        int a;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 9; i++) {
            a = RND.nextInt(9);
            sb.append(a);
        }
        return PHONE_PREFIX + sb.toString();
    }
    
    public static String encodeData(String data){
        byte[] encode = Base64.encodeBase64(data.getBytes());
        return new String(encode);
    }
    
    public static String decodeData(String data){
        byte[] pass= Base64.decodeBase64(data);
        return new String(pass);
    }
}
