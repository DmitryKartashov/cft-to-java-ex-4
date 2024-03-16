package com.example.ex4.aspects;

import com.example.ex4.annotations.LogTransformation;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.io.FileWriter;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.stream.Collectors;

@Slf4j
@Aspect
@Component
public class LogTransformationAspect {

    public static final String defaultLogFileName = "C:\\Users\\" + System.getProperty("user.name") + "\\Desktop\\LogTransformationAspect_logs.log";

    @Around(value = "@within(com.example.ex4.annotations.LogTransformation)")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        String args = Arrays.stream(joinPoint.getArgs())
                .map(Object::toString)
                .collect(Collectors.joining(","));

        var methodsClass = joinPoint.getSignature().getDeclaringType();
        var logFileName = ((LogTransformation) methodsClass.getAnnotation(LogTransformation.class)).fileName();

        logFileName = (logFileName == null || logFileName.isEmpty()) ? defaultLogFileName : logFileName;
        log.info("logFileName = " + logFileName);

        try(FileWriter writer = new FileWriter(logFileName, true))
        {
            // запись всей строки
            String text = "LOG [" + new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime())
                    + "] class: " + methodsClass
                    + "; method: " + joinPoint.getSignature().getName()
                    + "; args: " + args
                    + "; return value: " + joinPoint.proceed().toString();
            writer.write(text);
            // запись по символам
            writer.append('\n');
        }
        catch(IOException ex){
            log.error(ex.getMessage());
        }

        return joinPoint.proceed();
    }
}
