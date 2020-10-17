package WordCount

import org.apache.spark.SparkContext
import org.apache.spark.SparkContext._
import org.apache.spark.SparkConf


object WordCount {
  def main(args: Array[String]) = {
    val sparkConf = new SparkConf()
    sparkConf.setMaster("local")
    sparkConf.setAppName("Word Count")
    val sc = new SparkContext(sparkConf)
    val textFile1 = sc.textFile("hdfs://localhost:8020/input/american_pie.txt")
    val counts1 = textFile1.flatMap(line => line.split(" "))
      .map(word => (word, 1))
      .reduceByKey(_ + _)
    counts1.saveAsTextFile("hdfs://localhost:8020/output/spark_word_count_american_pie")

    val textFile2 = sc.textFile("hdfs://localhost:8020/input/hamlet.txt")
    val counts2 = textFile2.flatMap(line => line.split(" "))
      .map(word => (word, 1))
      .reduceByKey(_ + _)
    counts2.saveAsTextFile("hdfs://localhost:8020/output/spark_word_count_hamlet")

    val textFile3 = sc.textFile("hdfs://localhost:8020/input/bbc_tech_news")
    val counts3 = textFile3.flatMap(line => line.split(" "))
      .map(word => (word, 1))
      .reduceByKey(_ + _)
    counts3.saveAsTextFile("hdfs://localhost:8020/output/spark_word_count_bbc_tech_news")

    val textFile4 = sc.textFile("hdfs://localhost:8020/input/charles_dickens")
    val counts4 = textFile4.flatMap(line => line.split(" "))
      .map(word => (word, 1))
      .reduceByKey(_ + _)
    counts4.saveAsTextFile("hdfs://localhost:8020/output/spark_word_count_charles_dickens")

    val textFile5 = sc.textFile("hdfs://localhost:8020/input/song_lyrics/all_genres")
    val counts5 = textFile5.flatMap(line => line.split(" "))
      .map(word => (word, 1))
      .reduceByKey(_ + _)
    counts5.saveAsTextFile("hdfs://localhost:8020/output/spark_word_count_song_lyrics")

  }
}
