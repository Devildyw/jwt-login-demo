package com.dyw.jwtlogin.handler;

import cn.hutool.json.JSON;
import cn.hutool.json.JSONUtil;
import com.dyw.jwtlogin.entity.User;
import com.dyw.jwtlogin.utils.JwtUtil;
import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.cuit.epoch.result.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.invoke.MethodHandle;
import java.util.concurrent.TimeUnit;
import java.util.logging.MemoryHandler;

/**
 * @author Devil
 * @create 2022-04-03 18:31
 */
@Slf4j
@Component
public class InterceptorHandler implements HandlerInterceptor {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    private final ThreadLocal<User> threadLocal = new ThreadLocal<>();
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        if (!(handler instanceof HandlerMethod)){
            return true;
        }
        String token = request.getHeader("token");
        //打印日志
        log.info("=================request start===========================");
        String requestURI = request.getRequestURI();
        log.info("request uri:{}",requestURI);
        log.info("request method:{}",request.getMethod());
        log.info("token:{}", token);
        log.info("=================request end===========================");

        if(StringUtils.isBlank(token)){
            response.setContentType("application/json;charset=utf-8");
            response.getWriter().print(JSONUtil.parse(R.fail("对不起你还没有登录")));
            return false;
        }
        Claims claims = JwtUtil.verifyJwt(token);
        if (claims.get("id")==null){
            response.setContentType("application/json;charset=utf-8");
            response.getWriter().print(JSONUtil.parse(R.fail("对不起你还没有登录")));
            return false;
        }
        String key = "token_"+token;
        String JSON = stringRedisTemplate.opsForValue().get(key);
        User user = JSONUtil.toBean(JSON, User.class);
        if (user==null){
            response.setContentType("application/json;charset=utf-8");
            response.getWriter().print(JSONUtil.parse(R.fail("对不起你还没有登录")));
            return false;
        }
        stringRedisTemplate.opsForValue().set(key,JSONUtil.toJsonStr(user),1,TimeUnit.HOURS);
        threadLocal.set(user);
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        threadLocal.remove();
    }
}
