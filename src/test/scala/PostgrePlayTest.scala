import models.{Province, ProvinceDAO}
import org.scalatestplus.play.PlaySpec

import java.sql.Date
import scala.util.{Failure, Success}

class PostgrePlayTest extends PlaySpec {

  /*"delete data" must {
    "data should be empty" in {
      import services.Executor._
      ProvinceDAO.delete(List(1,2,3,4,5))
    }
  }*/

  "insert data" must {
    "data should'nt be empty" in {
      import services.Executor._
      val p = Province(Some(1), "Zuliandri", "Welcome Zuliandri", created = Some(new Date(System.currentTimeMillis())))
      ProvinceDAO.insert(p).onComplete {
        case Success(value) => println("success")
        case Failure(exception) => exception.printStackTrace()
      }
      ProvinceDAO.insert(p.copy(Some(2), "Andri", "Welcome Andri", created = Some(new Date(System.currentTimeMillis()))))onComplete {
        case Success(value) => println("success 1")
        case Failure(exception) => exception.printStackTrace()
      }
    }
  }

  "soft delete data" must {
    "data should be updated" in {
      import services.Executor._
      ProvinceDAO.softDelete(List(2))onComplete {
        case Success(value) => println("success 3")
        case Failure(exception) => exception.printStackTrace()
      }
    }
  }

}
