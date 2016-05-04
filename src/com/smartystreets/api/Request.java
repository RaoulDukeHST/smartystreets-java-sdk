package com.smartystreets.api;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

public class Request {

    private String urlString;
    private String method;
    private Map<String, String> headers;
    private String jsonPayload;
    private final String CHARSET = "UTF-8";

    public Request(){
        this.headers = new HashMap<>();
    }

    public Request(String urlString) {
        this.headers = new HashMap<>();
        this.urlString = urlString;
    }

    public void addHeader(String name, String value){
        this.headers.put(name, value);
    }

    /**** Getters ********************************************************************************/

    public void appendParameter(String name, String value) {
        if (name == null || value == null)
            return;

        if (name.length() == 0)
            return;

        if (!this.urlString.endsWith("?"))
            this.urlString += "&";

        String encodedName = this.encode(name);
        String encodedValue = this.encode(value);
        this.urlString += encodedName + "=" + encodedValue;
    }

    private String encode(String value) {
        try {
            return URLEncoder.encode(value, CHARSET);
        }
        catch (Exception ex){
            return "";
        }
    }

    public String getUrlString() {
        return urlString;
    }

    public String getMethod() {
        return method;
    }

    public Map<String, String> getHeaders() {
        return this.headers;
    }

    public String getJsonPayload() {
        return jsonPayload;
    }

    /**** Setters ********************************************************************************/

    public void setUrlString(String urlString) {
        this.urlString = urlString;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public void setHeaders(Map<String, String> headers) {
        this.headers = headers;
    }

    public void setJsonPayload(String jsonPayload) {
        this.jsonPayload = jsonPayload;
    }
}