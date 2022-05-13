package Modules

import com.google.inject.AbstractModule
import services.CustomExecutionContextService.{DatabaseExecutionContext, DatabaseExecutionContextImp}

class DatabaseModule extends AbstractModule {
  override def configure(): Unit = {
    bind(classOf[DatabaseExecutionContext]).to(classOf[DatabaseExecutionContextImp]).asEagerSingleton()
  }
}
