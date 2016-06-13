package me.south10.service;

import me.south10.domain.BoardVO;
import me.south10.persistence.BoardDAO;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by south10 on 2016-06-13.
 */
@Service
public class BoardServiceImpl implements BoardService{
    @Inject
    private BoardDAO dao;

    @Override
    public void regist(BoardVO vo) throws Exception {
        dao.create(vo);
    }

    @Override
    public BoardVO read(Integer bno) throws Exception {
        return dao.read(bno);
    }

    @Override
    public void modify(BoardVO board) throws Exception {
        dao.update(board);
    }

    @Override
    public void remove(Integer bno) throws Exception {
        dao.delete(bno);
    }

    @Override
    public List<BoardVO> listAll() throws Exception {
        return dao.listAll();
    }
}
