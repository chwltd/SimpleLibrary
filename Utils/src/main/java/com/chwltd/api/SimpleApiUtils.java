package com.chwltd.api;

import com.chwltd.utils.OkHttpUtils;
import com.google.gson.JsonObject;

public class SimpleApiUtils {
    public static String getAppData(int page) {
        try {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("appid", ApiConfig.getAppid());
            jsonObject.addProperty("usertoken", ApiConfig.getUserToken());
            jsonObject.addProperty("limit", ApiConfig.getPostLimit());
            jsonObject.addProperty("page", page);
            jsonObject.addProperty("timestamp", System.currentTimeMillis());
            String result = OkHttpUtils.postJson(ApiConfig.getSimpleApi() + "getAppData", jsonObject.toString());
            return ApiUtils.backData(result);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static String getHomeFragmentData(int page) {
        try {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("appid", ApiConfig.getAppid());
            jsonObject.addProperty("usertoken", ApiConfig.getUserToken());
            jsonObject.addProperty("limit", ApiConfig.getPostLimit());
            jsonObject.addProperty("page", page);
            jsonObject.addProperty("timestamp", System.currentTimeMillis());
            String result = OkHttpUtils.postJson(ApiConfig.getSimpleApi() + "getHomeFragmentData", jsonObject.toString());
            return ApiUtils.backData(result);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static String getResFragmentData(int page) {
        try {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("appid", ApiConfig.getAppid());
            jsonObject.addProperty("usertoken", ApiConfig.getUserToken());
            jsonObject.addProperty("limit", ApiConfig.getPostLimit());
            jsonObject.addProperty("page", page);
            jsonObject.addProperty("timestamp", System.currentTimeMillis());
            String result = OkHttpUtils.postJson(ApiConfig.getSimpleApi() + "getResFragmentData", jsonObject.toString());
            return ApiUtils.backData(result);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static String getActivitiesPageData(int page) {
        try {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("appid", ApiConfig.getAppid());
            jsonObject.addProperty("usertoken", ApiConfig.getUserToken());
            jsonObject.addProperty("limit", ApiConfig.getPostLimit());
            jsonObject.addProperty("page", page);
            jsonObject.addProperty("timestamp", System.currentTimeMillis());
            String result = OkHttpUtils.postJson(ApiConfig.getSimpleApi() + "getActivitiesPageData", jsonObject.toString());
            return ApiUtils.backData(result);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static String getFineSelectionPageData(int page) {
        try {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("appid", ApiConfig.getAppid());
            jsonObject.addProperty("usertoken", ApiConfig.getUserToken());
            jsonObject.addProperty("limit", ApiConfig.getPostLimit());
            jsonObject.addProperty("page", page);
            jsonObject.addProperty("timestamp", System.currentTimeMillis());
            String result = OkHttpUtils.postJson(ApiConfig.getSimpleApi() + "getFineSelectionPageData", jsonObject.toString());
            return ApiUtils.backData(result);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static String getPlatePageData(int page) {
        try {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("appid", ApiConfig.getAppid());
            jsonObject.addProperty("usertoken", ApiConfig.getUserToken());
            jsonObject.addProperty("limit", ApiConfig.getPostLimit());
            jsonObject.addProperty("page", page);
            jsonObject.addProperty("timestamp", System.currentTimeMillis());
            String result = OkHttpUtils.postJson(ApiConfig.getSimpleApi() + "getPlatePageData", jsonObject.toString());
            return ApiUtils.backData(result);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static String getMsgData(int page) {
        try {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("appid", ApiConfig.getAppid());
            jsonObject.addProperty("usertoken", ApiConfig.getUserToken());
            jsonObject.addProperty("limit", ApiConfig.getMsgLimit());
            jsonObject.addProperty("page", page);
            jsonObject.addProperty("timestamp", System.currentTimeMillis());
            String result = OkHttpUtils.postJson(ApiConfig.getSimpleApi() + "getMsgData", jsonObject.toString());
            return ApiUtils.backData(result);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
