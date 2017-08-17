package com.dbbyte.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.dbbyte.model.Employee;

@Aspect
@Component
public class EmployeeServiceAspect {


    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeServiceAspect.class);

    @Before("execution(* com.dbbyte.service.EmployeeService.createEmployee (java.lang.String)) && args(employeeName)")
    public void beforeEmployeeCreation(String employeeName) {

        LOGGER.info("A request was issued for the employee name: "+employeeName);
    }

    @Around("execution(* com.dbbyte.service.EmployeeService.createEmployee (java.lang.String)) && args(employeeName)")
    public Object aroundSampleCreation(ProceedingJoinPoint proceedingJoinPoint,String employeeName) throws Throwable {

        LOGGER.info("A request was issued for the employee name: "+employeeName);

        employeeName = employeeName+" ma are sclav pe mine!";

        Employee employee = (Employee) proceedingJoinPoint.proceed(new Object[] {employeeName});
        employee.setName(employee.getName().toUpperCase());

        return employee;
}	
	
}
