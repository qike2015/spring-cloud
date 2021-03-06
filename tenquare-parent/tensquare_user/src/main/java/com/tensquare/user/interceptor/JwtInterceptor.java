package com.tensquare.user.interceptor;

import io.jsonwebtoken.Claims;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import util.JwtUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class JwtInterceptor implements HandlerInterceptor
{

    @Autowired
    JwtUtil jwtUtil;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
    {
        System.out.println("经过了拦截器");

        String header = request.getHeader("Authorization");

        if (StringUtils.isEmpty(header)) return true;

        if (!header.startsWith("Bearer ")) return true;

        String token = header.substring(7);

        try {
            Claims claims = jwtUtil.parseJWT(token);
            String roles = (String) claims.get("roles");
            if(roles!=null && roles.equals("admin")){
                request.setAttribute("claims_admin", token);
            }
            if(roles!=null && roles.equals("user")){
                request.setAttribute("claims_user", token);
            }
        }catch (Exception e){
            throw new RuntimeException("令牌不正确！");
        }

        return true;
    }
}
