package com.springboot.demo.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.springboot.demo.entity.ShipmentDetail;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

@Component
public interface ShipmentDetailMapper extends BaseMapper<ShipmentDetail> {

    @Select("select itemCode from shipment_detail ${ew.customSqlSegment}")
    String getItemCodeByItemCode(@Param(Constants.WRAPPER) Wrapper<ShipmentDetail> wrapper);
}
