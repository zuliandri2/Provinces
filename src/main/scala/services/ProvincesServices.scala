package zul.province.app
package services

import models.Provinces.Province

import play.api.{Configuration, Environment}
import play.api.inject.Binding
import slick.dbio.DBIOAction

object ProvincesServices {

  trait ProvinciesServices {
    def create(): Boolean
    def softDelete(): Int
    def delete(): Int
    def update(): Int
  }

  object ProvinciesServices extends ProvinciesServices {
    override def create(): Boolean = ???
    override def delete(): Int = ???
    override def softDelete(): Int = ???
    override def update(): Int = ???
  }

  class ProvinceApp extends play.api.inject.Module {
    override def bindings(environment: Environment, configuration: Configuration): collection.Seq[Binding[_]] = Seq(bind[ProvinciesServices].to(ProvinciesServices))
  }

}
