package me.south10.service;

import me.south10.domain.Criteria;
import me.south10.domain.ReplyVO;
import me.south10.persistence.BoardDAO;
import me.south10.persistence.ReplyDAO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by south10 on 2016-06-14.
 */
@Service
public class ReplyServiceImpl implements ReplyService{
    @Inject
    ReplyDAO replyDAO;

    @Inject
    BoardDAO boardDAO;

    @Transactional
    @Override
    public void addReply(ReplyVO vo) throws Exception {
        replyDAO.create(vo);
        boardDAO.updateReplyCnt(vo.getBno(), 1);
    }

    @Override
    public List<ReplyVO> listReply(Integer bno) throws Exception {
        return replyDAO.list(bno);
    }

    @Override
    public void modifyReply(ReplyVO vo) throws Exception {
        replyDAO.update(vo);
    }

    @Transactional
    @Override
    public void removeReply(Integer rno) throws Exception {
        int bno = replyDAO.getBno(rno);
        replyDAO.delete(rno);
        boardDAO.updateReplyCnt(bno, -1);
    }

    @Override
    public List<ReplyVO> listReplyPage(Integer bno, Criteria cri) throws Exception {
        return replyDAO.listPage(bno, cri);
    }

    @Override
    public int count(Integer bno) throws Exception {
        return replyDAO.count(bno);
    }
}
