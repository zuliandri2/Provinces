package zul.province.app

import org.scalatestplus.play.PlaySpec
import play.api.db.Databases

class PostgrePlayTest extends PlaySpec {

  "Connection Database" must {
    "should be conect" in {
      val db = Databases(
        driver = "org.postgresql.Driver",
        url = "jdbc:postgresql://localhost:5432/provinces",
        config = Map(
          "username" -> "postgres",
          "password" -> "root"
        )
      )
      val connection = db.getConnection()
      println(connection.getClientInfo)
      db.shutdown()
    }
  }

}
