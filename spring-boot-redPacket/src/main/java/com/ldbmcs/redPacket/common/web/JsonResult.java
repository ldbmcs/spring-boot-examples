package com.ldbmcs.redPacket.common.web;

import java.util.HashMap;

/**
 * 接口返回结果对象
 *
 * @author ldbmcs
 * @date 2020/8/13
 */
public class JsonResult extends HashMap<String, Object> {
    private static final long serialVersionUID = 1L;
    private static final String CODE_NAME = "code";  // 状态码字段名称
    private static final String MSG_NAME = "msg";  // 状态信息字段名称
    private static final String DATA_NAME = "data";  // 数据字段名称
    private static final String DEFAULT_OK_MSG = "操作成功";  // 默认成功msg
    private static final String DEFAULT_ERROR_MSG = "操作失败";  // 默认失败msg

    private JsonResult() {
    }

    /**
     * 返回成功
     */
    public static JsonResult ok() {
        return ok(null);
    }

    /**
     * 返回成功
     */
    public static JsonResult ok(Object data) {
        return ok(200, null, data);
    }

    /**
     * 返回成功
     */
    public static JsonResult ok(int code, String message, Object data) {
        if (message == null) message = DEFAULT_OK_MSG;
        JsonResult jsonResult = new JsonResult();
        jsonResult.put(CODE_NAME, code);
        jsonResult.put(MSG_NAME, message);
        jsonResult.put(DATA_NAME, data);
        return jsonResult;
    }

    /**
     * 返回失败
     */
    public static JsonResult error() {
        return error(null);
    }

    /**
     * 返回失败
     */
    public static JsonResult error(String message) {
        return error(500, message);
    }

    /**
     * 返回失败
     */
    public static JsonResult error(int code, String message) {
        if (message == null) message = DEFAULT_ERROR_MSG;
        return ok(code, message, null);
    }

    public JsonResult setCode(Integer code) {
        return put(CODE_NAME, code);
    }

    public JsonResult setMsg(String message) {
        return put(MSG_NAME, message);
    }

    public JsonResult setData(Object object) {
        return put(DATA_NAME, object);
    }

    public Integer getCode(int code) {
        Object o = get(CODE_NAME);
        return o == null ? null : Integer.parseInt(o.toString());
    }

    public String getMsg() {
        Object o = get(MSG_NAME);
        return o == null ? null : o.toString();
    }

    public Object getData() {
        return get(DATA_NAME);
    }

    @Override
    public JsonResult put(String key, Object object) {
        if (key != null && object != null) super.put(key, object);
        return this;
    }

}