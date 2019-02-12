package com.springboot.demo.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.springboot.demo.entity.ShipmentDetail;
import com.springboot.demo.mapper.ShipmentDetailMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.atomic.AtomicBoolean;

@Service
public class ShipmentDetailService {
    @Autowired
    ShipmentDetailMapper mapper;

    public String getItmeCodeByItemCode(String name){
        //System.out.println(mapper.selectById("5").getItemCode());
        LambdaQueryWrapper<ShipmentDetail> wrapper = new LambdaQueryWrapper<>();
        String shipmentDetail = mapper.getItemCodeByItemCode(wrapper.eq(ShipmentDetail::getItemCode,name).last("limit 1"));
//        ShipmentDetail shipmentDetail = mapper.selectOne(wrapper.select(ShipmentDetail::getId,ShipmentDetail::getItemCode).eq(ShipmentDetail::getId,5));
        System.out.println(shipmentDetail);
        return shipmentDetail;
    }

}
