package zul.province.app

import org.scalatestplus.play.PlaySpec
import play.api.db.Databases
import slick.lifted.{Executable, TableQuery}
import zio.{IO, Runtime, UIO, ZIO, console}
import zul.province.app.models.Provinces
import zul.province.app.models.Provinces.{Province, ProvincesModel}
import zul.province.app.services.ProvincesServices.ProvinciesServices
import ZIO._

import java.sql.Date
import zio.console._

class PostgrePlayTest extends PlaySpec {

  /*"Connection Database" must {
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
  }*/

  "Insrt data" must {
    "should be insert" in {
      /*val p = Province(Some(2), "Zuliandri", "Hello Zuliandri", created = Some(new Date(System.currentTimeMillis())))
      ProvinciesServices.create(Provinces.insert(p))*/
      val suk = Runtime.default.unsafeRun(ZIO.succeed(42))
      println(suk)
    }
  }

}
