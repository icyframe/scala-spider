/**
 * User: chuluan.ll
 * Date: 14-4-9
 * Time: 下午11:53
 */

import com.ning.http.client

object MyString extends (client.Response => String) {
  def apply(r: client.Response) = {
//    val reg = "charset=(.*)".r
//    reg.findPrefix1MatchOf()
    if(r.getResponseBody.contains("utf-8") || r.getResponseBody.contains("UTF-8"))
      r.getResponseBody("utf-8")
    else
    r.getResponseBody("gbk")
  }
}
