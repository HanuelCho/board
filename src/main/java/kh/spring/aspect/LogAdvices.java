package kh.spring.aspect;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LogAdvices {
	private SimpleDateFormat simple = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
	
	@Before("execution(* kh.spring.practice.HomeController.*(..))")
	public void printLg(JoinPoint jp) {
		System.out.println(Arrays.toString(jp.getArgs()));
		
		Signature sign = jp.getSignature();
		
		StringBuilder sd = new StringBuilder();
		
		sd.append(simple.format(System.currentTimeMillis())+ " 에");
		sd.append(sign.getName()+" 메서드 실행됨.");
		System.out.println(jp.getTarget());
		System.out.println(sd.toString());
	}
}
