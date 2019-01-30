package com.javaliu.boot.base.mapper;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface BaseMapper<T>{

    /**
     * 插入实体对象
     * @param t
     */
    public void insertOne(T t);

    /**
     * 批量插入实体对象
     * @param list
     */
    public void insertBatchList(List<T> list);

    /**
     * 批量插入实体对象
     * @param array
     */
    public void insertBatchArray(T[] array);

    /**
     * 批量插入实体对象
     * @param params
     */
    public void insertBatchMap(Map<String, Object> params);
    /**
     * 更新对象
     * @param t
     */
    public void update(T t);

    /**
     * 删除对象
     * @param id
     */
    public void delete(@Param("id") Object id);

    /**
     * 根据某些条件删除
     * @param params
     */
    public void deleteBy(Map<String, Object> params);

    /**
     * 查询单个对象
     * @param id    主键ID
     * @return
     */
    public T selectOne(@Param("id") Object id);

    /**
     * 根据某些条件查询唯一一个对象
     * @param params
     * @return
     */
    public T selectOneBy(Map<String, Object> params);

    /**
     * 根据某些条件查询列表
     * @param params
     * @return
     */
    public List<T> selectList(Map<String, Object> params);

    /**
     * 根据某些条件查询记录数
     * @param map
     * @return
     */
    public Long selectCount(Map<String, Object> map);
}
