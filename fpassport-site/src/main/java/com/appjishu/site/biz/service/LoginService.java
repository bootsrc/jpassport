package com.appjishu.site.biz.service;

import com.appjishu.passport.constant.AuthResponseCode;
import com.appjishu.passport.service.TokenDBService;
import com.appjishu.passport.service.TokenService;
import com.appjishu.site.model.LoginResult;
import com.appjishu.site.model.User;
import com.appjishu.site.util.DateTool;
import com.appjishu.site.util.MD5Util;
import com.appjishu.site.biz.dao.UserDAO;
import com.appjishu.site.constant.AccountType;
import com.appjishu.site.constant.UserStatus;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author liushaoming(liushaomingdev@163.com)
 * @version 创建时间：2017年8月26日 下午11:35:32
 * 类说明
 */
@Service
public class LoginService {
    private static final Logger logger = LoggerFactory.getLogger(LoginService.class);
    public static final Long tokenExpire = 1000000000L;

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private TokenDBService tokenDBService;

    public LoginResult register(String username, String password, Integer accountType) {
        User user = new User();
        LoginResult loginResult = new LoginResult();
        boolean exist = existUsername(username, accountType);
        boolean registerSuccess = false;
        if (exist) {
            System.out.println("This user exists! " + username);
            logger.info("This user exists! username={}", username);
            loginResult.setUserId(0L);
            loginResult.setToken("");
            loginResult.setUsername(username);
            loginResult.setCode(AuthResponseCode.USER_REPEAT);
            loginResult.setCodeDesc(AuthResponseCode.USER_REPEAT_DESC);
        } else {
            String encodedPassword = MD5Util.md5(password).toLowerCase();
            user.setPassword(encodedPassword);
            boolean setSuccess = setUsername(username, accountType, user);
            int insertedCount = 0;
            if (setSuccess) {
                user.setStatus(UserStatus.active);
                insertedCount = userDAO.insert(user);
                Long userId = user.getId();

                if (insertedCount == 1) {
                    // 产生token并存入数据库
                    String token = MD5Util.md5(DateTool.getTime() + password).toLowerCase();
                    Integer count = tokenService.insert(userId, token, tokenExpire);
                    if (count > 0) {
                        loginResult.setUserId(userId);
                        loginResult.setToken(token);
                        loginResult.setUsername(username);
                        loginResult.setCode(AuthResponseCode.SUCCESS);
                        loginResult.setCodeDesc(AuthResponseCode.SUCCESS_DESC);
                        registerSuccess = true;
                    }

                }
            }
            if (!registerSuccess) {
                loginResult.setUserId(0L);
                loginResult.setToken("");
                loginResult.setUsername(username);
                loginResult.setCode(AuthResponseCode.USER_REGISTER_FAILED);
                loginResult.setCodeDesc(AuthResponseCode.USER_REGISTER_FAILED_DESC);
            }
        }

        return loginResult;
    }

    public LoginResult login(String username, String password, Integer accountType) {
        String encodedPassword = MD5Util.md5(password).toLowerCase();
        String passwordInDB = "";
        User user = new User();
        switch (accountType) {
            case AccountType.MOBILE:
                if (username.length() == 11 && username.charAt(0) == '1') {
                    user = userDAO.getUserByMobile(username);
                }
                break;
            case AccountType.EMAIL:
                if (username.contains("@")) {
                    user = userDAO.getUserByEmail(username);
                }
                break;
        }
        passwordInDB = user.getPassword();
        Long userId = user.getId();
        String code = AuthResponseCode.USERCENTER_ERROR;
        String desc = AuthResponseCode.USERCENTER_ERROR_DESC;
        String token = "";
        if (encodedPassword.equals(passwordInDB)) {
            token = tokenService.copyTokenToCache(userId);
            code = AuthResponseCode.SUCCESS;
            desc = AuthResponseCode.SUCCESS_DESC;
        }
        LoginResult loginResult = new LoginResult();
        loginResult.setUserId(userId);
        loginResult.setToken(token);
        loginResult.setUsername(username);
        loginResult.setCode(code);
        loginResult.setCodeDesc(desc);
        return loginResult;
    }

    private boolean existUsername(String username, Integer accountType) {
        Integer count = 0;
        switch (accountType) {
            case AccountType.MOBILE:
                if (username.length() == 11 && username.charAt(0) == '1') {
                    count = userDAO.exist("mobile", username);
                }
                break;
            case AccountType.EMAIL:
                if (username.contains("@")) {
                    count = userDAO.exist("email", username);
                }
                break;
        }
        System.out.println("existUsername count1=" + count);
        logger.info("existUsername count={}", count);
        boolean exist = count > 0;
        return exist;
    }

    private boolean setUsername(String username, Integer accountType, User user) {
        boolean success = false;
        switch (accountType) {
            case AccountType.MOBILE:
                if (username.length() == 11 && username.charAt(0) == '1') {
                    user.setMobile(username);
                    success = true;
                } else {
                    logger.info("手机号不合法,mobile number is invalid,value={}", username);
                }
                break;
            case AccountType.EMAIL:
                if (username.contains("@")) {
                    user.setEmail(username);
                    success = true;
                }
                break;
            case AccountType.WECHAT:
                user.setOpenid(username);
                success = true;
                break;
        }
        return success;
    }
}
