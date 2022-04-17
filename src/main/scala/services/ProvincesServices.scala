package zul.province.app
package services

import scala.concurrent.ExecutionContext.Implicits.global
import play.api.{Configuration, Environment}
import play.api.inject.Binding

import scala.util.{Failure, Success}
import slick.jdbc.H2Profile.api._
import slick.sql.FixedSqlAction
import zio.{Task, ZIO, ZLayer}
import zul.province.app.models.Provinces.ProvincesModel

object ProvincesServices {

  trait ProvinciesServices {
    type A
    def create(a: A): Unit
    def softDelete(): Int
    def delete(): Int
    def update(): Int
  }

  object ProvinciesServices extends ProvinciesServices {
    override type A = FixedSqlAction[Int, NoStream, Nothing]

    val db = ZIO

    override def create(io: A) = {
      /*val layer = ZLayer.fromEffect(io)*/
      /*DatabaseService.exec { config =>
        /*val f = ZIO.fromFuture {
          config.db.run(io).
        }*/
      }*/
    }

    override def delete(): Int = ???
    override def softDelete(): Int = ???
    override def update(): Int = ???
  }

  class ProvinceApp extends play.api.inject.Module {
    override def bindings(environment: Environment, configuration: Configuration): collection.Seq[Binding[_]] = Seq(bind[ProvinciesServices].to(ProvinciesServices))
  }

}
