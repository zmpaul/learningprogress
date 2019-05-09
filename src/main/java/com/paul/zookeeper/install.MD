# zookeeper

## 安装
###### 下载：wget http://mirror.bit.edu.cn/apache/zookeeper/zookeeper-3.5.4-beta/zookeeper-3.5.4-beta.tar.gz

###### 解压tar -zxvf zookeeper-3.5.4-beta.tar.gz 

######  cd zookeeper/conf    cp zoo_sample.cfg zoo.cfg
在使用过程中，出现，注册上的client端到达一定数量，会出现服务不可用。注意maxClientCnxns参数
$\color{red}{maxClientCnxns=300}$

##### cd zookeeper/bin 服务相关命令
1. 启动ZK服务:       bin/zkServer.sh start
指定文件启动服务    zkServer.sh start ../conf/zoo.cfg 
2. 查看ZK服务状态:  bin/zkServer.sh status 
3. 停止ZK服务:       bin/zkServer.sh stop
4. 重启ZK服务:       bin/zkServer.sh restart

##### 客户端 相关命令
进入/bin/zkCli.sh -server [ip]:[port]

##### 单机伪集群
1.zookeeper/conf 生成多个zoo1.conf zoo2.conf zoo3.conf
2.分别在各自的dataDir 目录新增myid 分别写1 2 3对应下列的server.*
3.各自起服务 zkServer.sh start zoo1.conf 查看status 一个leader 多个follower。

dataDir =/opt/zookeeper/zk1
dataLogDir=/opt/zookeeper/zk1/logs
server.1=127.0.0.1:2888:3888
server.2=127.0.0.1:4888:5888
server.3=127.0.0.1:6888:7888








