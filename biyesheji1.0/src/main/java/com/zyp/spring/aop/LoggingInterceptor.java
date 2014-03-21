package com.zyp.spring.aop;




import org.apache.log4j.Logger;
import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.ThrowsAdvice;




import java.lang.reflect.Method;


//,ThrowsAdvice
public class LoggingInterceptor implements MethodBeforeAdvice ,AfterReturningAdvice,ThrowsAdvice {

	
	  private static final Logger logger = Logger  
	            .getLogger(LoggingInterceptor.class);  
	
	  
	





	public void before(Method method, Object[] args, Object target)
			throws Throwable {
//		WebApplicationContext webApplicationContext= ContextLoader.getCurrentWebApplicationContext();  
//	    LoggerService loggerService = (LoggerService) webApplicationContext.getBean("loggerServiceImpl");  
		
		String methodName = "";  
        for (Object obj : args) {  
            if (null == obj) {  
                continue;  
            }  
           
                    methodName = method.getName();  
               
                    
                    
             
        }  
      
           
        
        logger.info("logging before advice. class:"  
                + target.getClass().getSimpleName() + " method:" + methodName);  
        
      //  loggerService.addRecord(new LoggerRecord(target.getClass().getSimpleName()+"."+method.getName(),new Date()));
  
    }  
		
		
		
	

	@Override
	public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable
	{
//		WebApplicationContext webApplicationContext= ContextLoader.getCurrentWebApplicationContext();  
//	    LoggerService loggerService = (LoggerService) webApplicationContext.getBean("loggerServiceImpl"); 
		
		        String methodName = "";  
		        for (Object obj : args) {  
		            if (null == obj) {  
		                continue;  
		            }  
		           
		            methodName = method.getName(); 
		        }  
		       
		        logger.info("logging after advice. return obj:" + returnValue);  
		        logger.info("logging after advice. class:"  
		                + target.getClass().getSimpleName() + " method:" + methodName);  
		      
		       // loggerService.addRecord(new LoggerRecord(target.getClass().getSimpleName()+"."+method.getName(),new Date()));
		        
	}
	
	public void afterThrowing(Method method, Object[] args, Object target, Exception ex){
		
		logger.info("logging doing"+method.getName()+"have"+ex.getMessage());
		
		
		
		
		
	}
	
	
	
}
