package me.south10.persistence;

import me.south10.domain.UserVO;
import me.south10.dto.LoginDTO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;

/**
 * Created by south10 on 2016-06-23.
 */
@Repository
public class UserDAOImpl implements UserDAO{
    @Inject
    private SqlSession session;

    private static String namespace = "me.south10.mapper.UserMapper";
    @Override
    public UserVO login(LoginDTO dto) throws Exception {
        return session.selectOne(namespace + ".login", dto);
    }
}
