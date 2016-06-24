package me.south10.service;

import me.south10.domain.UserVO;
import me.south10.dto.LoginDTO;
import me.south10.persistence.UserDAO;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.Date;

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

    @Override
    public void keepLogin(String uid, String sessionId, Date next) throws Exception {
        dao.keepLogin(uid, sessionId, next);
    }

    @Override
    public UserVO checkLoginBefore(String value) {
        return dao.checkUserWithSessionKey(value);
    }
}
