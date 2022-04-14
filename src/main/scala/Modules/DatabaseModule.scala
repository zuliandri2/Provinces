package zul.province.app
package Modules

import com.google.inject.AbstractModule
import zul.province.app.services.{DatabaseExecutionContext, DatabaseExecutionContextImp}

class DatabaseModule extends AbstractModule {
  override def configure(): Unit = {
    bind(classOf[DatabaseExecutionContext]).to(classOf[DatabaseExecutionContextImp]).asEagerSingleton()
  }
}
