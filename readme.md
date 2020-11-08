根据[How2J]学习

[How2J]: https://how2j.cn/k/message/message-rabbitmq/2029.html	"RabbitMQ学习"

##### 需要如下依赖 jar包(pom.xml)

```xml
 	<dependency>
            <groupId>com.rabbitmq</groupId>
            <artifactId>amqp-client</artifactId>
            <version>5.4.3</version>
        </dependency>
        <dependency>
            <groupId>cn.hutool</groupId>
            <artifactId>hutool-all</artifactId>
            <version>4.5.7</version>
        </dependency>
```

##### RabbitMQ模式

```markdown
消息路由过程：
Rabbit 拿到消息之后，会先交给 交换机 （Exchange）, 然后交换机再根据预先设定的不同绑定( Bindings )策略，来确定要发给哪个队列。
```



##### RabbitMQ四种Exchange模式：

|     模式名称     | 模式详解                                                     |                         图解                          |
| :--------------: | :----------------------------------------------------------- | :---------------------------------------------------: |
| fanout：广播模式 | 消息来了，会发给所有的队列                                   | ![fanout 模式](https://stepimagewm.how2j.cn/9237.png) |
| direct：队列模式 | Direct 模式就是指定队列模式， 消息来了，只发给指定的 Queue, 其他Queue 都收不到。 | ![Direct 模式](https://stepimagewm.how2j.cn/9238.png) |
| topic：主题模式  | 任何发送到Topic Exchange的消息都会被转发到所有关心RouteKey中指定话题的Queue上 | ![Topic 模式](https://stepimagewm.how2j.cn/9239.png)  |
|      header      | headers类型的Exchange不依赖于routing key与binding key的匹配规则来路由消息，而是根据发送的消息内容中的headers属性进行匹配 |                                                       |

可参考[rabbitmq 几种应用模式解释]这篇博客

[rabbitmq 几种应用模式解释]: https://my.oschina.net/uwith/blog/3018649	"RabbitMQ几种应用模式解释"

 

###### **性能排序：fanout > direct >> topic。比例大约为11：10：6**

