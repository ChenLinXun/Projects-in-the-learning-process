package com.movie.resp;

import com.movie.pojo.MovieData;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieGoods {
    private List<MovieData> fireMovies;
    private List<ImageURL> rollMovies;
    private List<FansMovie> fansMovies;
}
