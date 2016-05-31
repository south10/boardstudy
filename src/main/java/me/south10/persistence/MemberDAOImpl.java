package me.south10.persistence;

import me.south10.domain.MemberVO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by south10 on 2016-05-31.
 */
@Repository
public class MemberDAOImpl implements MemberDAO {
    @Inject
    SqlSession sqlSession;

    private static final String namespace = "me.south10.mapper.MemberMapper";

    public String getTime() {
        return sqlSession.selectOne(namespace+".getTime");
    }

    public void insertMember(MemberVO vo) {
        sqlSession.insert(namespace+".insertMember", vo);
    }

    public MemberVO readMember(String userid) throws Exception {
        return (MemberVO) sqlSession.selectOne(namespace+".selectMember", userid);
    }

    public MemberVO readWithPW(String userid, String userpw) throws Exception {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("userid", userid);
        paramMap.put("userpw", userpw);
        return sqlSession.selectOne(namespace+".readWithPW", paramMap);
    }
}
