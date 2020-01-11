package com.bandarproperti.config;

/**
 * Created by arief on 02-May-17.
 */

public class Constants {

    private static final String HOST_URL = "http://admin.bandar-properti.com/";
    public static final String BASE_URL = HOST_URL + "api/";
    public static final String SLIDER_URL = "http://admin.bandar-properti.com/";
    public static final String IMAGE_URL = HOST_URL + "uploads/";
    public static final String USER_URL = "customer/";

    //Shared Preference
    public class PrefManager {
        public static final String SHARED_PREFRENCE_NAME = "bandar_shared_preference";
        public static final String IS_LOGGED_IN = "isLoggedIn";
        public static final String USER_ID = "user_id";
        public static final String USER_NAME = "user_name";
        public static final String USER_EMAIL = "user_email";
        public static final String USER_PASSWORD = "user_password";
        public static final String USER_PHONE = "user_phone";
        public static final String USER_GENDER = "user_gender";
        public static final String USER_PICTURE = "user_picture";
        public static final String USER_ADDRESS = "user_address";
        public static final String USER_CREATED_AT = "user_created_at";

        public static final String TRANS_TYPE = "trans_type";

        public static final String BOOKING_DATE = "booking_date";
        public static final String BOOKING_TIME = "booking_time";

    }

    public class PermissionCode{
        public static final String PERMISSION_STATUS = "permission_status";
        public static final int PERMISSION_SETTING_CODE = 100;
        public static final int PERMISSION_REQUEST_CODE = 101;
    }

    public class OperationString {
        //Owner
        public static final String REGISTER_OPERATION = "register";
        public static final String LOGIN_OPERATION = "login";

        public static final String STATUS_OPERATION = "statuses";
        public static final String PROPERTY_OPERATION = "properties";
        public static final String PROPERTY_DETAIL_OPERATION = "property/details";
        public static final String PROPERTY_SEARCH_OPERATION = "property/search";

        public static final String ADD_PROPERTY_FAVORITE_OPERATION = "property/add-to-favorite";
        public static final String PROPERTY_FAVORITES_OPERATION = "property/favorites";
        public static final String PROPERTY_FAVORITE_OPERATION = "property/favorite";
    }

    public class TAG{
        public static final String APP_TAG = "Bandar Property";

        public static final String RegisterTag = "Register";
        public static final String LoginTag = "Login";
    }
}
