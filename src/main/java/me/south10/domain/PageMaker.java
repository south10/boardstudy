package me.south10.domain;

import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

/**
 * Created by south10 on 2016-06-13.
 */
public class PageMaker {
    private int totalCount;
    private int startPage;
    private int endPage;
    private boolean prev;
    private boolean next;

    private int displayPageNum = 10;
    private Criteria cri;

    public void setCri(Criteria cri){
        this.cri = cri;
    }

    public void setTotalCount(int totalCount){
        this.totalCount = totalCount;
        calcData();
    }

    private void calcData() {
        this.endPage = (int) (Math.ceil(this.cri.getPage() / (double) displayPageNum) * displayPageNum);
        this.startPage = (this.endPage - this.displayPageNum) + 1;
        int tempEndPage = (int) (Math.ceil(this.totalCount / (double) this.cri.getPerPageNum()));
        if (endPage > tempEndPage) {
            this.endPage = tempEndPage;
        }
        this.prev = this.startPage == 1 ? false : true;
        this.next = this.endPage * this.cri.getPerPageNum() >= this.totalCount ? false : true;
    }


    public int getTotalCount() {
        return totalCount;
    }

    public int getStartPage() {
        return startPage;
    }

    public int getEndPage() {
        return endPage;
    }

    public boolean isPrev() {
        return prev;
    }

    public boolean isNext() {
        return next;
    }

    public int getDisplayPageNum() {
        return displayPageNum;
    }

    public Criteria getCri() {
        return cri;
    }

    public String makeQuery(int page){
        UriComponents uriComponents = UriComponentsBuilder.newInstance()
                .queryParam("page", page)
                .queryParam("perPageNum", cri.getPerPageNum())
                .build();

        return uriComponents.toString();
    }

    public String makeSearch(int page){
        UriComponents uriComponents = UriComponentsBuilder.newInstance()
                .queryParam("page", page)
                .queryParam("perPageNum", cri.getPerPageNum())
                .queryParam("searchType", ((SearchCriteria)cri).getSearchType())
                .queryParam("keyword", ((SearchCriteria)cri).getKeyword())
                .build();

        return uriComponents.toString();
    }
}
