package org.training.malek.logger;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.util.StopWatch;


@Aspect
public class MyCustomLogger {

	private final Log log = LogFactory.getLog(this.getClass());

	@Around("execution(* org.training.malek.dao.*.*(..))")
	public Object logTimeMethod(ProceedingJoinPoint joinPoint) throws Throwable {

			StopWatch stopWatch = new StopWatch();
			stopWatch.start();
			
			Object retVal = joinPoint.proceed();

			stopWatch.stop();

			StringBuffer logMessage = new StringBuffer();
			logMessage.append(joinPoint.getTarget().getClass().getName());
			logMessage.append(".");
			logMessage.append(joinPoint.getSignature().getName());
			logMessage.append("(");
			// append args
			Object[] args = joinPoint.getArgs();
			for (int i = 0; i < args.length; i++) {
				logMessage.append(args[i]).append(",");
			}
			if (args.length > 0) {
				logMessage.deleteCharAt(logMessage.length() - 1);
			}

			logMessage.append(")");
			logMessage.append(" execution time: ");
			logMessage.append(stopWatch.getTotalTimeMillis());
			logMessage.append(" ms");
			log.info(logMessage.toString());
			return retVal;
	}

}
