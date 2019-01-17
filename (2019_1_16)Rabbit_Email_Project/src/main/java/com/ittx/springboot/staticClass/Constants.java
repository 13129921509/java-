package com.ittx.springboot.staticClass;

public class Constants {
    /**
     * 消息队列交换机名称
     */
    public static final String PERSON_TOPIC_EXCHANGE_NAME = "rabbit_mq_topic_exchange_name";
    /**
     * 消息队列-注册用户-队列名称
     */
    public static final String PERSON_TOPIC_REGISTER_QUEUE_NAME = "rabbit_mq_person_register_queue_name";
    /**
     * 消息队列-注册用户-队列路由键
     */
    public static final String PERSON_TOPIC_REGISTER_QUEUE_ROUTE_KEY = "register.*";

    /**
     * 消息队列-发送邮件-队列名称
     */
    public static final String PERSON_TOPIC_SEND_EMAIL_QUEUE_NAME = "rabbit_person_send_mail_queue_name";

    /**
     * 消息队列-发送邮件-队列路由键
     */
    public static final String PERSON_TOPIC_SEND_EMAIL_QUEUE_ROUTE_KEY = "register.#";

    /**
     * 消息队列-TOPIC交换机-路由KEY
     */
    public static final String PERSON_TOPIC_EXCHANGE_ROUTE_KEY = "register.member";

    /**
     * 邮件文本类型 - HTML
     */
    public static final String SEND_MAIL_HTML_TYPE = "text/html;charset=UTF-8";
    /**
     * 邮件文本类型 - TEXT
     */
    public static final String SEND_MAIL_TEXT_TYPE = "text";
}
