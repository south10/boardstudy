package me.south10.test;

import lombok.extern.slf4j.Slf4j;
import me.south10.domain.BoardVO;
import me.south10.persistence.BoardDAO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;

/**
 * Created by south10 on 2016-06-13.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
@Slf4j
public class BoardDAOTest {
    @Inject
    private BoardDAO dao;

    @Test
    public void testCreate() throws Exception {
        BoardVO board = new BoardVO();
        board.setTitle("테스트글1");
        board.setContent("테스트콘텐츠1");
        board.setWriter("user00");
        dao.create(board);
    }

    @Test
    public void testRead() throws Exception {
        log.info(dao.read(1).toString());
    }

    @Test
    public void testUpdate() throws Exception {
        BoardVO board = new BoardVO();
        board.setTitle("테스트1수정");
        board.setContent("테스트수정콘텐츠1");
        board.setBno(1);
        dao.update(board);
    }

    @Test
    public void testDelete() throws Exception {
        dao.delete(1);
    }

    @Test
    public void testListAll() throws Exception {
        log.info(dao.listAll().toString());
    }
}
