package exporters.text.defaults
import exporters.text.TextExporter


/**
 * An object that extends the TextExporter to provide a default text exporting mechanism.
 *
 * This object overrides the `export` method of the TextExporter. The implementation of the `export`
 */
object DefaultTextExporter extends TextExporter {

  /**
   * Exports a string item.
   *
   * @param item the string item to be exported.
   */
  override def `export`(item: String): Unit = {

  }
}
