+ 启动Service，启动Client  
+ @See[<a href="https://github.com/Kepler-Framework/Kepler-All/wiki/%E7%89%B9%E6%80%A7-%E5%AE%89%E5%85%A8%E5%85%B3%E9%97%AD">安全关闭</a>]Service
+ 观察Log，此时服务将立即关闭并终止正在执行的请求  
+ 启动Service，开启com.kepler.thread.ThreadFactory.shutdown_wait，启动Client
+ @See[<a href="https://github.com/Kepler-Framework/Kepler-All/wiki/%E7%89%B9%E6%80%A7-%E5%AE%89%E5%85%A8%E5%85%B3%E9%97%AD">安全关闭</a>]Service  
+ 观察Log，此时服务将等待线程直到请求执行完成后关闭   
