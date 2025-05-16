package biz.baijing.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(urlPatterns = "/*")
public class FirFilter implements Filter {
    @Override // 执行一次
    public void init(FilterConfig filterConfig) {
        System.out.println("FirFilter init , Done .");
    }

    @Override    // 多次执行
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("已经拦截了 , Done .");
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override // 执行一次
    public void destroy() {
        System.out.println("FirFilter destroy, Done .");
    }
}
