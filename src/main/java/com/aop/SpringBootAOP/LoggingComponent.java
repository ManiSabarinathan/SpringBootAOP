package com.aop.SpringBootAOP;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Aspect
@Component
public class LoggingComponent {

	Logger LOGGER = org.slf4j.LoggerFactory.getLogger(LoggingComponent.class);
	
	@Pointcut(value="execution(* com.aop.SpringBootAOP.StudentService.*(..) )")
	public void mypointcut() {
		
	}
	
	//ProceddingJointPoint
	@Around(value = "mypointcut()")
	public Object logger(ProceedingJoinPoint jointpoint) {
		Object object=null;
		try {
			String methodname = jointpoint.getSignature().getName();
			String classname = jointpoint.getTarget().getClass().toString();
			
			final StopWatch stopwatch = new StopWatch();
			stopwatch.start();
			object = jointpoint.proceed();
			stopwatch.stop();
			
			LOGGER.info("  Class :: " + classname + "  Method :: " + methodname + "  Execution time::" + stopwatch.getTotalTimeMillis());
			
		} catch (Throwable e) {
			e.printStackTrace();
		}
			
		return object;
	}
	
}
