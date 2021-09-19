package com.microservice.user.Response;

import com.microservice.user.RelationModel.Department;
import com.microservice.user.model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserResponseWithDepartment {

    private long userId;
    private String firstName;
    private String lastName;
    private String email;
    private Department department;
}
