import com.mongodb.casbah.commons.MongoDBObject
import com.mongodb.casbah.MongoClient
import com.mongodb.{BasicDBObject, DBObject}
import java.util.Date

/**
 * User: chuluan.ll
 * Date: 14-4-10
 * Time: 下午4:30
 */
object MongoConnection {

  val client = MongoClient("127.0.0.1", 27017)
  val db = client("test")


  def writeDocument(url: String, contend: String):Int=  {
      db("webContest").insert(MongoDBObject("url" -> url, "contend" -> contend, "createTime" -> new Date()))
      findRecord
  }

  def findRecord={
   val  query = new BasicDBObject()
    query.put("url","http://www.163.com")
    db("webContest").find(query).count()
  }
}
