package me.south10.service;

import me.south10.domain.MessageVO;

/**
 * Created by south10 on 2016-06-16.
 */
public interface MessageService {
    public void addMessage(MessageVO vo) throws Exception;

    public MessageVO readMessage(String uid, Integer mid) throws Exception;
}
