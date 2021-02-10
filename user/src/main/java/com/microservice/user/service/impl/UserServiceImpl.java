package com.microservice.user.service.impl;

import com.microservice.user.dto.DepartmentDto;
import com.microservice.user.dto.UserInformationDto;
import com.microservice.user.entity.User;
import com.microservice.user.repository.UserRepository;
import com.microservice.user.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.transaction.Transactional;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final RestTemplate restTemplate;

    @Override
    public User createUser(User newUser) {
        log.info("Saving user=[{}]", newUser);
        return userRepository.save(newUser);
    }

    @Override
    public UserInformationDto getUserWithDepartment(Long userId) {
        log.info("Getting user=[{}] with department", userId);
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalStateException(String.format("User [%s] not found", userId)));
        DepartmentDto department = restTemplate.getForObject("http://department-service/departments/" + user.getDepartmentId(),
                DepartmentDto.class);
        return new UserInformationDto(user, department);
    }

}
