package com.haomu.reserve.utils.api;

public enum APIStatus {
    /**
     * 404 Not Found. 访问的API不存在.
     */
    NOT_FOUND_404(404, "访问的API不存在.", "Not Found."),
    /**
     * 403 Not Found. 禁止访问,没有权限.
     */
    FORBIDDEN_403(403, "禁止访问,没有权限.", "No permission to access."),
    /**
     * 401 Unauthorized. 未登录或登录状态已失效.
     */
    UNAUTHORIZED_401(401, "未登录或登录状态已失效.", "No login or login status has expired."),
    /**
     * 200 Ok. 请求处理成功.
     */
    OK_200(200, "0k", "Successful request processing"),
    /**
     * 500 Internal Server Error. 服务器内部错误,请求处理失败.
     */
    ERROR_500(500, "服务器内部错误,请求处理失败.", "Internal Server Error."),
    /**
     * 501 Unknown Cause Delete Failed. 未知原因,删除失败.
     */
    ERROR_501(501, "未知原因,删除失败.", "Unknown Cause Delete Failed."),
    /**
     * 400 Bad Request. 请求参数有问题.
     */
    ERROR_400(400, "请求参数有问题.", "Bad Request."),
    /**
     * 410 Up Fail. 上移失败.
     */
    ERROR_410(410, "上移失败.", "Up Fail."),
    /**
     * 411 Down Fail. 下移失败.
     */
    ERROR_411(411, "下移失败.", "Down Fail."),
    /**
     * 400 File Upload Failed. 文件上传失败.
     */
    ERROR_405(405, "文件上传失败.", "File Upload Failed."),
    /**
     * 301 Incorrect Account Or Password. 账号或密码输入有误,请重新输入.
     */
    ERROR_301(301, "账号或密码输入有误,请重新输入.", "Wrong Account Or Password."),
    /**
     * 302 The Account Has Been Frozen. 该账号已被冻结.
     */
    ERROR_302(302, "该账号已被冻结.", "The Account Has Been Frozen."),
    /**
     * 303 Continuous Login Failure. 连续登陆错误.
     */
    ERROR_303(303, "连续登陆错误.", "Continuous Login Failure."),
    /**
     * 304 Username Not Unique. 用户名不唯一.
     */
    ERROR_304(304, "用户名不唯一.", "Account already exists."),
    /**
     * 305 Incorrect Code. 图片验证码错误.
     */
    ERROR_305(305, "图片验证码错误", "wrong image verification code."),
    /**
     * 306 Code Expired. 图片验证码已过期.
     */
    ERROR_306(306, "图片验证码已过期", "Image verification code Expired."),
    /**
     * 305 Incorrect Code. 短信验证码错误.
     */
    ERROR_307(307, "短信验证码错误", "Image verification code."),
    /**
     * 306 Code Expired. 短信验证码已过期.
     */
    ERROR_308(308, "短信验证码已过期", "Code Expired."),
    /**
     * 306 Code Expired. 短信验证码已过期.
     */
    ERROR_309(309, "手机号已存在", "Mobile exits"),
    /**
     * 310 Code Expired. 用户不存在.
     */
    ERROR_310(310, "Account not exits", "Account not exits"),
    /**
     * 314 	邮箱用户已存在
     */
    ERROR_314(314, "邮箱用户已存在", "The user has already existed"),
    /**
     * 315 Incorrect Code. 英文版图片验证码错误.
     */
    ERROR_315(315, "图片验证码错误.", "Image validation code error"),

    ERROR_316(316, "查询失败.", "Query failed."),

    /**
     * 不支持的附件格式
     */
    ERROR_312(312, "不支持的附件格式", "Unsupported attachment format"),

    ERROR_502(502, "图片尺寸不符.", "Image size discrepancy"),

    ERROR_503(503, "上传文件类型不符.", "Uploading file type is incompatible"),

    OPERATION_FAIL(523, "操作失败", "operate fail."),

    ERROR_504(504, "请求次数过于频繁，请稍后再试.", "The number of requests is too frequent. Please try again later."),

    ERROR_505(505, "不能上传空文件", "Cannot upload empty files"),
	
    ERROR_507(507, "存在子节点，无法删除", "英文：存在子节点，无法删除"),

    ERROR_508(508, "该节点是顶层节点，无法上移", "英文：该节点是顶层节点，无法上移"),

    ERROR_509(509, "该节点是底层节点，无法下移", "英文：该节点是底层节点，无法下移");


    private int code;
    private String message;
    private String englishMessage;

    APIStatus(int code, String message, String englishMessage) {
        this.code = code;
        this.message = message;
        this.englishMessage = englishMessage;
    }

    public String getEnglishMessage() {
        return englishMessage;
    }

    public void setEnglishMessage(String englishMessage) {
        this.englishMessage = englishMessage;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
