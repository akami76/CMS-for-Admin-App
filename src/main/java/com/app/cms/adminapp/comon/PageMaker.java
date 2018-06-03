package com.app.cms.adminapp.comon;

import lombok.Getter;
import lombok.ToString;
import lombok.extern.java.Log;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.List;

@Getter
@ToString(exclude="pageList")
@Log
public class PageMaker<T> {
    private Page<T> result;
    private Pageable prevPage;
    private Pageable nextPage;
    private int currentPageNum;
    private int totalPageNum;
    private Pageable currentPage;
    private List<Pageable> pageList;

    public PageMaker(Page<T> result){
        this.result = result;
        this.currentPage = result.getPageable();
        this.currentPageNum = currentPage.getPageNumber() + 1;
        this.totalPageNum = result.getTotalPages();
        this.pageList = new ArrayList<>();
        calcPages();
    }

    private void calcPages(){
        int tempEndNum = (int)(Math.ceil(this.currentPageNum / 10)*10);
        int startNum = tempEndNum - 9;
        Pageable statPage = this.currentPage;

        for(int i = startNum ; i < this.currentPageNum ; i++){
            statPage = statPage.previousOrFirst();

        }

        this.prevPage = statPage.getPageNumber() <= 0 ? null : statPage.previousOrFirst();

        log.info("tempEndNum : " + tempEndNum);
        log.info("total : "+ totalPageNum);


        if(this.totalPageNum < tempEndNum){
            tempEndNum = this.totalPageNum;
            this.nextPage = null;
        }

        for(int i = startNum ; i <= tempEndNum ; i++) {
            pageList.add(statPage);
            log.info(statPage.toString());
            statPage = statPage.next();
        }
        this.nextPage = statPage.getPageNumber() + 1 < totalPageNum ? statPage : null;
        }
    }

