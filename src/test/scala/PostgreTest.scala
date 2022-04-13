package zul.province.app

import org.scalatest.funsuite.AnyFunSuite
import slick.dbio.DBIOAction
import slick.jdbc.H2Profile.api._
import zul.province.app.models.Provinces.{Province, provincesTable}

import scala.concurrent.ExecutionContext.Implicits.global
import java.sql.{Date, Timestamp}
import java.util.Calendar
import scala.util.{Failure, Success}

class PostgreTest extends AnyFunSuite {

  /**
   * database config
   */
  val db = Database.forConfig("mydb")

  /**
   * create schema
   */
  test("Create schema") {
    val createSchema = DBIO.seq(
      provincesTable.schema.dropIfExists,
      provincesTable.schema.createIfNotExists,
    )
    val f = db.run(createSchema)
    f.onComplete {
      case Success(v) => {
        println("schema created")
      }
      case Failure(t) => {
        t.printStackTrace
      }
    }
  }

  /**
   * insert
   */
  test("Insert") {
    val insert = provincesTable += Province(Some(1), "Zuliandri", "Hello Zuliandri", created = Option(new Date(System.currentTimeMillis())))
    val f = db.run(insert)
    f.onComplete {
      case Success(v) => {
        println("inserted")
      }
      case Failure(t) => {
        t.printStackTrace
      }
    }
  }

  /**
   * selected
   */
  test("Selected") {
    val select = provincesTable.result
    val f = db.run(select)
    f.onComplete {
      case Success(v) => {
        v.foreach(println)
      }
      case Failure(t) => {
        t.printStackTrace
      }
    }
  }

  /**
   * selected by filter or where
   */
  test("Selected by filter or where") {
    val select = provincesTable.filter(_.id === 1).result
    val f = db.run(select)
    f.onComplete {
      case Success(v) => {
        v.foreach(println)
      }
      case Failure(t) => {
        t.printStackTrace
      }
    }
  }

  /**
   * update column
   */
  test("Updated column") {
    val q = for { b <- provincesTable.filter(_.id === 1) } yield (b.name, b.description, b.updated)
    val updateAction = q.update(("Andri", "Hello Andri", Option(new Date(System.currentTimeMillis()))))
    val f = db.run(updateAction)
    f.onComplete {
      case Success(v) => {
        println("updated")
      }
      case Failure(t) => {
        t.printStackTrace
      }
    }
  }

  /**
   * soft delete column
   */
  test("soft deleted") {
    val softDeleted = for { b <- provincesTable.filter(_.id === 1) } yield  b.deleted
    val updateSoftDelete = softDeleted.update(Option(new Date(System.currentTimeMillis())))
    val f = db.run(updateSoftDelete)
    f.onComplete {
      case Success(v) => {
        println("soft deleted")
      }
      case Failure(t) => {
        t.printStackTrace
      }
    }
  }

  /**
   * deleted
   */
  test("deleted") {
    val queryDelete = provincesTable.filter(_.id === 1).delete
    val f = db.run(queryDelete)
    f.onComplete {
      case Success(v) => {
        println("deleted")
      }
      case Failure(t) => {
        t.printStackTrace
      }
    }
  }
}