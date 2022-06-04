package com.centaurcomputing
import org.apache.log4j._
import org.apache.spark.sql.{Encoders, SparkSession}

object amazonReviews {


  def main(args: Array[String]) {

    //HYPOTHESIS:
    // 1. Longer Music Reviews Tend To Be Positive
    // 2. Reviewers who write longer reviews write more negative reviews

    //APPROACH:
    // 1. (Simple) Rate the sentiment of the review by the star rating
    // 2. (Complex) Rate the sentiment of the reviews by NLP

    val spark = SparkSession
      .builder
      .appName("AmazonReviews")
      .master("local[*]")
      .getOrCreate()

    val path: String = "data/reviews_CDs_and_Vinyl_5.json"
    val reviews = spark.read
      .json(path)
      //.printSchema()
//    |-- asin: string (nullable = true)
//    |-- helpful: array (nullable = true)
//    |    |-- element: long (containsNull = true)
//    |-- overall: double (nullable = true)
//    |-- reviewText: string (nullable = true)
//    |-- reviewTime: string (nullable = true)
//    |-- reviewerID: string (nullable = true)
//    |-- reviewerName: string (nullable = true)
//    |-- summary: string (nullable = true)
//    |-- unixReviewTime: long (nullable = true)
    spark.sqlContext.sql("CREATE TEMPORARY VIEW musicReviews USING json OPTIONS" +
      " (path 'data/reviews_CDs_and_Vinyl_5.json')")
      val distinctReviewers = spark.sql("SELECT reviewerID,reviewCount" +
        " FROM (SELECT reviewerID, COUNT(reviewText) reviewCount from musicReviews GROUP BY reviewerID) WHERE reviewCount > 100 ")
          distinctReviewers.show()



    val topReveiwers = distinctReviewers.filter(distinctReviewers("reviewCount") > 1000).count()
    println("Number of Top Reviewers: " + topReveiwers)
    spark.stop()
  }}
