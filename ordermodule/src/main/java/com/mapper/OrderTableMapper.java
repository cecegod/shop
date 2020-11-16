package com.mapper;


import com.po.Ordertable;
import mapper.ISqlMapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface OrderTableMapper extends ISqlMapper<Ordertable> {
    @Select("select ordernumber from ordertable where ordernumber in(select   distinct ordernumber  from ordertabledetail where userid=#{userid});")
    public List<String> getordernumber(Integer userid);
}
