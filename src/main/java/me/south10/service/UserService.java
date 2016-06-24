package me.south10.service;

import me.south10.domain.UserVO;
import me.south10.dto.LoginDTO;

import java.util.Date;

/**
 * Created by south10 on 2016-06-23.
 */
public interface UserService {
    public UserVO login(LoginDTO dto) throws Exception;
    public void keepLogin(String uid, String sessionId, Date next)throws Exception;
    public UserVO checkLoginBefore(String value);
}
