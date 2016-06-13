package me.south10.persistence;

import me.south10.domain.BoardVO;
import me.south10.domain.Criteria;

import java.util.List;

/**
 * Created by south10 on 2016-06-13.
 */
public interface BoardDAO {
    public void create(BoardVO vo) throws Exception;

    public BoardVO read(Integer bno) throws Exception;

    public void update(BoardVO vo) throws Exception;

    public void delete(Integer bno) throws Exception;

    public List<BoardVO> listAll() throws Exception;

    public List<BoardVO> listPage(int page) throws Exception;

    public List<BoardVO> listCriteria(Criteria cri) throws Exception;

    public int countPaging(Criteria cri) throws Exception;
}
