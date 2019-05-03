import org.apache.spark.sql.{DataFrame, SparkSession}

object Solution {

  def solve(spark: SparkSession, worldDF: DataFrame): DataFrame ={

    import spark.implicits._

    // Write solution here

    val result = worldDF.filter($"area">3000000 || $"population">25000000)

    return result
  }

}
