package me.south10.service;

import me.south10.domain.UserVO;
import me.south10.dto.LoginDTO;
import me.south10.persistence.UserDAO;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

/**
 * Created by south10 on 2016-06-23.
 */
@Service
public class UserServiceImpl implements UserService {
    @Inject
    private UserDAO dao;

    @Override
    public UserVO login(LoginDTO dto) throws Exception {
        return dao.login(dto);
    }
}
