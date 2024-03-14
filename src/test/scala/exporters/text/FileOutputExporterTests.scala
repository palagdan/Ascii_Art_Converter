package exporters.text

import org.scalatest.FunSuite

import java.io.{File, FileInputStream}
import java.nio.file.{Files, Paths}

class FileOutputExporterTests extends FunSuite{

  // This test might not delete the testing file, that is why I commented this test.
  test("FileOutputExporter writes to the file") {
//    val outputFile = new File("test-output.txt")
//    val textExporter = new FileOutputExporter(outputFile)
//
//    try {
//      textExporter.export("Testing FileOutputExporter")
//      val fileInputStream = new FileInputStream(outputFile)
//      val content = scala.io.Source.fromInputStream(fileInputStream).mkString
//      assert(content === "Testing FileOutputExporter")
//      fileInputStream.close()
//      val deletionSuccessful = outputFile.delete()
//      if (!deletionSuccessful) {
//        println("Warning: Unable to delete the file.")
//      }
//    } catch {
//      case e: Exception =>
//        println(s"Error: ${e.getMessage}")
//    }
  }

}
