package com.service;

import com.mapper.AddressMapper;
import com.po.Address;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AddressService {
    @Resource
    AddressMapper addressMapper;

    public List<Address> getAddress(Integer userid) {

       return addressMapper.getEntities(new Address(null,null,userid,null));
    }

    public Address getAdd(Integer addressid) {

        return  addressMapper.getEntity(new Address(addressid,null,null,null));
    }
}
