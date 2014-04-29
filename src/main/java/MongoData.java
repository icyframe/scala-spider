import com.mongodb.*;

import java.net.UnknownHostException;

/**
 * User: chuluan.ll
 * Date: 14-4-10
 * Time: 上午10:35
 */
public class MongoData {
    public static void main(String[] args) {
        try {
            MongoClient mongoClient = new MongoClient("10.13.4.101", 3000);
            DB db = mongoClient.getDB("datasource");
            DBCollection device= db.getCollection("device");
            DBCollection invalid_device = db.getCollection("INVALID_DEVICE");
            DBCursor cursor =invalid_device.find().addOption(Bytes.QUERYOPTION_NOTIMEOUT);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
