package com.luban;

import org.apache.zookeeper.*;

import java.util.concurrent.CountDownLatch;

public class ZookeeperTest {

    public static void main(String[] args) throws Exception {

        CountDownLatch connectedSemaphore = new CountDownLatch(1);

        try (ZooKeeper client =
                     new ZooKeeper("localhost:2182", 10000,
                             event -> connectedSemaphore.countDown(), false)) {

            connectedSemaphore.await();

            client.create("/luban", "lb".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);

            System.out.println(new String(client.getData("/luban", true, null)) + "==========");
        }
    }
}
