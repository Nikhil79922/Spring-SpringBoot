package com.example.CRUDops.Interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.jspecify.annotations.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class LoggingInterceptors implements HandlerInterceptor {
    @Override
   public boolean preHandle(HttpServletRequest request,
                            HttpServletResponse response,
                            Object handler)
            throws Exception {

//        HandlerMethod handlerMethod = (HandlerMethod) handler;
        if(handler instanceof HandlerMethod handlerMethod) {
            System.out.println("Handler Method Called....");
            System.out.println("request method:"+ request.getMethod());
            System.out.println("request URI:"+ request.getRequestURI());
            System.out.println("request URL:"+ request.getRequestURL());
            System.out.println("request IP" + request.getRemoteAddr());
            System.out.println("request IP" + request.getRemoteHost());
            System.out.println("request IP" + request.getLocalAddr());
            System.out.println("request IP" + request.getLocalName());
            System.out.println("request IP" + request.getLocalPort());
            System.out.println("request params" + request.getParameterMap().toString());


            String controllerName = handlerMethod.getBeanType().getSimpleName();
            String methodName = handlerMethod.getMethod().getName();
            System.out.println("LoggingInterceptors preHandle...");
            System.out.println("controllerName: " + controllerName);
            System.out.println("methodName: " + methodName);
            return true;
        }
        return false;
    }

@Override
    public void postHandle(HttpServletRequest request,
                           HttpServletResponse response,
                           Object handler,
                            @Nullable ModelAndView modelAndView)
        throws Exception {
        System.out.println("LoggingInterceptors postHandle...");
    }


    @Override
   public void afterCompletion(HttpServletRequest request,
                               HttpServletResponse response,
                               Object handler,
                         @Nullable Exception ex)
            throws Exception {
        System.out.println("LoggingInterceptors afterCompletion...");
    }

}
