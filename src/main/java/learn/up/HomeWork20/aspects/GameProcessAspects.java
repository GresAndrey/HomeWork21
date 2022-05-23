package learn.up.HomeWork20.aspects;

import learn.up.HomeWork20.HomeWork20Application;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.swing.*;

@Aspect
@Component
public class GameProcessAspects {

    private static final Logger log = LoggerFactory.getLogger(HomeWork20Application.class);

    @Pointcut("@annotation(learn.up.HomeWork20.WorkTime)")
    public void callInProcess() {}

    @Around("callInProcess()")
    public void methodWorkTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        Object output = joinPoint.proceed();
        long end = System.currentTimeMillis();
        long time = end - start;
        String name = joinPoint.getSignature().getName();

        log.info("Название метода: {} .Время работы метода(мс) : {}",name ,time);
    }

    @Before("@annotation(learn.up.HomeWork20.LogMethod)")
    public void beforeCall(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        log.info("Имя метода: {}", name);
        Object[] args = joinPoint.getArgs();
        for (Object arg: args) {
            log.info("Параметры метода: {}", arg);
        }
    }

    @After("@annotation(learn.up.HomeWork20.LogMethod)")
    public void afterCall(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        for (Object arg : args) {
            log.info("Возвращаемое значение: {}" ,arg);
        }
    }

}
