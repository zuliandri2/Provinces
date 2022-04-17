package zul.province.app
package services

import akka.actor.ActorSystem
import play.api.db.slick.HasDatabaseConfig
import play.api.libs.concurrent.CustomExecutionContext
import slick.basic.DatabaseConfig
import slick.jdbc.JdbcProfile

import javax.inject.{Inject, Singleton}
import scala.concurrent.ExecutionContext

object DatabaseService extends HasDatabaseConfig[JdbcProfile] {
  override protected val dbConfig = DatabaseConfig.forConfig("slick.dbs.default")

  def exec[T](block: DatabaseConfig[JdbcProfile] => T) = {
    block(dbConfig)
  }
}

trait DatabaseExecutionContext extends ExecutionContext

@Singleton
class DatabaseExecutionContextImp @Inject() ( system: ActorSystem ) extends CustomExecutionContext ( system, "database.dispatcher") with DatabaseExecutionContext
