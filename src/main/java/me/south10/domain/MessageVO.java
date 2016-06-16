package me.south10.domain;

import lombok.Data;

import java.util.Date;

/**
 * Created by south10 on 2016-06-16.
 */
@Data
public class MessageVO {
    private Integer mid;
    private String targetid;
    private String sender;
    private String message;
    private Date opendate;
    private Date senddate;
}
