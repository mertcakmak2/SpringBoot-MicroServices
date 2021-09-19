package com.microservice.user.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.microservice.user.RelationModel.Department;
import com.microservice.user.Response.UserResponseWithDepartment;
import com.microservice.user.model.User;
import com.microservice.user.repository.UserRepository;
import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final RestTemplate restTemplate;

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public UserResponseWithDepartment getUserByIdWithDepartment(long userId) throws NotFoundException {

        User user = userRepository.findById(userId).orElseThrow(() -> new NotFoundException("User not found"));

        Department department = restTemplate.getForObject(
                "http://DEPARTMENT-SERVICE/api/departments/"+user.getDepartmentId(),
                Department.class);

        UserResponseWithDepartment userResponseWithDepartment = UserResponseWithDepartment.builder()
                .userId(user.getUserId())
                .email(user.getEmail())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .department(department)
                .build();

        return userResponseWithDepartment;
    }
}
