package services

import slick.jdbc.JdbcProfile

object DatabaseService {

  def exec[T](block: JdbcProfile#Backend#Database => T) = {
    try {
//      block(db)
    } catch {
      case e: Exception => e.printStackTrace
    }
  }

}