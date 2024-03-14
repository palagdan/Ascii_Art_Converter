package exporters.text.special

import exporters.text.StreamTextExporter

/**
 * A class that extends the StreamTextExporter to export text to the standard output.
 *
 * This class overrides the output stream of the StreamTextExporter with `System.out`,
 * allowing text to be exported directly to the standard output (usually the console).
 */
class StdOutputExporter extends StreamTextExporter(System.out){

}

