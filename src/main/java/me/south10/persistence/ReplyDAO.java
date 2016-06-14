package me.south10.persistence;

import me.south10.domain.Criteria;
import me.south10.domain.ReplyVO;

import java.util.List;

/**
 * Created by south10 on 2016-06-14.
 */
public interface ReplyDAO {
    public List<ReplyVO> list(Integer bno) throws Exception;

    public void create(ReplyVO vo) throws Exception;

    public void update(ReplyVO vo) throws Exception;

    public void delete(Integer rno) throws Exception;

    public List<ReplyVO> listPage(Integer bno, Criteria cri) throws Exception;

    public int count(Integer bno) throws Exception;
}
