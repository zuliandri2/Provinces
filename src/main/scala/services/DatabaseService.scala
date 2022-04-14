package zul.province.app
package services

import akka.actor.ActorSystem
import play.api.db.Database
import play.api.libs.concurrent.CustomExecutionContext

import javax.inject.{Inject, Singleton}
import scala.concurrent.ExecutionContext

class DatabaseService @Inject()(db: Database, executionContext: DatabaseExecutionContext) {
  
}

trait DatabaseExecutionContext extends ExecutionContext

@Singleton
class DatabaseExecutionContextImp @Inject() ( system: ActorSystem ) extends CustomExecutionContext ( system, "database.dispatcher") with DatabaseExecutionContext
