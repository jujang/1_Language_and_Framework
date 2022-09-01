package start.aop.order.aop;


import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;

@Slf4j
@Aspect
public class Aspect33 {

    @Pointcut("execution(* start.aop.order..*(..))")
    private void allOrder(){}

    @Pointcut("execution(* *..*Service.*(..))")
    private void allService(){}


//    @Around("allOrder() && allService()")
    @Around("allService()")
    public Object doTransaction(ProceedingJoinPoint joinPoint) throws Throwable {

        try{
            log.info("트랜잭션 시작 -> {}", joinPoint.getSignature());
            Object result = joinPoint.proceed();
//            log.info("트랜잭션 커밋 -> {}", joinPoint.getSignature());
//            return result;
            log.info("트랜잭션 커밋 -> {}", joinPoint.getSignature());
//            return joinPoint.proceed();
            return result;
        } catch (Exception e) {
            log.info("트랜잭션 롤백 -> {}", joinPoint.getSignature());
            throw e;
        } finally {
            log.info("리소스 릴리즈 -> {}", joinPoint.getSignature());
        }
    }

    @Around("allOrder()")
//    @Around("allService()")
    public Object logging(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("log ->{}", joinPoint.getSignature());
        return joinPoint.proceed();
    }

    @Around("allService()")
    public Object hihi(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("어쩔티비~");
        return joinPoint.proceed();

        //        try{
//            log.info("어쩔티비~");
//            joinPoint.proceed();
//            log.info("킁킁쓰");
//            return joinPoint.proceed();
//        } catch (Exception e) {
//            log.info("Error티비~");
//            throw e;
//        }
    }

}
