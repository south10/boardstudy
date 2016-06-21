package me.south10.service;

import me.south10.domain.BoardVO;
import me.south10.domain.Criteria;
import me.south10.domain.SearchCriteria;
import me.south10.persistence.BoardDAO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by south10 on 2016-06-13.
 */
@Service
public class BoardServiceImpl implements BoardService{
    @Inject
    private BoardDAO dao;

    @Transactional
    @Override
    public void regist(BoardVO vo) throws Exception {
        dao.create(vo);
        String[] files = vo.getFiles();

        if (files == null) {
            return;
        }

        for(String fileName : files){
            dao.addAttach(fileName);
        }
    }

    @Transactional(isolation = Isolation.READ_COMMITTED)
    @Override
    public BoardVO read(Integer bno) throws Exception {
        dao.updateViewCnt(bno);
        return dao.read(bno);
    }

    @Transactional
    @Override
    public void modify(BoardVO board) throws Exception {
        dao.update(board);
        Integer bno = board.getBno();
        dao.deleteAttach(bno);

        String[] files = board.getFiles();
        if (files == null) {
            return;
        }

        for(String fileName:files){
            dao.replaceAttach(fileName, bno);
        }
    }

    @Transactional
    @Override
    public void remove(Integer bno) throws Exception {
        dao.deleteAttach(bno);
        dao.delete(bno);
    }

    @Override
    public List<BoardVO> listAll() throws Exception {
        return dao.listAll();
    }

    @Override
    public List<BoardVO> listCriteria(Criteria cri) throws Exception {
        return dao.listCriteria(cri);
    }

    @Override
    public int countPaging(Criteria cri) throws Exception {
        return dao.countPaging(cri);
    }

    @Override
    public List<BoardVO> listSearchCriteria(SearchCriteria cri) throws Exception {
        return dao.listSearch(cri);
    }

    @Override
    public int listSearchCount(SearchCriteria cri) throws Exception {
        return dao.listSearchCount(cri);
    }

    @Override
    public List<String> getAttach(Integer bno) throws Exception {
        return dao.getAttach(bno);
    }
}
