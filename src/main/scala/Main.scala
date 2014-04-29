/**
 * User: chuluan.ll
 * Date: 14-4-7
 * Time: 上午9:31
 */

import dispatch._, Defaults._
import scala.collection.mutable

object Main extends App {

  val queue = new mutable.Queue[String]()
  var depth = 0;
  queue.enqueue("http://www.163.com/")
  while (queue.size > 0) {
    try {
      val urlStr = queue.dequeue();
      val result = Http(url(urlStr) OK MyString).either
      for (c <- result.right) {
        MongoConnection.writeDocument(urlStr, c)
        extractUrl(c)
      }
      while (queue.size == 0) {
        println("我睡了")
        Thread.sleep(1000)
      }
    }catch{
      case e:Exception => e.printStackTrace()
    }
  }
  println("exiext")


  def extractUrl(content: String) = {
    val pattern = "href=\"(.+?)\"".r
    pattern.findAllIn(content).matchData.foreach(c => {
      queue.enqueue(c.group(1))
    }
    )
  }
}

