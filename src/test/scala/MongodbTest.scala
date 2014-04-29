import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.{Matchers, FlatSpec}

/**
 * User: chuluan.ll
 * Date: 14-4-22
 * Time: 下午4:40
 */
@RunWith(classOf[JUnitRunner])
class MongodbTest extends FlatSpec with Matchers {

  "a mongodb client" should "write a record " in {
    MongoConnection.writeDocument("http://www.163.com", "ni hao  wo shi 163") should be >= 1

  }

}
