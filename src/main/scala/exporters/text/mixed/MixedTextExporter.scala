package exporters.text.mixed
import exporters.text.StreamTextExporter
import exporters.text.TextExporter


/**
 * A class that extends the TextExporter to export text to multiple output streams.
 *
 * @constructor create a new mixed text exporter with a sequence of stream text exporters.
 * @param exporters the sequence of stream text exporters to which the text should be exported.
 */
class MixedTextExporter (exporters: Seq[StreamTextExporter]) extends TextExporter {

  /**
   * Exports a string item to all the output streams.
   *
   * @param item the string item to be exported.
   */
  override def `export`(item: String): Unit = {
    exporters.foreach(exporter => exporter.export(item))
  }
}

