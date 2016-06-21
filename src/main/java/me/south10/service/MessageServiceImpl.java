package me.south10.service;

import me.south10.domain.MessageVO;
import me.south10.persistence.MessageDAO;
import me.south10.persistence.PointDAO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;

/**
 * Created by south10 on 2016-06-16.
 */
@Service
public class MessageServiceImpl implements MessageService{
    @Inject
    MessageDAO messageDAO;

    @Inject
    PointDAO pointDAO;

    //@Transactional
    @Override
    public void addMessage(MessageVO vo) throws Exception {
        messageDAO.create(vo);
        pointDAO.updatePoint(vo.getSender(), 10);
    }

    @Override
    public MessageVO readMessage(String uid, Integer mid) throws Exception {
        messageDAO.updateState(mid);
        pointDAO.updatePoint(uid, 5);
        return messageDAO.readMessage(mid);
    }
}
