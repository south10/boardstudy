package me.south10.service;

import me.south10.domain.UserVO;
import me.south10.dto.LoginDTO;

/**
 * Created by south10 on 2016-06-23.
 */
public interface UserService {
    public UserVO login(LoginDTO dto) throws Exception;
}
