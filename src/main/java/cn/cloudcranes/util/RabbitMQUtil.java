package cn.cloudcranes.util;

import cn.hutool.core.net.NetUtil;

import javax.swing.*;

/**
 * 连接测试类
 * 检验RabbitMQ服务是否启动
 */
public class RabbitMQUtil {

    public static void main(String[] args) {
        checkServer();
    }

    public static void checkServer() {

        if (NetUtil.isUsableLocalPort(15672)) {
            JOptionPane.showMessageDialog(null, "RabbitMQ 服务器未启动 ");
            System.exit(1);
        } else {
            System.out.println("启动成功");
        }

    }
}
