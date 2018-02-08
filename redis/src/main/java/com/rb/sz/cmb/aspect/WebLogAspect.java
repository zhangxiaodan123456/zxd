package com.rb.sz.cmb.aspect;

import java.util.Arrays;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.apache.bcel.generic.RET;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.google.common.collect.Maps;

@Aspect
@Component
public class WebLogAspect {
  @Pointcut("execution(public * com.rb.sz.cmb.service..*.*(..))")
  public void webLog() {}
  
  @Before("webLog()")
  public void doBefore(JoinPoint joinPoint) throws Throwable {
	  //获取目标方法的参数信息  
	  Object[] obj = joinPoint.getArgs();  
	    //AOP代理类的信息  
	    System.out.println("getthis="+joinPoint.getThis());
	    //代理的目标对象  
	    joinPoint.getTarget(); 
	    System.out.println("target="+joinPoint.getTarget());
	    //用的最多 通知的签名  
	    Signature signature = joinPoint.getSignature();  
	    //代理的是哪一个方法  
	    System.out.println(signature.getName());  
	    //AOP代理类的名字  
	    System.out.println(signature.getDeclaringTypeName());  
	    //AOP代理类的类（class）信息  
	    signature.getDeclaringType();  
	    //获取RequestAttributes  
	    RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();  
	    //从获取RequestAttributes中获取HttpServletRequest的信息  
	    HttpServletRequest request = (HttpServletRequest) requestAttributes.resolveReference(RequestAttributes.REFERENCE_REQUEST);  
	    //如果要获取Session信息的话，可以这样写：  
	    //HttpSession session = (HttpSession) requestAttributes.resolveReference(RequestAttributes.REFERENCE_SESSION);  
	    Enumeration<String> enumeration = request.getParameterNames();  
	    Map<String,String> parameterMap = Maps.newHashMap();  
	    while (enumeration.hasMoreElements()){  
	        String parameter = enumeration.nextElement();  
	        parameterMap.put(parameter,request.getParameter(parameter));  
	    }  
	    System.out.println(parameterMap.toString()); 
	}
  
    @AfterReturning(returning = "ret", pointcut = "webLog()")
	public void doAfterReturning(JoinPoint joinPoint,Object keys) throws Throwable {
	// 处理完请求，返回内容
    	ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = attributes.getRequest();
		// 记录下请求内容
		System.out.println("11URL11 : " + request.getRequestURL().toString());
		System.out.println("11HTTP_METHOD : " + request.getMethod());
		System.out.println("11IP : " + request.getRemoteAddr());
		System.out.println("11CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
		System.out.println("11ARGS : " + Arrays.toString(joinPoint.getArgs()));
		System.out.println("11keys="+keys.toString());
	}
}
