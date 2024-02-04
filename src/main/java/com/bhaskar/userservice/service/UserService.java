package com.bhaskar.userservice.service;

import com.bhaskar.userservice.VO.Department;
import com.bhaskar.userservice.VO.ResponseTemplateVO;
import com.bhaskar.userservice.entity.User;
import com.bhaskar.userservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repository;
    private final RestTemplate restTemplate;

    public User save(User user){
        return repository.save(user);
    }

    public List<User> list(){
        return repository.findAll();
    }

    public ResponseTemplateVO getUserWithDepartment(Long userId) {

        ResponseTemplateVO vo = new ResponseTemplateVO();
        User user = repository.findByUserId(userId);
        Department department = restTemplate.getForObject("http://localhost:2024/api/department/"+user.getDepartmentId(),
                Department.class);
        vo.setUser(user);
        vo.setDepartment(department);
        return vo;
    }
}
