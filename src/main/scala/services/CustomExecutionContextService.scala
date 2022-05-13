package services

import akka.actor.ActorSystem
import play.api.libs.concurrent.CustomExecutionContext
import services.CustomExecutionContextService.DatabaseExecutionContext

import javax.inject.{Inject, Singleton}
import scala.concurrent.ExecutionContext

object CustomExecutionContextService {

  trait DatabaseExecutionContext extends ExecutionContext

  @Singleton
  class DatabaseExecutionContextImp @Inject() (system: ActorSystem) extends CustomExecutionContext ( system, "database.dispatcher") with DatabaseExecutionContext

}

object Executor {

  implicit val globalEx: ExecutionContext = scala.concurrent.ExecutionContext.Implicits.global

  object DatabasExecutor {
    implicit val databaseEc: DatabaseExecutionContext = new DatabaseExecutionContext {
      override def execute(runnable: Runnable): Unit = globalEx.execute(runnable)

      override def reportFailure(cause: Throwable): Unit = globalEx.reportFailure(cause)
    }
  }

}
