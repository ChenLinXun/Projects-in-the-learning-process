package com.movie.resp;

import com.movie.pojo.MovieData;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieDataPageResp {
    private List<MovieData> movieData; //具体数据
    private int pageNum; //当前页
    private int size; //当前页中的数据条数
    private long total; //总数据条数
}
