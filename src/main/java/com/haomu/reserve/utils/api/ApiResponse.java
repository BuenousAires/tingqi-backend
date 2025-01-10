package com.haomu.reserve.utils.api;

import com.alibaba.fastjson.JSONObject;

public class ApiResponse {

    /*---------------------------- default method ---------------------------------*/
    /**
     *
     * <p>Discription:[获取标准格式返回结果]</p>
     * @param status required APIStatus
     * @param data 结果集
     * @return {"status":{"code":xxx,"message":"xxx"},"data":{xxx}}
     */
    public static String data(APIStatus status, Object data) {
        JSONObject result = new JSONObject();
        JSONObject statusJson = new JSONObject();
        statusJson.put("code", status.getCode());
        statusJson.put("message", status.getMessage());
        result.put("status", statusJson);
        result.put("data", data);
        return result.toJSONString();
    }

    /**
     *
     * <p>Discription:[获取标准格式返回结果]</p>
     * @param status required APIStatus
     * @return {"status":{"code":xxx,"message":"xxx"}}
     */
    public static JSONObject jsonData(APIStatus status) {
        JSONObject result = new JSONObject();
        JSONObject statusJson = new JSONObject();
        statusJson.put("code", status.getCode());
        statusJson.put("message", status.getMessage());
        result.put("status", statusJson);
        return result;
    }

    /**
     *
     * <p>Discription:[获取标准格式返回结果]</p>
     * @param status required APIStatus
     * @param data 结果集
     * @return {"status":{"code":xxx,"message":"xxx"},"data":{xxx}}
     */
    public static JSONObject jsonData(APIStatus status, Object data) {
        JSONObject result = new JSONObject();
        JSONObject statusJson = new JSONObject();
        statusJson.put("code", status.getCode());
        statusJson.put("message", status.getMessage());
        result.put("status", statusJson);
        result.put("data", data);
        return result;
    }

    /*---------------------------- static method ----------------------------------*/
    /**
     *
     * <p>Discription:[获取请求处理成功返回结果]</p>
     * @return {"status":{"code":200,"message":"ok"}}
     */
    public static JSONObject success() {
        return jsonData(APIStatus.OK_200);
    }

    /**
     *
     * <p>Discription:[获取请求处理成功返回结果]</p>
     * @param data 返回数据
     * @return {"status":{"code":200,"message":"ok"},"data":xxx}
     */
    public static JSONObject success(Object data) {
        return jsonData(APIStatus.OK_200, data);
    }

    /**
     *
     * <p>Discription:[获取请求参数错误返回结果]</p>
     * @param data 返回数据
     * @return {"status":{"code":400,"message":"Bad Request."},"data":xxx}
     */
    public static JSONObject errorPara(Object data) {
        return jsonData(APIStatus.ERROR_400, data);
    }
}
