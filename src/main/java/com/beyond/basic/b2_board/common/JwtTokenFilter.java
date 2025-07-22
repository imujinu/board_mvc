package com.beyond.basic.b2_board.common;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class JwtTokenFilter extends GenericFilter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        String token = req.getHeader("Authorization");
        if(token==null){
            //token 없는 경우 다시 filterchain 되돌아가는 로직
            chain.doFilter(request,response);
            return;
        }

        // token 이 있는 경우 토컨 검증 후 Authentication 객체 생성
    }
}
