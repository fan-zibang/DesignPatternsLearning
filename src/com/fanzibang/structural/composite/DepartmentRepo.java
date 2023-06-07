package com.fanzibang.structural.composite;

import java.util.List;

public interface DepartmentRepo {

    List<Long> getSubDepartmentIds(long id);
}
