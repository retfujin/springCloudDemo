package com.acec.apigateway;


import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;

@Component
public class ThrowExceptionFilter extends ZuulFilter {



    private static Logger log = LoggerFactory.getLogger(ThrowExceptionFilter.class);
    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        RequestContext requestContext = RequestContext.getCurrentContext();

       log.info("this is a pre filter ,it will throw a RuntimerException");
//       try{
           doSomething();
//       }catch (Exception ex){
//           requestContext.set("error.status_code", HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
//           requestContext.set("error.exception",ex);
//           requestContext.set("error.message","我不想加班");
//       }

       return null;
    }

    private void doSomething() {
        throw new RuntimeException("Exist some erros .this is my launch of active");
    }

}
