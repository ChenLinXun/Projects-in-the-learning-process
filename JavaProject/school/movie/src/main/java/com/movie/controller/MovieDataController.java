package com.movie.controller;

import com.movie.pojo.MovieData;
import com.movie.req.MovieDataPageReq;
import com.movie.resp.*;
import com.movie.service.MovieDataService;
import com.movie.utils.DataCommentResultJson;
import com.movie.utils.PageResultJson;
import com.movie.utils.ResultJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/movie")
@SuppressWarnings("all")
public class MovieDataController {

    @Autowired
    private MovieDataService movieDataService;

    /**
     * 接口：插入一条电影信息（管理员页面插入）
     * @param MovieData
     * @return
     */
    @PostMapping(value = "/addData")
    public ResultJson<String> addData(@RequestBody MovieData movieData){
        String s = movieDataService.insertData(movieData);
        if(s != null && !"".equals(s)){
            return new ResultJson<String>(200,true,"添加成功",s);
        }else {
            return new ResultJson<String>(200,true,"添加失败",null);
        }
    }

    /**
     * 接口：删除一条电影信息（管理员页面删除）
     * @param 电影ID
     * @return
     */
    @DeleteMapping(value = "/deleteData/{dataId}")
    public ResultJson<Integer> deleteData(@PathVariable String dataId){
        int i = movieDataService.deleteData(dataId);
        if(i > 0){
            return new ResultJson<Integer>(200,true,"删除成功",i);
        }else {
            return new ResultJson<Integer>(200,true,"删除失败",i);
        }
    }

    /**
     * 接口：修改一条电影信息（管理员页面修改）
     * @param 电影ID
     * @return
     */
    @PostMapping(value = "/updateData")
    public ResultJson<Integer> updateData(@RequestBody MovieData movieData){
        int i = movieDataService.updateData(movieData);
        if(i > 0){
            return new ResultJson<Integer>(200,true,"修改成功",i);
        }else {
            return new ResultJson<Integer>(200,true,"修改失败",i);
        }
    }

    /**
     * 接口：查询所有电影信息
     * @param 当前页
     * @return
     */
    @GetMapping(value = "/queryAll/{pageNum}")
    public PageResultJson<List<MovieData>> queryAllData(@PathVariable int pageNum){
        MovieDataPageResp resp = movieDataService.selectAll(pageNum);
        if (resp.getMovieData() != null) {
            return new PageResultJson<List<MovieData>>
                    (200,true,"查询成功",resp.getPageNum(),resp.getSize(),
                            resp.getTotal(),resp.getMovieData());
        } else {
            return new PageResultJson<List<MovieData>>
                    (200,true,"列表为空",resp.getPageNum(),resp.getSize(),
                            resp.getTotal(),null);
        }
    }

    /**
     * 接口：根据电影名查询（搜索框查询）
     * @param 电影名
     * @return
     */
    @GetMapping(value = "/queryByName/{dataName}")
    public ResultJson<List<MovieData>> queryDataByName(@PathVariable String dataName){
        List<MovieData> movieDataList = movieDataService.selectDataByName(dataName);
        if (!movieDataList.isEmpty()) {
            return new ResultJson<List<MovieData>>
                    (200,true,"查询成功",movieDataList);
        } else {
            return new ResultJson<List<MovieData>>
                    (200,false,"列表为空",null);
        }
    }

    /**
     * 接口：根据提供的字段信息查询（动态查询）
     * @param MovieDataPageReq
     * @return
     */
    @PostMapping(value = "/queryByCondition")
    public PageResultJson<List<MovieData>> queryDataByCondition(@RequestBody MovieDataPageReq movieDataPageReq){
        MovieDataPageResp resp = movieDataService.selectDataByCondition(movieDataPageReq);
        if (resp.getMovieData() != null) {
            return new PageResultJson<List<MovieData>>
                    (200,true,"查询成功", resp.getPageNum(),resp.getSize(),
                            resp.getTotal(),resp.getMovieData());
        } else {
            return new PageResultJson<List<MovieData>>
                    (200,true,"查询结果为空",resp.getPageNum(),resp.getSize(),
                            resp.getTotal(),null);
        }
    }

    /**
     * 接口：连接分类表查询（分类页查询）
     * @param MovieDataPageReq
     * @return
     */
    @PostMapping(value = "/queryByJoin")
    public PageResultJson<List<MovieData>> selectDataJoinClassify(@RequestBody MovieDataPageReq movieDataPageReq){

        MovieDataPageResp resp;

        //如果没有传入分类信息，则调用selectDataByCondition查询
        if("".equals(movieDataPageReq.getDataClassifyType())){
            resp = movieDataService.selectDataByCondition(movieDataPageReq);
        }else {//否则，调用selectDataJoinClassify连接分类表查询
            resp = movieDataService.selectDataJoinClassify(movieDataPageReq);
        }

        if (resp.getMovieData() != null) {
            return new PageResultJson<List<MovieData>>
                    (200,true,"查询成功", resp.getPageNum(),resp.getSize(),
                            resp.getTotal(),resp.getMovieData());
        } else {
            return new PageResultJson<List<MovieData>>
                    (200,true,"查询结果为空",resp.getPageNum(),resp.getSize(),
                            resp.getTotal(),null);
        }
    }

    /**
     * 接口：根据电影编号查询电影信息以及评论（详情页查询）
     * @param 电影编号
     * @return DataCommentResultJson
     */
    @GetMapping(value = "/queryDataAndComment/{dataId}")
    public DataCommentResultJson selectDataAndCommentByDataId(@PathVariable String dataId){
        MovieDataAndComment resp = movieDataService.selectDataAndCommentByDataId(dataId);
        if(resp.getMovieData() != null){
            return new DataCommentResultJson(200,true,"查询成功",resp);
        } else {
            return new DataCommentResultJson(200,true,"查询失败",null);
        }
    }

    /**
     * 接口：获取推荐电影信息
     * @param 当前页
     * @return
     */
    @GetMapping(value = "/queryGoods")
    public ResultJson<MovieGoods> queryGoods(){
        //获取库中电影数据
        MovieDataPageResp resp = movieDataService.selectAll(2);

        //从中拿出8条封装到热点推荐中
        List<MovieData> dataList = resp.getMovieData();
        ArrayList<MovieData> fireMovies = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            fireMovies.add(dataList.get(i));
        }

        //设置滚动电影图，4张
        ArrayList<ImageURL> rollMovies = new ArrayList<>();
        rollMovies.add(new ImageURL("http://192.168.192.25:8080/image/滚动1.jpeg"));
        rollMovies.add(new ImageURL("http://192.168.192.25:8080/image/滚动2.jpeg"));
        rollMovies.add(new ImageURL("http://192.168.192.25:8080/image/滚动3.jpeg"));
        rollMovies.add(new ImageURL("http://192.168.192.25:8080/image/滚动4.jpeg"));

        //封装影迷推荐
        ArrayList<FansMovie> fansMovies = new ArrayList<>();
        fansMovies.add(new FansMovie("m1","《肖申克的救赎》"));
        fansMovies.add(new FansMovie("m20","《疯狂动物城》"));
        fansMovies.add(new FansMovie("m22","《教父》"));
        fansMovies.add(new FansMovie("m23","《触不可及》"));
        fansMovies.add(new FansMovie("m24","《怦然心动》"));
        fansMovies.add(new FansMovie("m46","《绿皮书》"));

        //将两个推荐封装起来
        MovieGoods movieGoods = new MovieGoods(fireMovies,rollMovies,fansMovies);

        //封装并返回
        return new ResultJson<MovieGoods>
                (200,true,"首页推荐",movieGoods);
    }
}
