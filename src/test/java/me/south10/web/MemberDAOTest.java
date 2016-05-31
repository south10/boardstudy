package me.south10.web;

import me.south10.domain.MemberVO;
import me.south10.persistence.MemberDAO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;

/**
 * Created by south10 on 2016-05-31.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class MemberDAOTest {
    @Inject
    MemberDAO dao;

    @Test
    public void testTime()throws Exception{
        System.out.println(dao.getTime());
    }

    @Test
    public void testInsertMember()throws Exception{
        MemberVO vo = new MemberVO();
        vo.setUserid("user00");
        vo.setUserpw("user00");
        vo.setUsername("USER00");
        vo.setEmail("user00@aaa.com");
        dao.insertMember(vo);
    }
}
