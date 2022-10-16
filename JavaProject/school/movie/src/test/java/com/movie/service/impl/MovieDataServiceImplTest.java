package com.movie.service.impl;

import com.movie.pojo.MovieData;
import com.movie.req.MovieDataPageReq;
import com.movie.service.MovieDataService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MovieDataServiceImplTest {

    @Autowired
    private MovieDataService movieDataService;

    @Test
    void insertData() {
        MovieData data = new MovieData(null,"《钢铁侠》", "漫威经典电影", 9.8f, "美国", "2012","static/img0");
        String s = movieDataService.insertData(data);
        System.out.println(s);
    }

    @Test
    void deleteData() {
        String s = "14f8ab426bac4b6290123353d8886057";
        System.out.println(movieDataService.deleteData(s));
    }

    @Test
    void updateData() {
        MovieData movieData = new MovieData();
        movieData.setDataId("1f332f36d39b428fa8fbf67cb4b356f4");
        movieData.setDataDate("2008");
        movieData.setDataDesc("漫威崛起之作");
        System.out.println(movieDataService.updateData(movieData));
    }

    @Test
    void selectAll() {
        System.out.println(movieDataService.selectAll(2));
    }

    @Test
    void selectDataByCondition() {
        MovieDataPageReq movieDataPageReq = new MovieDataPageReq();
        movieDataPageReq.setDataCountry("国");
        movieDataPageReq.setPageNum(2);
        System.out.println(movieDataService.selectDataByCondition(movieDataPageReq));
    }

    @Test
    void selectDataByName() {
        System.out.println(movieDataService.selectDataByName("钢铁侠"));
    }

    @Test
    void selectDataJoinClassify() {
        MovieDataPageReq movieDataPageReq = new MovieDataPageReq();
        movieDataPageReq.setDataClassifyType("科幻");
        movieDataPageReq.setPageNum(1);
        System.out.println(movieDataService.selectDataJoinClassify(movieDataPageReq));
    }
}