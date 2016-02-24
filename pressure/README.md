
+ Server  
  + Server启动入口：`main.Server`
  + Server启动参数：`输入1，启动Dubbo服务。输入2，启动Kepler服务`
  + Server JVM参数(推荐)：-server -Xmx1G -Xms1G -XX:+PrintGCDetails  
+ Client
  + Client启动入口：`main.Client`
  + Client启动参数：
    + `输入 1 500 10 50000 表示使用Dubbo客户端，报文大小为500K，开启10个线程测试50000次`
  + Client JVM参数(推荐)：-server -Xmx1G -Xms1G -XX:+PrintGCDetails  
+ `测试时保持环境一致，关闭其他可能干扰测试结果的进程，关闭Log4j
