package com.fanzibang.structural.composite;

import java.util.List;

public interface EmployeeRepo {
    List<Long> getDepartmentEmployeeIds(long id);

    double getEmployeeSalary(Long employeeId);
}
