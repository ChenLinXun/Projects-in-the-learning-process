package com.movie.service.impl;

import com.movie.pojo.MovieClassify;
import com.movie.service.MovieClassifyService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MovieClassifyServiceImplTest {

    @Autowired
    private MovieClassifyService movieClassifyService;

    @Test
    void insertClassify() {
        MovieClassify movieClassify = new MovieClassify(null,
                "动作", "1f332f36d39b428fa8fbf67cb4b356f4");
        String s = movieClassifyService.insertClassify(movieClassify);
        System.out.println(s);
    }
}