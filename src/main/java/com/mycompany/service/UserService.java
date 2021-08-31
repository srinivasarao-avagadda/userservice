package com.mycompany.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.mycompany.entity.User;
import com.mycompany.repository.UserRepository;
import com.mycompany.vo.Department;
import com.mycompany.vo.RestTemplateVO;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserService {
    
    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private RestTemplate restTemplate;

    public User saveUser(User User) {
        log.info("inside method of UserService.saveUser ");
        return userRepository.save(User);
    }

    public RestTemplateVO getUserAndDeptByUserId(Long userId) {
        log.info("inside method of UserService.getUserAndDeptByUserId");
        RestTemplateVO restTemplateVO = new RestTemplateVO();
        User user = userRepository.findByUserId(userId);
        Department department = restTemplate.getForObject("http://DEPARTMENT/departments/" + user.getDeptId(), Department.class);
        restTemplateVO.setUser(user);
        restTemplateVO.setDepartment(department);
        return restTemplateVO;
    }
}
