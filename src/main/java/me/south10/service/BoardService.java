package me.south10.service;

import me.south10.domain.BoardVO;
import me.south10.domain.Criteria;
import me.south10.domain.SearchCriteria;

import java.util.List;

/**
 * Created by south10 on 2016-06-13.
 */
public interface BoardService {
    public void regist(BoardVO vo) throws Exception;

    public BoardVO read(Integer bno) throws Exception;

    public void modify(BoardVO board) throws Exception;

    public void remove(Integer bno) throws Exception;

    public List<BoardVO> listAll() throws Exception;

    public List<BoardVO> listCriteria(Criteria cri) throws Exception;

    public int countPaging(Criteria cri) throws Exception;

    public List<BoardVO> listSearchCriteria(SearchCriteria cri) throws Exception;

    public int listSearchCount(SearchCriteria cri) throws Exception;

    public List<String> getAttach(Integer bno) throws Exception;
}
