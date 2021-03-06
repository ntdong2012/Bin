package shop.bin.util;

import java.io.File;

import shop.bin.app.BinApps;


/**
 * Created by nguyenthanhdong0109@gmail.com on 5/12/2017.
 */

public class Common {

    public static final int REQUEST_CODE_ASK_PERMISSIONS = 100;

    public static final String PATH_DATA = BinApps.getInstance().getCacheDir().getAbsolutePath() + File.separator + "data";
    public static final String PATH_CACHE = PATH_DATA + "/NetCache";

    public static interface CONTROL_ICON_POSITION {
        public static int ADDRESS = 0;
        public static int NOTIFICATION = 1;
        public static int EXCHANGE = 2;
        public static int PERSONAL = 3;
    }

    public interface SPF {
        public static final String USER_NAME = "user_name";
        public static final String PASS_WORD = "password";
        public static final String TOKEN = "token";
        public static final String SERVER_IP = "server_ip";
        public static final String BACK_PRESS = "back_press";
        public static final String LANGUAGE = "current_language";
        public static final String LANGUAGE_VI = "lang_vi";
        public static final String LANGUAGE_EN = "lang_en";

    }

    public interface HTTP_CODE {
        public static final int CODE_OK = 200;
    }
}
