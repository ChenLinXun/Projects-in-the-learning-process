package com.feng.mapper;

import com.feng.pojo.Brand;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface BrandMapper {

    List<Brand> selectAll();

    Brand selectById(int id);

    /**
     * 多条件动态查询
     * 散装参数
     * @param status
     * @param companyName
     * @param brandName
     * @return
     */
    List<Brand> selectByCondition(
            @Param("status")int status,
            @Param("companyName")String companyName,
            @Param("brandName")String brandName);


    /**
     * 多条件动态查询
     * 实体类封装参数
     * @param brand
     * @return
     */
    List<Brand> selectByCondition(Brand brand);

    /**
     * 多条件动态查询
     * Map集合封装参数
     * @param map
     * @return
     */
    List<Brand> selectByCondition(Map map);

    /**
     * 单条件动态查询
     * 实体类封装参数（因为不知道要传哪个参数）
     * @param brand
     * @return
     */
    List<Brand> selectByConditionSingle(Brand brand);

    /**
     * 分页查询
     * 散装参数
     * 过时了，完成分页，使用分页插件更高效
     * @param start
     * @param pageSize
     * @return
     */
    @Deprecated
    List<Brand> selectAllByPage(@Param("start") int start, @Param("pageSize") int pageSize);

    /**
     * 添加
     * @param brand
     */
    void add(Brand brand);

    /**
     * 修改---修改全部字段
     * @param brand
     * @return
     */
    @Deprecated
    int updateAll(Brand brand);

    /**
     * 修改---修改动态字段
     * @param brand
     * @return
     */
    int update(Brand brand);

    /**
     * 删除一条记录
     * @param id
     * @return
     */
    int deleteById(int id);


    /**
     * 批量删除记录
     * @param ids
     * @return
     */
    int deleteByIds(@Param("ids")int[] ids);
}
