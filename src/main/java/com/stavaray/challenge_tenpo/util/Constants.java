package com.stavaray.challenge_tenpo.util;

public final class Constants {
    private Constants() {}
    public static final String API_PREFIX = "/api/v1";

    public static final String PERCENTAGE_ROUTE = API_PREFIX + "/percentage";
    public static final String CALCULATE_ROUTE   = API_PREFIX + "/calculate";
    public static final String HISTORY_ROUTE     = API_PREFIX + "/history";

    public static final String KEY_ERROR   = "error";
    public static final String KEY_MESSAGE = "message";
    public static final String KEY_DETAILS = "details";
    public static final String KEY_STATUS  = "status";
}
