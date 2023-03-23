package com.vntechies.k8sspringbootseries.courses.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BaseResponse<T> {
    private boolean success;
    private String msg;
    private T data;

    public static BaseResponse buildSuccessResp(Object o) {
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setSuccess(true);
        baseResponse.setMsg("Success");
        baseResponse.setData(o);
        return baseResponse;
    }
}
