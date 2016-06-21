package me.south10.domain;

import lombok.Data;

import java.util.Date;

/**
 * Created by south10 on 2016-06-14.
 */
@Data
public class ReplyVO {
    private Integer rno;
    private Integer bno;
    private String replytext;
    private String replyer;
    private Date regdate;
    private Date updatedate;

}
