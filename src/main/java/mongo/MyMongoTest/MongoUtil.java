package mongo.MyMongoTest;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.bson.Document;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoIterable;
import com.mongodb.util.JSON;



public class MongoUtil {
	 private static final Logger LOG = Logger.getLogger(MongoUtil.class);
	
	 private static String hostName = "127.0.0.1"; 
	 private static String dbName = "mytest";
	 private static String userName = "mytest";
	 private static String passWord = "123456";
	 
	 
	 private MongoClient[] mongoClient = new MongoClient[1];
	 private MongoDatabase[] db = new MongoDatabase[1];
	 
	{
		MongoClientOptions.Builder build = new MongoClientOptions.Builder();
		build.connectionsPerHost(50);
		build.threadsAllowedToBlockForConnectionMultiplier(10);
		build.maxWaitTime(1000 * 60 * 2);
		build.connectTimeout(1000 * 30);
		build.socketTimeout(1000 * 5);

	 	List<ServerAddress> seeds = new ArrayList<ServerAddress>(); 
	 	seeds.add(new ServerAddress(hostName)); 	
        MongoCredential credentials = MongoCredential.createScramSha1Credential(userName, dbName, passWord.toCharArray());
        List<MongoCredential> credentialsList = new ArrayList<MongoCredential>();
        credentialsList.add(credentials);
        mongoClient[0] = new MongoClient(seeds, credentialsList, build.build());
        db[0] = mongoClient[0].getDatabase(dbName);
        MongoIterable<String>  collections = db[0].listCollectionNames(); 
        
//        collections.forEach(System.out::println);
        LOG.debug("connection to data: " + collections.first());
	}
	
	public void find(){
		LOG.debug("find");
	}
}
