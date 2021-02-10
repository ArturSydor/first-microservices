package com.microservice.user.dto;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentDto {

    @NotNull
    private Long id;

    @NotNull
    private String departmentName;

    @NotNull
    private String departmentAddress;

    @NotNull
    private String departmentCode;

}
