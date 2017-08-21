package org.flylib.passport.intercepter;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.flylib.passport.annotation.Auth;
import org.flylib.passport.constant.MobResponseCode;
import org.flylib.passport.controller.Authed;
import org.flylib.passport.model.Passport;
import org.flylib.passport.service.LoginIntercepterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * 
 * @author Frank.Liu
 *
 */
@Component
public class LoginInterceptor extends HandlerInterceptorAdapter {
	private static final Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);
	@Autowired
	LoginIntercepterService loginIntercepterService;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String token = request.getParameter("token");
		String userId = request.getParameter("userId");
		//
		if(handler.getClass().isAssignableFrom(HandlerMethod.class)){
//            Auth auth = ((HandlerMethod) handler).getMethodAnnotation(Auth.class);
            HandlerMethod handlerMethod = (HandlerMethod) handler;
//            Auth auth = handlerMethod.getClass().getDeclaredAnnotation(Auth.class);
            // 被@Auth注解的
//            if (auth != null && auth.value()) {
           
        	logger.info("进入拦截器...........");
    		Object controller = handlerMethod.getBean();
    		printParameters(request, controller);
    		// 访问需要登录的接口	
        	if (controller instanceof Authed) {
        		logger.info("访问需要登录的接口(@Authed)...........");
    			if (StringUtils.isEmpty(token)) {
    				flushError(response, MobResponseCode.TOKEN_IS_NULL, MobResponseCode.TOKEN_IS_NULL_DESC);
    				return false;
    			}
    			Passport passport = loginIntercepterService.getPassport(userId);
    			if (StringUtils.isEmpty(passport.getUserId())) {
    				flushError(response, MobResponseCode.TOKEN_EXPIRED, MobResponseCode.TOKEN_EXPIRED_DESC);
    				return false;
    			}
    			if (!passport.getToken().equals(token)) {
    				flushError(response, MobResponseCode.TOKEN_INVALID, MobResponseCode.TOKEN_INVALID_DESC);
    				return false;
    			}
            } // 被@Auth注解的 结束
            
        }// 	 HandlerMethod 结束
		
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
		writer.append("{\"QuickBaseResponse\":{\"code\":" + code + ", \"desc\":\"" + desc + "\"}}");
		writer.flush();
		writer.close();
	}
}
