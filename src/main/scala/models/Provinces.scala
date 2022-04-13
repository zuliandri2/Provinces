package zul.province.app
package models

import slick.jdbc.GetResult
import slick.jdbc.H2Profile.api._
import java.sql.Date

object Provinces {

  implicit val getProvincesResult = GetResult(r => Province(Some(r.nextInt()), r.nextString(), r.nextString(), r.nextDateOption(), r.nextDateOption(), r.nextDateOption()))

  case class Province(id: Option[Int], name: String, description: String, updated: Option[Date] = None, deleted: Option[Date] = None, created: Option[Date] = None)

  class ProvincesModel(tag: Tag) extends Table[Province](tag, "provinces") {
    def id = column[Int]("id", O.PrimaryKey, O.Unique, O.SqlType("SERIAL"))
    def name = column[String]("name")
    def description = column[String]("description", O.Default(""))
    def updated = column[Option[Date]]("updated")
    def deleted = column[Option[Date]]("deleted")
    def created = column[Option[Date]]("created")
    def * = (id.?, name, description, updated, deleted, created).mapTo[Province]
  }

  lazy val provincesTable = TableQuery[ProvincesModel]
}
