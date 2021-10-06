package com.dxc.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.dxc.models.EmployeePosition;
import com.dxc.services.EmployeePositionService;

@Component
public class EmployeePositionConverter implements Converter<Object, EmployeePosition> {

    @Autowired
    private EmployeePositionService employeePositionService;

    @Override
    public EmployeePosition convert(Object source) {
        int id = Integer.parseInt((String) source);
        EmployeePosition employeePosition = employeePositionService.getPositionById(id);
        return employeePosition;
    }

}
