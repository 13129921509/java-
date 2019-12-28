package com.cai.chatroom.base;

public interface BeforeAndAfterOperation<T1> {

    default void beforeCreate() {

    }

    default void afterCreate() {

    }

    default void afterSend(T1 t) {

    }


    default void cache(T1 t1){

    }
}
