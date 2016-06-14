package me.south10.domain;

import lombok.Data;

/**
 * Created by south10 on 2016-06-14.
 */
@Data
public class SearchCriteria extends Criteria{
    private String searchType;
    private String keyword;
}
