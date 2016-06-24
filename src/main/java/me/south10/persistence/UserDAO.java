package me.south10.persistence;

import me.south10.domain.UserVO;
import me.south10.dto.LoginDTO;

import java.util.Date;

/**
 * Created by south10 on 2016-06-23.
 */
public interface UserDAO {
    public UserVO login(LoginDTO dto) throws Exception;
    public void keepLogin(String uid, String sessionId, Date next);
    public UserVO checkUserWithSessionKey(String value);
}
