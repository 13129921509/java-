package com.springboot.demo.test;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.springboot.demo.entity.ShipmentDetail;
import com.springboot.demo.mapper.ShipmentDetailMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class Test1 {
    @Autowired
    ShipmentDetailMapper mapper;

    @Autowired
    ShipmentDetail shipmentDetail;
    @Test
    public void test(){
        //System.out.println(mapper.selectById("5").getItemCode());
        LambdaQueryWrapper<ShipmentDetail> wrapper = new LambdaQueryWrapper<>();
        String shipmentDetail = mapper.getItemCodeByItemCode(wrapper.eq(ShipmentDetail::getItemCode,"NRHF04CP929360"));
//        ShipmentDetail shipmentDetail = mapper.selectOne(wrapper.select(ShipmentDetail::getId,ShipmentDetail::getItemCode).eq(ShipmentDetail::getId,5));
        System.out.println(shipmentDetail);
    }
}
