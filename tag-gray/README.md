+ 启动Server1-service * 1台，模拟TestApp1    
+ 启动Server2-service * 1台，模拟TestApp2    
+ 启动Server3-service * 3台，模拟TestApp3  
+ 启动Server1-client测试用例，观察结果  
`此时Server1-client没有标记Tag`    
+ 关闭其中一台Server3-service，修改/service/src/main/resources/kepler.conf  
	`com.kepler.host.host.tag=kepler`  
+ 重新启动该台Server3-service
`此时含2台为标记服务与1台已标记服务`  
+ 修改Server1-client，/client/src/test/resources/kepler.conf  
	`com.kepler.host.host.tag=kepler`
+ 启动Server1-client测试用例，观察结果   
`此时Server1-client已经标记Tag`  

