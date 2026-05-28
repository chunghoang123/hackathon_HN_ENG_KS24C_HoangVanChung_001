package re.edu.hackathon.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class LoggingAspect {

    @Pointcut("""
        execution(* re.edu.hackathon.service.BookService.create(..))
        execution(* re.edu.hackathon.service.BookService.update(..))
        execution(* re.edu.hackathon.service.BookService.patch(..))
            

    """)
    public void bookMethods() {
    }

    @Before("bookMethods()")
    public void logMethod(
            JoinPoint joinPoint
    ) {

        log.info(
                "Method called: {}",
                joinPoint.getSignature().getName()
        );
    }
}