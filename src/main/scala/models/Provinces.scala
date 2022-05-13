package models

import play.api.db.slick.{DatabaseConfigProvider, HasDatabaseConfig, HasDatabaseConfigProvider, NamedDatabaseConfigProvider}
import slick.jdbc.{GetResult, JdbcProfile}

import java.sql.Date
import slick.basic.{BasicProfile, DatabaseConfig}

import scala.concurrent.Future

trait ProvinceProfile {
//  val profile: JdbcProfile
}

trait ProvinceDatabase extends HasDatabaseConfig[JdbcProfile] with ProvinceProfile {
  override protected val dbConfig = DatabaseConfig.forConfig("slick.dbs.default")
}

case class Province(id: Option[Int], name: String, description: String, updated: Option[Date] = None, deleted: Option[Date] = None, created: Option[Date] = None)

trait ProvinceComponent extends ProvinceDatabase {
  import profile.api._

  implicit val getProvincesResult = GetResult(r => Province(Some(r.nextInt()), r.nextString(), r.nextString(), r.nextDateOption(), r.nextDateOption(), r.nextDateOption()))

  class ProvinceTable(tag: Tag) extends Table[Province](tag, "provinces") {
    def id = column[Int]("id", O.PrimaryKey, O.Unique, O.SqlType("SERIAL"))
    def name = column[String]("name")
    def description = column[String]("description", O.Default(""))
    def updated = column[Option[Date]]("updated")
    def deleted = column[Option[Date]]("deleted")
    def created = column[Option[Date]]("created")
    def * = (id.?, name, description, updated, deleted, created).mapTo[Province]
  }

  protected lazy val provinceTableQuery = TableQuery[ProvinceTable]

}

object ProvinceDAO extends ProvinceComponent {

  import profile.api._
  import services.Executor._

  def insert(province: Province) = for {
      a <- Future { province.copy(created = Some(new Date(System.currentTimeMillis()))) }
      p <- Future { provinceTableQuery += a }
      u <- db.run(p)
    } yield u

  def findById(id: Int) = for {
    f <- Future { provinceTableQuery.filter(p => p.id === id).result }
    l <- db.run(f)
  } yield l

  def findById(id: List[Int]) = for {
    f <- Future { provinceTableQuery.filter(p => p.id inSet id ).result }
    l <- db.run(f)
  } yield l

  def delete(id: Int) = for {
    f <- Future { provinceTableQuery.filter(p => p.id === id).delete }
    r <- db.run(f)
  } yield r

  def delete(id: List[Int]) = for {
    f <- Future { provinceTableQuery.filter(p => p.id inSet id).delete }
    r <- db.run(f)
  } yield r

  def softDelete(id: List[Int]) = for {
    f <- Future { provinceTableQuery.filter(p => p.id inSet id).map(p => (p.deleted)).update(Some(new Date(System.currentTimeMillis()))) }
    r <- db.run(f)
  } yield r

}