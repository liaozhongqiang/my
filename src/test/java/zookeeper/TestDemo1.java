package zookeeper;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import org.apache.commons.lang3.StringUtils;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooDefs.Ids;
import org.apache.zookeeper.ZooKeeper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestDemo1 {
	
	private static final Logger logger=LoggerFactory.getLogger(TestDemo1.class);
	
	public static void main(String[] args) throws IOException, KeeperException, InterruptedException {
		ZooKeeper zk=new ZooKeeper("127.0.0.1:2181", 5000, new Watcher(){
			@Override
			public void process(WatchedEvent event) {
				logger.info("Event:{}",event.getType());
			}
		});
		logger.info("ZooKeeper的根节点:{}",zk.getChildren("/", true));
		if(zk.exists("/node", true)==null){
			zk.create("/node", "node 节点的数据".getBytes(), Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
		}else{
			logger.info("ZooKeeper /node节点的数据为:{}",StringUtils.toEncodedString(zk.getData("/node", true, null), StandardCharsets.UTF_8));
		}
		zk.close();
	}

}
