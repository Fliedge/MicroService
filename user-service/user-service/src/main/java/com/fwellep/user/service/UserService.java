package com.fwellep.user.service;

import com.fwellep.user.VO.Department;
import com.fwellep.user.VO.PersonnelRating;
import com.fwellep.user.VO.ResponseTemplateVO;
import com.fwellep.user.entity.User;
import com.fwellep.user.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@Slf4j
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    public List<User> getAllUsers() {
        log.info("Inside getAllUsers of UserService");
        return (List<User>) userRepository.findAll();
    }

    public User saveUser(User user) {
        log.info("Inside saveUser of UserService");
        return userRepository.save(user);
    }

    public ResponseTemplateVO getUserInfo(Long userId) {
        log.info("Inside getUserWithDepartment of UserService");
        ResponseTemplateVO vo = new ResponseTemplateVO();
        User user = userRepository.findByUserId(userId);

        Department department =
                restTemplate.getForObject("http://DEPARTMENT-SERVICE/departments/" + user.getDepartmentId(),
                        Department.class);
        PersonnelRating personnelRating =
                restTemplate.getForObject("http://PERSONNELRATING-SERVICE/personnelRatings/" + user.getUserId(),
                        PersonnelRating.class);

        vo.setUser(user);
        vo.setDepartment(department);
        vo.setPersonnelRating(personnelRating);
        return vo;
    }

    public String deleteUserAndInfo(Long userId) {
        log.info("Inside deleteUserAndInfo of UserService");
        User user = userRepository.findByUserId(userId);
        if (userRepository.existsById(userId)){
            userRepository.deleteById(userId);
            restTemplate.delete("http://PERSONNELRATING-SERVICE/personnelRatings/" + user.getUserId(),
                    PersonnelRating.class);
        }else{
            return "No user by that id";
        }
        return "User has been deleted";
    }

    public void updateUser(Long userId, User user) {
        log.info("Inside updateUser of UserService");
        if (userRepository.existsById(userId)){
            user.setUserId(userId);
            userRepository.save(user);
        }
    }
}
