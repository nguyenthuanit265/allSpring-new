package com.learn.model.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@SuppressWarnings("rawtypes")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AllSpringResponse<T>{
    private int statusCode;
    private String message;
    private T data;
    private int total;
    private int totalSelf;

    public AllSpringResponse(int statusCode, String message, T data) {
        this.statusCode = statusCode;
        this.message = message;
        this.data = data;
    }

    @SuppressWarnings("unchecked")
    public static AllSpringResponse buildResponse(Object data) {
        AllSpringResponse res = new AllSpringResponse();
        res.data = data;
        res.statusCode = 200;
        return res;
    }

    @SuppressWarnings("rawtypes")
    public static AllSpringResponse buildResponse(Object data, Integer total) {
        AllSpringResponse res = buildResponse(data);
        res.total = total;
        return res;
    }

    public static AllSpringResponse buildResponse(Object data, Integer total, Integer totalSelf) {
        AllSpringResponse response = buildResponse(data);
        response.total = total;
        response.totalSelf = totalSelf;
        return response;
    }

    public static AllSpringResponse buildResponse(Object data, Integer total, String message, Integer errCode) {
        AllSpringResponse res = buildResponse(data, total);
        res.statusCode = errCode;
        res.setMessage(message);
        return res;
    }

    public static AllSpringResponse buildApplicationException(String tmsEx, int code) {
        AllSpringResponse res = new AllSpringResponse();
        res.statusCode = code;
        res.message = tmsEx;
        return res;
    }
}
