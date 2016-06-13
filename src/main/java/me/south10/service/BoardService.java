package me.south10.service;

import me.south10.domain.BoardVO;

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
}
