import org.apache.spark.sql.SparkSession

object Sample {

  def main(args: Array[String]): Unit = {
    println("Hello World")

    val spark = SparkSession
      .builder()
      .master("local")
      .appName("LeetCode Database Problem Set for Spark")
      .getOrCreate()

    val tableDF = spark.read.format("csv")
      .options(Map(
        "header" -> "true",
        "inferSchema" -> "true"
      ))
      .load("./src/main/resources/big-problems/table.csv")

    tableDF.show()
    tableDF.printSchema()

  }
}
