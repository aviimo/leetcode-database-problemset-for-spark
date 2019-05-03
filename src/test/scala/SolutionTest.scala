import org.apache.spark.sql.SparkSession
import org.scalatest.{BeforeAndAfter, FunSuite}

class SolutionTest extends FunSuite with BeforeAndAfter{

  var spark: SparkSession = _

  before{
    spark = SparkSession
      .builder()
      .master("local")
      .appName("SolutionTest")
      .getOrCreate()
  }

  test("Big Countries"){
    val tableDF = spark.read.format("csv")
      .options(Map(
        "header" -> "true",
        "inferSchema" -> "true"
      ))
      .load("./src/main/resources/big-problems/table.csv")

    val result = Solution.solve(spark, tableDF)
  }

  after{
    spark.stop()
  }

}
