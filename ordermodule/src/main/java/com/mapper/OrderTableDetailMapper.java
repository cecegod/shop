package com.mapper;

import com.po.Ordertabledetail;
import mapper.ISqlMapper;
import org.apache.ibatis.annotations.Select;

public interface OrderTableDetailMapper extends ISqlMapper<Ordertabledetail> {
    @Select("select count(id) from ordertabledetail where ordernumber=#{ordernumber}")
    public Integer getnumber(String ordernumber);
}
