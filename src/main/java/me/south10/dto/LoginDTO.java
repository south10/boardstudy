package me.south10.dto;

import lombok.Data;

/**
 * Created by south10 on 2016-06-23.
 */
@Data
public class LoginDTO {
    private String uid;
    private String upw;
    private boolean useCookie;
}
