package com.microservice.user.service;

import com.microservice.user.dto.UserInformationDto;
import com.microservice.user.entity.User;

public interface UserService {

    User createUser(User newUser);

    UserInformationDto getUserWithDepartment(Long userId);

}
