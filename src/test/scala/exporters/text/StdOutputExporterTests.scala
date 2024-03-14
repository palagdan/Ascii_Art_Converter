package exporters.text

import exporters.text.special.StdOutputExporter
import org.scalatest.FunSuite

import java.io.{ByteArrayOutputStream, PrintStream}


class StdOutputExporterTests extends FunSuite {

  test("StdOutputExporter writes to the console") {
    val outputStream = new ByteArrayOutputStream()
    val printStream = new PrintStream(outputStream)
    val originalOut = System.out
    System.setOut(printStream)
    try {
      val textExporter = new StdOutputExporter
      textExporter.export("Testing StdOutputExporter")
      System.out.flush()
      val result = outputStream.toString("UTF-8")
      assert(result === "Testing StdOutputExporter")
    } finally {
      System.setOut(originalOut)
    }
  }
}