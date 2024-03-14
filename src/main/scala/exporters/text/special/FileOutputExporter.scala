package exporters.text.special

import exporters.text.StreamTextExporter

import java.io.{File, FileOutputStream}

/**
 * A class that extends the StreamTextExporter to export text to a file.
 *
 * @constructor create a new file output exporter with a file.
 * @param file the file to which the text should be exported.
 */
class FileOutputExporter(file: File)
  extends StreamTextExporter(new FileOutputStream(file)){

}

