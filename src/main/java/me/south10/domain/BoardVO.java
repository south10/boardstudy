package me.south10.domain;

import lombok.Data;

import java.util.Date;

/**
 * Created by south10 on 2016-06-02.
 */
@Data
public class BoardVO {
    private Integer bno;
    private String title;
    private String content;
    private String writer;
    private Date regdate;
    private int viewcnt;
    private int replycnt;
}
