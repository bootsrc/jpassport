package com.appjishu.passport.intercepter;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.appjishu.passport.annotation.AuthController;
import com.appjishu.passport.constant.AuthResponseCode;
import com.appjishu.passport.model.AuthResult;
import com.appjishu.passport.model.Passport;
import com.appjishu.passport.service.LoginIntercepterService;
import com.appjishu.passport.service.TokenService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * @author liushaoming
 */
@Component
public class LoginInterceptor extends HandlerInterceptorAdapter {
    private static final Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);
    @Autowired
    LoginIntercepterService loginIntercepterService;

    @Autowired
    private TokenService tokenService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {

        if (handler.getClass().isAssignableFrom(HandlerMethod.class)) {
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            Object controller = handlerMethod.getBean();
            printParameters(request, controller);
            // 访问需要登录的接口那些
            // 被@AuthController注解的Controller
            boolean present = controller.getClass().isAnnotationPresent(AuthController.class);
            if (!present) {
                return true;
            }

            String userIdStr = request.getHeader("userId");
            String token = request.getHeader("token");

            if (!StringUtils.isEmpty(userIdStr)) {
                logger.info("访问需要登录的接口(Authed)...........");
                if (StringUtils.isEmpty(token)) {
                    flushError(response, AuthResponseCode.TOKEN_IS_NULL, AuthResponseCode.TOKEN_IS_NULL_DESC);
                    return false;
                }
                Passport passport = loginIntercepterService.getPassport(Long.valueOf(userIdStr));
                String storedToken = passport.getToken();
                if (StringUtils.isEmpty(storedToken)) {
                    flushError(response, AuthResponseCode.TOKEN_EXPIRED, AuthResponseCode.TOKEN_EXPIRED_DESC);
                    return false;
                } else if (!storedToken.equals(token)) {
                    flushError(response, AuthResponseCode.TOKEN_INVALID, AuthResponseCode.TOKEN_INVALID_DESC);
                    return false;
                }

            } else {
                flushError(response, AuthResponseCode.USER_ID_IS_NULL, AuthResponseCode.USER_ID_IS_NULL_DESC);
                return false;
            }
            // 被@AuthController注解的 结束

        }

        boolean flag = isPermission(request, response);
        logger.info("isPermission:" + flag);
        return flag;
    }

    // private boolean isPermission(HttpServletRequest request,
    // HttpServletResponse response) throws IOException {
    // }
    private boolean isPermission(HttpServletRequest request, HttpServletResponse response) {
        return true;
        /*
         * String path=request.getServletPath();
         * System.out.println("request.getServletPath()"+request.getServletPath(
         * )); if(path.contains("public/wxpay/notify")){ return true; } //访问次数限制
         * if(accessUtil.isPermission(request)){ return true; }else{
         * flushError(response,MobResponseCode.REQUEST_TOO_FREQUENT,
         * MobResponseCode.REQUEST_TOO_FREQUENT_DESC); return false; }
         */
    }

    /**
     * 输出请求参数
     *
     * @param request
     * @param controller
     */
    private void printParameters(HttpServletRequest request, Object controller) {
        StringBuilder paramsResponse = new StringBuilder();

        String controllerName = controller.getClass().getSimpleName();
        if (controllerName.contains("WebCache")) {
            return;
        }
        Map<String, String[]> paramsMap = request.getParameterMap();

        paramsResponse.append("request params :\n");

        for (Map.Entry<String, String[]> entry : paramsMap.entrySet()) {
            paramsResponse.append(entry.getKey() + ":" + entry.getValue()[0] + "\n");
        }
        // logger.info(paramsResponse.toString());
        System.out.println(paramsResponse.toString());
        System.out.println(controllerName);
    }

    private void flushError(HttpServletResponse res, String code, String desc) throws IOException {
        res.setCharacterEncoding("utf-8");
        res.setContentType("application/json;charset=UTF-8");
        PrintWriter writer = res.getWriter();

        AuthResult authResult = new AuthResult();
        authResult.setCode(code);
        authResult.setCodeDesc(desc);
        String jsonStr = JSON.toJSONString(authResult);
        writer.append(jsonStr);
        writer.flush();
        writer.close();
    }
}
