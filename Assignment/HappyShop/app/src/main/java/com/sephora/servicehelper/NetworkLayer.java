package com.sephora.servicehelper;

import android.content.Context;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.sephora.Utils.LogUtils;
import com.sephora.app.AppController;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by nivedhitha.a on 7/21/17.
 */

public class NetworkLayer {
    private static ResponseListeners responseListeners ;
    private Context context;


    public NetworkLayer(Context context){
        this.context = context;

    }


    /**
     *
     * @param url
     * @param tag
     * @param requestCode
     */
    public void get(String url, String tag, final int requestCode){
        LogUtils.i("URL ", url);
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(url, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                LogUtils.i("Response " , response.toString());
                responseListeners.onSuccessResponse(response.toString(), requestCode);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                if(error != null && error.networkResponse.data != null){
                    LogUtils.i("Error " , error.toString());
                    LogUtils.i("Status code " , error.networkResponse.statusCode +"");
                    String errorJson = new String(error.networkResponse.data);
                    LogUtils.i("Error Message  " , errorJson);
                    responseListeners.onFailureResponse(errorJson, requestCode);
                }
            }
        });

        jsonArrayRequest.setRetryPolicy(new DefaultRetryPolicy(DefaultRetryPolicy.DEFAULT_TIMEOUT_MS, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        AppController.getInstance().addToRequestQueue(jsonArrayRequest, tag);

    }


    /**
     *
     * @param url
     * @param tag
     * @param requestCode
     */
    public  void getJsonObject(String url, String tag, final int requestCode){

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                LogUtils.i("Response", response.toString());
                responseListeners.onSuccessResponse(response.toString(), requestCode);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                try {
                    if(error != null && error.networkResponse.data != null){

                        responseListeners.onFailureResponse(error.toString(), requestCode);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        jsonObjectRequest.setRetryPolicy(new DefaultRetryPolicy(20000000, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        AppController.getInstance().addToRequestQueue(jsonObjectRequest, tag);



    }







    /**
     *
     * @param url
     * @param tag
     * @param params
     * @param requestCode
     */
    public void post(String url, String tag, JSONObject params, final int requestCode){
        LogUtils.i("URL ", url);
        LogUtils.i("Params", params.toString());
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, url, params, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                LogUtils.i("Response " , response.toString());
                responseListeners.onSuccessResponse(response.toString(), requestCode);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                if(error != null && error.networkResponse.data != null){
                    LogUtils.i("Error " , error.toString());
                    LogUtils.i("Status code " , error.networkResponse.statusCode +"");
                    String errorJson = new String(error.networkResponse.data);
                    LogUtils.i("Error Message  " , errorJson);
                    responseListeners.onFailureResponse(errorJson, requestCode);
                }

            }
        });

        jsonObjectRequest.setRetryPolicy(new DefaultRetryPolicy(DefaultRetryPolicy.DEFAULT_TIMEOUT_MS, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        AppController.getInstance().addToRequestQueue(jsonObjectRequest, tag);

    }


    /**
     *
     * @param url
     * @param tag
     * @param params
     * @param requestCode
     */
    public void put(String url, String tag, JSONObject params, final int requestCode, final String token){
        LogUtils.i("URL ", url);
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.PUT, url, params, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                LogUtils.i("Response " , response.toString());
                responseListeners.onSuccessResponse(response.toString(), requestCode);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                if(error != null && error.networkResponse.data != null){
                    LogUtils.i("Error " , error.toString());
                    LogUtils.i("Status code " , error.networkResponse.statusCode +"");
                    String errorJson = new String(error.networkResponse.data);
                    LogUtils.i("Error Message  " , errorJson);
                    responseListeners.onFailureResponse(errorJson, requestCode);
                }
            }
        }) ;

        jsonObjectRequest.setRetryPolicy(new DefaultRetryPolicy(DefaultRetryPolicy.DEFAULT_TIMEOUT_MS, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        AppController.getInstance().addToRequestQueue(jsonObjectRequest, tag);

    }




    /**
     *
     * @param url
     * @param tag
     * @param params
     * @param requestCode
     */
    public void delete(String url, String tag, JSONObject params, final int requestCode, final String token){
        LogUtils.i("URL ", url);
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.DELETE, url, params, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                LogUtils.i("Response " , response.toString());
                responseListeners.onSuccessResponse(response.toString(), requestCode);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                if(error != null && error.networkResponse.data != null){
                    LogUtils.i("Error " , error.toString());
                    LogUtils.i("Status code " , error.networkResponse.statusCode +"");
                    String errorJson = new String(error.networkResponse.data);
                    LogUtils.i("Error Message  " , errorJson);
                    responseListeners.onFailureResponse(errorJson, requestCode);
                }
            }
        });

        jsonObjectRequest.setRetryPolicy(new DefaultRetryPolicy(DefaultRetryPolicy.DEFAULT_TIMEOUT_MS, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        AppController.getInstance().addToRequestQueue(jsonObjectRequest, tag);

    }




    public interface ResponseListeners{
        void onSuccessResponse(String response, int requestCode);
        void onFailureResponse(String error, int requestCode);
    }

    public void setResponseListeners(ResponseListeners responseListeners) {
        this.responseListeners = responseListeners;
    }



}
