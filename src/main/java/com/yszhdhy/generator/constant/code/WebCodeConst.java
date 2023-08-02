package com.yszhdhy.generator.constant.code;


import com.yszhdhy.generator.utils.PomUtils;

/**
 * @author makeronbean
 * @createDate 2023-05-01  14:43
 * @description
 */
@SuppressWarnings("all")
public enum WebCodeConst implements CodeTemplate {

    CORS("config/web", "CORSConfig.java", "%s\n" +
            "import org.springframework.context.annotation.Configuration;\n" +
            "import org.springframework.core.Ordered;\n" +
            "import org.springframework.core.annotation.Order;\n" +
            "import org.springframework.web.servlet.config.annotation.CorsRegistry;\n" +
            "import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;\n" +
            "\n" +
            "@Configuration\n" +
            "@Order(Ordered.HIGHEST_PRECEDENCE)\n" +
            "public class CORSConfig implements WebMvcConfigurer {\n" +
            "    \n" +
            "    @Override\n" +
            "    public void addCorsMappings(CorsRegistry registry) {\n" +
            "        //允许所有的访问请求（访问路径）\n" +
            "        registry.addMapping(\"/**\")\n" +
            "                //允许所有的请求方法访问该跨域资源服务器\n" +
            "                .allowedMethods(\"*\")\n" +
            "                //允许所有的请求域名访问我们的跨域资源\n" +
            "                .allowedOrigins(\"*\")\n" +
            "                //允许所有的请求header访问\n" +
            "                .allowedHeaders(\"*\")\n" +
            "                .allowCredentials(true).maxAge(3600);\n" +
            "    }\n" +
            "}"),

    R("common/result", "R.java", "%s\n" +
            "import com.fasterxml.jackson.annotation.JsonInclude;\n" +
            "import lombok.Data;\n" +
            "\n" +
            "import java.io.Serializable;\n" +
            "\n" +
            "@Data\n" +
            "@JsonInclude(JsonInclude.Include.NON_NULL)\n" +
            "public class R<T> implements Serializable {\n" +
            "    private static final long serialVersionUID = 7735505903525411467L;\n" +
            "    \n" +
            "    /**\n" +
            "     * 状态码\n" +
            "     */\n" +
            "    private Integer code;\n" +
            "    \n" +
            "    /**\n" +
            "     * 消息\n" +
            "     */\n" +
            "    private String message;\n" +
            "    \n" +
            "    /**\n" +
            "     * 数据载体\n" +
            "     */\n" +
            "    private T data;\n" +
            "    \n" +
            "    private R() {\n" +
            "    }\n" +
            "    \n" +
            "    private R(ResultCode result) {\n" +
            "        this.code = result.getCode();\n" +
            "        this.message = result.getMessage();\n" +
            "    }\n" +
            "    \n" +
            "    public R<T> code(Integer code) {\n" +
            "        this.setCode(code);\n" +
            "        return this;\n" +
            "    }\n" +
            "    \n" +
            "    public R<T> message(String message) {\n" +
            "        this.setMessage(message);\n" +
            "        return this;\n" +
            "    }\n" +
            "    \n" +
            "    public R<T> data(T data) {\n" +
            "        this.setData(data);\n" +
            "        return this;\n" +
            "    }\n" +
            "    \n" +
            "    /**\n" +
            "     * 成功\n" +
            "     */\n" +
            "    public static <T> R<T> ok() {\n" +
            "        return new R<T>(ResultCode.SUCCESS);\n" +
            "    }\n" +
            "    \n" +
            "    /**\n" +
            "     * 成功\n" +
            "     */\n" +
            "    public static <T> R<T> ok(T data) {\n" +
            "        R<T> r = new R<>(ResultCode.SUCCESS);\n" +
            "        return r.data(data);\n" +
            "    }\n" +
            "    \n" +
            "    /**\n" +
            "     * 失败\n" +
            "     */\n" +
            "    public static <T> R<T> error() {\n" +
            "        return new R<>(ResultCode.FAILURE);\n" +
            "    }\n" +
            "    \n" +
            "    /**\n" +
            "     * 失败\n" +
            "     */\n" +
            "    public static <T> R<T> error(ResultCode code) {\n" +
            "        return new R<>(code);\n" +
            "    }\n" +
            "}"),

    RESULT_CODE("common/result", "ResultCode.java", "%s\n" +
            "import lombok.Getter;\n" +
            "\n" +
            "@Getter\n" +
            "public enum ResultCode {\n" +
            "    \n" +
            "    /**\n" +
            "     * 处理成功\n" +
            "     */\n" +
            "    SUCCESS(200, \"成功\"),\n" +
            "    \n" +
            "    /**\n" +
            "     * 处理失败\n" +
            "     */\n" +
            "    FAILURE(201, \"处理失败\"),\n" +
            "    \n" +
            "    /**\n" +
            "     * 系统异常\n" +
            "     */\n" +
            "    SYS_ERROR(300, \"服务端发生异常\"),\n" +
            "    \n" +
            "    /**\n" +
            "     * 参数缺失\n" +
            "     */\n" +
            "    MISSING_REQUEST_PARAM_ERROR(301, \"参数缺失\"),\n" +
            "    \n" +
            "    /**\n" +
            "     * 参数校验不通过\n" +
            "     */\n" +
            "    INVALID_REQUEST_PARAM_ERROR(302, \"请求参数不合法\"),\n" +
            "    \n" +
            "    ;\n" +
            "    \n" +
            "    \n" +
            "    private final Integer code;\n" +
            "    private final String message;\n" +
            "    \n" +
            "    ResultCode(Integer code, String message) {\n" +
            "        this.code = code;\n" +
            "        this.message = message;\n" +
            "    }\n" +
            "    \n" +
            "    \n" +
            "}"),

    GLOBAL_EXCEPTION_HANDLER("common/exception", "service-util/GlobalExceptionHandler.ftl", "%s\n\n" +
            "import " + PomUtils.getSingleValue("groupId") + ".common.result.R;\n" +
            "import " + PomUtils.getSingleValue("groupId") + ".common.result.ResultCode;\n" +
            "import org.slf4j.Logger;\n" +
            "import org.slf4j.LoggerFactory;\n" +
            "import org.springframework.validation.BindException;\n" +
            "import org.springframework.validation.ObjectError;\n" +
            "import org.springframework.web.bind.MethodArgumentNotValidException;\n" +
            "import org.springframework.web.bind.MissingServletRequestParameterException;\n" +
            "import org.springframework.web.bind.annotation.ControllerAdvice;\n" +
            "import org.springframework.web.bind.annotation.ExceptionHandler;\n" +
            "import org.springframework.web.bind.annotation.ResponseBody;\n" +
            "\n" +
            "import javax.servlet.http.HttpServletRequest;\n" +
            "import javax.validation.ConstraintViolation;\n" +
            "import javax.validation.ConstraintViolationException;\n" +
            "\n" +
            "@ControllerAdvice\n" +
            "public class GlobalExceptionHandler {\n" +
            "    \n" +
            "    private final Logger logger = LoggerFactory.getLogger(getClass());\n" +
            "    \n" +
            "    /**\n" +
            "     * 处理 MissingServletRequestParameterException 异常\n" +
            "     * <p>\n" +
            "     * SpringMVC 参数不正确\n" +
            "     * 没有携带需要的参数\n" +
            "     */\n" +
            "    @ResponseBody\n" +
            "    @ExceptionHandler(value = MissingServletRequestParameterException.class)\n" +
            "    public R missingServletRequestParameterExceptionHandler(HttpServletRequest req, MissingServletRequestParameterException ex) {\n" +
            "        logger.error(\"[missingServletRequestParameterExceptionHandler]\", ex);\n" +
            "        // 包装 R 结果\n" +
            "        return R.error(ResultCode.MISSING_REQUEST_PARAM_ERROR);\n" +
            "    }\n" +
            "    \n" +
            "    \n" +
            "    /**\n" +
            "     * get 携带query参数与路径参数\n" +
            "     */\n" +
            "    @ResponseBody\n" +
            "    @ExceptionHandler(value = ConstraintViolationException.class)\n" +
            "    public R constraintViolationExceptionHandler(HttpServletRequest req, ConstraintViolationException ex) {\n" +
            "        logger.error(\"[constraintViolationExceptionHandler]\", ex);\n" +
            "        // 拼接错误\n" +
            "        StringBuilder detailMessage = new StringBuilder();\n" +
            "        for (ConstraintViolation<?> constraintViolation : ex.getConstraintViolations()) {\n" +
            "            // 使用 ; 分隔多个错误\n" +
            "            if (detailMessage.length() > 0) {\n" +
            "                detailMessage.append(\";\");\n" +
            "            }\n" +
            "            // 拼接内容到其中\n" +
            "            detailMessage.append(constraintViolation.getMessage());\n" +
            "        }\n" +
            "        // 包装 R 结果\n" +
            "        return R.error(ResultCode.INVALID_REQUEST_PARAM_ERROR).message(ResultCode.INVALID_REQUEST_PARAM_ERROR.getMessage() + \":\" + detailMessage);\n" +
            "    }\n" +
            "    \n" +
            "    \n" +
            "    @ResponseBody\n" +
            "    @ExceptionHandler(value = BindException.class)\n" +
            "    public R bindExceptionHandler(HttpServletRequest req, BindException ex) {\n" +
            "        logger.error(\"[bindExceptionHandler]\", ex);\n" +
            "        // 拼接错误\n" +
            "        StringBuilder detailMessage = new StringBuilder();\n" +
            "        for (ObjectError objectError : ex.getAllErrors()) {\n" +
            "            // 使用 ; 分隔多个错误\n" +
            "            if (detailMessage.length() > 0) {\n" +
            "                detailMessage.append(\";\");\n" +
            "            }\n" +
            "            // 拼接内容到其中\n" +
            "            detailMessage.append(objectError.getDefaultMessage());\n" +
            "        }\n" +
            "        // 包装 R 结果\n" +
            "        return R.error(ResultCode.INVALID_REQUEST_PARAM_ERROR).message(ResultCode.INVALID_REQUEST_PARAM_ERROR.getMessage() + \":\" + detailMessage);\n" +
            "    }\n" +
            "    \n" +
            "    \n" +
            "    /**\n" +
            "     * post请求，json参数\n" +
            "     */\n" +
            "    @ResponseBody\n" +
            "    @ExceptionHandler(value = MethodArgumentNotValidException.class)\n" +
            "    public R methodArgumentNotValidExceptionHandler(HttpServletRequest req, MethodArgumentNotValidException ex) {\n" +
            "        logger.error(\"[MethodArgumentNotValidException]\", ex);\n" +
            "        // 拼接错误\n" +
            "        StringBuilder detailMessage = new StringBuilder();\n" +
            "        for (ObjectError objectError : ex.getBindingResult().getAllErrors()) {\n" +
            "            // 使用 ; 分隔多个错误\n" +
            "            if (detailMessage.length() > 0) {\n" +
            "                detailMessage.append(\";\");\n" +
            "            }\n" +
            "            // 拼接内容到其中\n" +
            "            detailMessage.append(objectError.getDefaultMessage());\n" +
            "        }\n" +
            "        // 包装 R 结果\n" +
            "        return R.error(ResultCode.INVALID_REQUEST_PARAM_ERROR).message(ResultCode.INVALID_REQUEST_PARAM_ERROR.getMessage() + \":\" + detailMessage);\n" +
            "    }\n" +
            "    \n" +
            "    \n" +
            "    /**\n" +
            "     * 处理断言异常\n" +
            "     */\n" +
            "    @ResponseBody\n" +
            "    @ExceptionHandler(AssertException.class)\n" +
            "    public R assertExceptionHandler(AssertException ex) {\n" +
            "        return R.error(ex.getCode());\n" +
            "    }\n" +
            "    \n" +
            "    \n" +
            "    /**\n" +
            "     * 处理其它 Exception 异常\n" +
            "     */\n" +
            "    @ResponseBody\n" +
            "    @ExceptionHandler(value = Exception.class)\n" +
            "    public R exceptionHandler(HttpServletRequest req, Exception e) {\n" +
            "        // 记录异常日志\n" +
            "        logger.error(\"[exceptionHandler]\", e);\n" +
            "        // 返回 ERROR R\n" +
            "        return R.error(ResultCode.SYS_ERROR);\n" +
            "    }\n" +
            "}"),

    ASSERT_EXCEPTION("common/exception", "AssertException.java", "%s\n" +
            "\n" +
            "import " + PomUtils.getSingleValue("groupId") + ".common.result.ResultCode;\n" +
            "public class AssertException extends RuntimeException{\n" +
            "    private final ResultCode code;\n" +
            "    \n" +
            "    public AssertException(ResultCode code) {\n" +
            "        this.code = code;\n" +
            "    }\n" +
            "    \n" +
            "    public ResultCode getCode() {\n" +
            "        return code;\n" +
            "    }\n" +
            "}"),

    ASSERT_UTILS("utils", "Assert.java", "%s\n\n" +
            "import " + PomUtils.getSingleValue("groupId") + ".common.exception.AssertException;\n" +
            "import " + PomUtils.getSingleValue("groupId") + ".common.result.ResultCode;\n" +
            "import org.springframework.util.ObjectUtils;\n" +
            "\n" +
            "public class Assert {\n" +
            "    \n" +
            "    /**\n" +
            "     * 对象必须为空\n" +
            "     * @param obj 被断言对象\n" +
            "     * @param resultCode 断言失败的异常结果枚举类\n" +
            "     */\n" +
            "    public static void isEmpty(Object obj, ResultCode resultCode) {\n" +
            "        if (!ObjectUtils.isEmpty(obj)) {\n" +
            "            throw new AssertException(resultCode);\n" +
            "        }\n" +
            "    }\n" +
            "    \n" +
            "    /**\n" +
            "     * 对象不能为空\n" +
            "     * @param obj 被断言对象\n" +
            "     * @param resultCode 断言失败的异常结果枚举类\n" +
            "     */\n" +
            "    public static void isNotEmpty(Object obj, ResultCode resultCode) {\n" +
            "        if (ObjectUtils.isEmpty(obj)) {\n" +
            "            throw new AssertException(resultCode);\n" +
            "        }\n" +
            "    }\n" +
            "    \n" +
            "    \n" +
            "    /**\n" +
            "     * 条件必须是true\n" +
            "     * @param flag 被断言条件\n" +
            "     * @param resultCode 断言失败的异常结果枚举类\n" +
            "     */\n" +
            "    public static void isTrue(boolean flag, ResultCode resultCode) {\n" +
            "        if (!flag) {\n" +
            "            throw new AssertException(resultCode);\n" +
            "        }\n" +
            "    }\n" +
            "    \n" +
            "    \n" +
            "    /**\n" +
            "     * 条件必须是false\n" +
            "     * @param flag 被断言条件\n" +
            "     * @param resultCode 断言失败的异常结果枚举类\n" +
            "     */\n" +
            "    public static void isFalse(boolean flag, ResultCode resultCode) {\n" +
            "        isTrue(!flag, resultCode);\n" +
            "    }\n" +
            "}"),
    ;
    private final String path;
    private final String fileName;
    private final String codeTemplate;

    WebCodeConst(String path, String fileName, String codeTemplate) {
        this.path = path;
        this.fileName = fileName;
        this.codeTemplate = codeTemplate;
    }

    @Override
    public String getPath() {
        return path;
    }

    @Override
    public String getFileName() {
        return fileName;
    }

    @Override
    public String getCodeTemplate() {
        return codeTemplate;
    }
}
