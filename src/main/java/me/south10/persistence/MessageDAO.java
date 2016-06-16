package me.south10.persistence;

import me.south10.domain.MessageVO;

/**
 * Created by south10 on 2016-06-16.
 */
public interface MessageDAO {
    public void create(MessageVO vo) throws Exception;

    public MessageVO readMessage(Integer mid) throws Exception;

    public void updateState(Integer mid) throws Exception;
}
