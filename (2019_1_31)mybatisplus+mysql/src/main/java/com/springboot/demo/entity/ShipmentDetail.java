package com.springboot.demo.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import org.springframework.stereotype.Component;

@Component
@TableName("shipment_detail")
public class ShipmentDetail{
    @TableId(value = "id")
    Integer id;

    @TableField(value = "itemCode",exist = true)
    String itemCode;

    public ShipmentDetail(){

    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    @Override
    public String toString() {
        return "ShipmentDetail{" +
                "id=" + id +
                ", itemCode='" + itemCode + '\'' +
                '}';
    }
}
