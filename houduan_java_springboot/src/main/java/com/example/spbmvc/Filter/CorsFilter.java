package com.example.spbmvc.Filter;

        import org.springframework.stereotype.Component;
        import org.springframework.web.servlet.HandlerInterceptor;
        import org.springframework.web.servlet.ModelAndView;

        import javax.servlet.http.HttpServletRequest;
        import javax.servlet.http.HttpServletResponse;

@Component
public class CorsFilter implements HandlerInterceptor {
//    跨域的拦截添加请求头
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String origin = request.getHeader("Origin");
        //当成非跨域请求
        if(origin==null||origin.equals("")){
            return true;
        }
        //非简单请求需要预请求，有json有cookie都是非简单请求
        response.setHeader("Access-Control-Allow-Origin", origin);
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("Access-Control-Allow-Headers", "content-type,authorization");
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}