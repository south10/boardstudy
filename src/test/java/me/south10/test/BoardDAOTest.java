package me.south10.test;

import lombok.extern.slf4j.Slf4j;
import me.south10.domain.BoardVO;
import me.south10.domain.Criteria;
import me.south10.domain.SearchCriteria;
import me.south10.persistence.BoardDAO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import javax.inject.Inject;
import java.util.List;

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

    @Test
    public void testListPage() throws Exception {
        int page = 3;
        List<BoardVO> list = dao.listPage(page);

        for(BoardVO vo : list){
            log.info(vo.getBno() + ":" + vo.getTitle());
        }
    }

    @Test
    public void testListCriteria() throws Exception {
        Criteria cri = new Criteria();
        cri.setPage(2);
        cri.setPerPageNum(20);
        List<BoardVO> list = dao.listCriteria(cri);

        for(BoardVO vo : list){
            log.info(vo.getBno() + ":" + vo.getTitle());
        }
    }

    @Test
    public void testURI() throws Exception {
        UriComponents uriComponents = UriComponentsBuilder.newInstance()
                .path("/board/read")
                .queryParam("bno", 12)
                .queryParam("perPageNum", 20)
                .build();

        log.info("/board/read?bno=12&perPageNum=20");
        log.info(uriComponents.toString());
    }

    @Test
    public void testURI2() throws Exception {
        UriComponents uriComponents = UriComponentsBuilder.newInstance()
                .path("/{module}/{page}")
                .queryParam("bno", 12)
                .queryParam("perPageNum", 20)
                .build()
                .expand("board","read")
                .encode();
        log.info("/board/read?bno=12&perPageNum=20");
        log.info(uriComponents.toString());
    }

    @Test
    public void testDynamic() throws Exception {
        SearchCriteria cri = new SearchCriteria();
        cri.setPage(1);
        cri.setKeyword("스프링");
        cri.setSearchType("t");

        log.info("=====================================");

        List<BoardVO> list = dao.listSearch(cri);

        for(BoardVO vo : list){
            log.info(vo.getBno() + ":" + vo.getTitle());
        }

        log.info("=====================================");
        log.info("COUNT : " + dao.listSearchCount(cri));
    }
}
