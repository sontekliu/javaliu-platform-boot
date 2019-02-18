package com.javaliu.boot.modules.shortlink.mapper;

import com.javaliu.boot.base.mapper.BaseMapper;
import com.javaliu.boot.modules.shortlink.entity.ShortLinkEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ShortLinkMapper extends BaseMapper<ShortLinkEntity> {
}
