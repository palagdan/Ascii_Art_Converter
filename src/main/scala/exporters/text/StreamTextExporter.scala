package exporters.text

import java.io.OutputStream

/**
 * A class that extends the TextExporter to export text to an output stream.
 *
 * @constructor create a new stream text exporter with an output stream.
 * @param outputStream the output stream to which the text should be exported.
 */
class StreamTextExporter(outputStream: OutputStream) extends TextExporter {

  // A flag to indicate whether the output stream is closed.
  private var closed = false

  /**
   * Exports a string to the output stream.
   *
   * @param str the string to be exported.
   * @throws Exception if the output stream is closed.
   */
  protected def exportToStream(str: String): Unit = {
    if(closed){
      throw new Exception("Stream is closed")
    }
    outputStream.write(str.getBytes("UTF-8"))
    outputStream.flush()
  }

  /**
   * Closes the output stream.
   */
  def close(): Unit = {
    if (closed)
      return
    outputStream.close()
    closed = true
  }

  /**
   * Exports a string item to the output stream.
   *
   * @param item the string item to be exported.
   */
  override def `export`(item: String): Unit = exportToStream(item)
}
