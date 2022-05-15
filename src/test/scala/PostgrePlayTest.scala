import models.{Province, ProvinceDAO}
import org.scalatestplus.play.PlaySpec

import java.sql.Date

class PostgrePlayTest extends PlaySpec {

  "delete data" must {
    "data should be true" in {
      import services.Executor._
      ProvinceDAO.delete(List(3, 4))
    }
  }

  "insert data" must {
    "data should'nt be empty" in {
      import services.Executor._
      val p = Province(Some(1), "Zuliandri", "Welcome Zuliandri", created = Some(new Date(System.currentTimeMillis())))
      ProvinceDAO.insert(p)
      ProvinceDAO.insert(p.copy(Some(2), "Andri", "Welcome Andri", created = Some(new Date(System.currentTimeMillis()))))
    }
  }

  "soft delete data" must {
    "data should be updated" in {
      import services.Executor._
      ProvinceDAO.softDelete(List(2))
    }
  }

}
