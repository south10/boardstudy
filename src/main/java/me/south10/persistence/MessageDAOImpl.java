package me.south10.persistence;

import me.south10.domain.MessageVO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;

/**
 * Created by south10 on 2016-06-16.
 */
@Repository
public class MessageDAOImpl implements MessageDAO{
    @Inject
    private SqlSession session;

    private static String namespace = "me.south10.mapper.MessageMapper";

    public void create(MessageVO vo) throws Exception {
        session.insert(namespace + ".create", vo);
    }

    public MessageVO readMessage(Integer mid) throws Exception {
        return session.selectOne(namespace + ".readMessage", mid);
    }

    public void updateState(Integer mid) throws Exception {
        session.update(namespace + "updateState", mid);
    }
}
