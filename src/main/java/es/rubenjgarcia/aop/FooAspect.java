package es.rubenjgarcia.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.util.StopWatch;

@Aspect
public class FooAspect {

	@Around("execution(* es.rubenjgarcia.aop.Foo.*(..))")
	public Object measureMethod(ProceedingJoinPoint pjp) throws Throwable
	{
		StopWatch sw = new StopWatch();
		Object retVal;
		try
		{
			sw.start(pjp.getTarget()+"."+pjp.getSignature());
			retVal = pjp.proceed();
		}
		catch (Throwable e)
		{
			throw e;
		}
		finally
		{
			sw.stop();
			System.out.println(sw.prettyPrint());
		}
		return retVal;
	}
}
