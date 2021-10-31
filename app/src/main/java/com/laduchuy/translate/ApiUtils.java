package com.laduchuy.translate;

public class ApiUtils {

    public static final String BASE_URL = "https://demo7866763.mockable.io";

    public static SOService getSOService() {
        return RetrofitClient.getClient(BASE_URL).create(SOService.class);
    }
}