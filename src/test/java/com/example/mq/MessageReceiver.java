package com.example.mq;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author huangbiaof
 * @data 创建时间：2019/7/18 13:03
 */

public class MessageReceiver {


    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();

        factory.setHost("192.168.5.101");
        factory.setPort(5672);
        factory.setUsername("mall");
        factory.setPassword("mall");
        Connection connection = factory.newConnection();

        Channel channel = connection.createChannel();

        channel.queueDeclare("hello", false, false, false, null);

        System.out.println("receiver message");

        Consumer consumer = new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                String message = new String(body, "UTF-8");
                System.out.println("receiver this " + message);
            }
        };

        channel.basicConsume("hello", true, consumer);
    }
}
