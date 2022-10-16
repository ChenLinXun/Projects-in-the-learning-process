import com.feng.mapper.BrandMapper;
import com.feng.pojo.Brand;
import com.feng.utils.MyBatisUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

/**
 * BrandMapper测试用例
 */
public class BrandTest {

    @Test
    public void testSelectAll(){

        BrandMapper brandMapper = MyBatisUtil.getMapper(BrandMapper.class);

        List<Brand> brands = brandMapper.selectAll();
        System.out.println(brands);

        MyBatisUtil.closeSqlSession();
    }

    @Test
    public void testSelectById(){

        //假如获取到的数据id为3
        int id = 3;

        BrandMapper brandMapper = MyBatisUtil.getMapper(BrandMapper.class);

        Brand brand = brandMapper.selectById(id);
        System.out.println(brand);

        MyBatisUtil.closeSqlSession();
    }

    @Test
    public void testSelectByCondition(){

        //假如获取到了参数：(将来是自动的)
        int status = 1;
        String companyName = "华为";
        String brandName = "华为";

        //后两个参数采用模糊查询，因此需要数据处理（这里才是真正自己写的）
        companyName = "%" + companyName + "%";
        brandName = "%" + brandName + "%";

        BrandMapper brandMapper = MyBatisUtil.getMapper(BrandMapper.class);

        //情况一：假如调用散装参数的方法，不用封装数据：
        List<Brand> brands = brandMapper.selectByCondition(status, companyName, brandName);
        System.out.println(brands);


        //情况二：假如获取到的数据需要封装到brand对象中：（将来是自动的）
        //封装：
        Brand brand = new Brand();
        brand.setStatus(status);
        brand.setCompanyName(companyName);
        brand.setBrandName(brandName);
        //执行对应方法：
        List<Brand> brands1 = brandMapper.selectByCondition(brand);
        System.out.println(brands1);


        //情况三：假如获取到的数据需要封装到map集合中：
        //封装：
        HashMap map = new HashMap();
        map.put("status",status);
        map.put("companyName",companyName);
        map.put("brandName",brandName);
        //执行对应方法
        List<Brand> brands2 = brandMapper.selectByCondition(map);
        System.out.println(brands2);


        //情况四：假如用户只输入了部分参数
        companyName = "";
        brandName = null;
        List<Brand> brands3 = brandMapper.selectByCondition(status, companyName, brandName);
        System.out.println(brands3);

        MyBatisUtil.closeSqlSession();
    }

    @Test
    public void testSelectByConditionSingle(){

        //假如用户传入的参数是：
        String companyName = "小米";

        //参数处理
        companyName = "%" + companyName + "%";

        //封装数据
        Brand brand = new Brand();
        brand.setCompanyName(companyName);

        BrandMapper brandMapper = MyBatisUtil.getMapper(BrandMapper.class);

        List<Brand> brands = brandMapper.selectByConditionSingle(brand);
        System.out.println(brands);

        MyBatisUtil.closeSqlSession();
    }

    @Test
    public void testSelectAllByPage(){

        //假如用户传入的数据是：
        int start = 0;
        int pageSize = 2;

        BrandMapper brandMapper = MyBatisUtil.getMapper(BrandMapper.class);

        List<Brand> brands = brandMapper.selectAllByPage(start, pageSize);
        System.out.println(brands);

        MyBatisUtil.closeSqlSession();
    }

    @Test//使用pagehelper进行分页查询
    public void testSelectByPagehelper(){

        //使用pagehelper可以将查询数据和页码、每页数据条数等分页信息封装起来
        //不需要再手动完成这些逻辑实现，十分方便，并且使得前端完成分页显示十分便捷

        BrandMapper brandMapper = MyBatisUtil.getMapper(BrandMapper.class);

        //设置分页（参数一：第几页；参数二：一页中有几条数据）
        PageHelper.startPage(2, 2);
        List<Brand> brands = brandMapper.selectAll();
        MyBatisUtil.closeSqlSession();

        //将查询数据封装到pageInfo中
        PageInfo<Brand> pageInfo = new PageInfo<Brand>(brands);

        //从pageInfo中可以获取分页的各种数据:
        //获取数据
        List<Brand> list = pageInfo.getList();
        for (Brand brand : list) {
            System.out.println(brand);
        }
        //获取当前页码
        int pageNum = pageInfo.getPageNum();
        System.out.println("第"+pageNum+"页");
    }

    @Test
    public void testAdd(){

        //假如用户传入了数据：
        String brandName = "波导手机";
        String companyName = "波导";
        int ordered = 100;
        String description = "手机中的战斗机";
        int status = 1;

        //封装数据
        Brand brand = new Brand();
        brand.setCompanyName(companyName);
        brand.setBrandName(brandName);
        brand.setOrdered(ordered);
        brand.setDescription(description);
        brand.setStatus(status);

        try {
            BrandMapper brandMapper = MyBatisUtil.getMapper(BrandMapper.class);
            brandMapper.add(brand);
            //提交事务
            MyBatisUtil.commit();
        } catch (Exception e) {
            //回滚事务
            MyBatisUtil.rollback();
            e.printStackTrace();
        } finally {
            MyBatisUtil.closeSqlSession();
        }
        Integer id = brand.getId();
        System.out.println("本条数据的主键id是："+id);
    }

    @Test
    @Deprecated
    public void testUpdateAll(){

        //假如用户传入了数据：
        String brandName = "椰树牌椰汁";
        String companyName = "椰树集团";
        int ordered = 150;
        String description = "从小喝到大";
        int status = 1;
        int id = 5;

        //封装数据
        Brand brand = new Brand();
        brand.setCompanyName(companyName);
        brand.setBrandName(brandName);
        brand.setOrdered(ordered);
        brand.setDescription(description);
        brand.setStatus(status);
        brand.setId(id);

        int update = 0;
        try {
            BrandMapper brandMapper = MyBatisUtil.getMapper(BrandMapper.class);
            update = brandMapper.updateAll(brand);
            //提交事务
            MyBatisUtil.commit();
        } catch (Exception e) {
            //回滚事务
            MyBatisUtil.rollback();
            e.printStackTrace();
        } finally {
            MyBatisUtil.closeSqlSession();
        }
        System.out.println(update);
    }

    @Test
    public void testUpdate(){

        //假如用户传入了数据：
        int ordered = 150;
        int id = 5;

        //封装数据
        Brand brand = new Brand();
        brand.setOrdered(ordered);
        brand.setId(id);

        int update = 0;
        try {
            BrandMapper brandMapper = MyBatisUtil.getMapper(BrandMapper.class);
            update = brandMapper.update(brand);
            //提交事务
            MyBatisUtil.commit();
        } catch (Exception e) {
            //回滚事务
            MyBatisUtil.rollback();
            e.printStackTrace();
        } finally {
            MyBatisUtil.closeSqlSession();
        }
        System.out.println(update);
    }

    @Test
    public void testDeleteById(){

        //假如用户传入了数据：
        int id = 6;

        int update = 0;
        try {
            BrandMapper brandMapper = MyBatisUtil.getMapper(BrandMapper.class);
            update = brandMapper.deleteById(id);
            //提交事务
            MyBatisUtil.commit();
        } catch (Exception e) {
            //回滚事务
            MyBatisUtil.rollback();
            e.printStackTrace();
        } finally {
            MyBatisUtil.closeSqlSession();
        }
        System.out.println(update);
    }

    @Test
    public void testDeleteByIds(){

        //假如用户传入了数据：
        int[] ids = {7,8,9};

        int update = 0;
        try {
            BrandMapper brandMapper = MyBatisUtil.getMapper(BrandMapper.class);
            update = brandMapper.deleteByIds(ids);
            //提交事务
            MyBatisUtil.commit();
        } catch (Exception e) {
            //回滚事务
            MyBatisUtil.rollback();
            e.printStackTrace();
        } finally {
            MyBatisUtil.closeSqlSession();
        }
        System.out.println(update);
    }
}
