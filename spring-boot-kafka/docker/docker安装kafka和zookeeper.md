## 1. 下载镜像

```
docker pull wurstmeister/zookeeper  
docker pull wurstmeister/kafka
```
## 2. 启动zookeeper容器

```
docker run -d --name zookeeper -p 2181:2181 -t wurstmeister/zookeeper
```
## 3. 启动kafka容器

```
docker run  -d --name kafka -p 9092:9092 -e KAFKA_BROKER_ID=0 -e KAFKA_ZOOKEEPER_CONNECT=192.168.1.100:2181 -e KAFKA_ADVERTISED_LISTENERS=PLAINTEXT://192.168.1.100:9092 -e KAFKA_LISTENERS=PLAINTEXT://0.0.0.0:9092 -t wurstmeister/kafka
```
这里面主要设置了4个参数：
- KAFKA_BROKER_ID=0
- KAFKA_ZOOKEEPER_CONNECT=192.168.1.100:2181   // 192.168.1.100 换成宿主机器的IP地址
- KAFKA_ADVERTISED_LISTENERS=PLAINTEXT://192.168.1.100:9092  // 192.168.1.100 换成宿主机器的IP地址
- KAFKA_LISTENERS=PLAINTEXT://0.0.0.0:9092

https://juejin.im/entry/6844903829624848398