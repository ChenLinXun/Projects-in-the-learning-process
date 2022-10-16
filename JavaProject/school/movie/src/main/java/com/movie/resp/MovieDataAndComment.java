package com.movie.resp;

import com.movie.pojo.MovieComment;
import com.movie.pojo.MovieData;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieDataAndComment {
    private MovieData movieData;
    private List<MovieComment> movieComments;
}
