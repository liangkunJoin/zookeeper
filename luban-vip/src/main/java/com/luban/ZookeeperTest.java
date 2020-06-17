package com.luban;

import org.apache.zookeeper.*;

public class ZookeeperTest {

    public static void main(String[] args) throws Exception {

        try (ZooKeeper client =
                     new ZooKeeper("localhost:2181",
                             10000, event -> System.out.println("默认的watch:" + event.getType()), false)) {

            client.create("/luban", "lb".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);

            System.out.println(new String(client.getData("/luban", true, null)) + "==========");
        }
    }
}
