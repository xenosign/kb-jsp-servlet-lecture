package org.example.kbjspservletlecture;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

// 모든 주소 요청에 작동하기 위해서 /* 주소 패턴 적용
@WebFilter(urlPatterns = "/*")
public class CountFilter implements Filter {
    // 왜 static 이 붙었을까요?
    private static int count = 0;    

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        // ##### 해당 부분을 완성해 주세요
        
        // 다음 필터 or 서블릿으로 요청을 넘기기 위한 Chain 전달
        chain.doFilter(request, response);
    }
}
