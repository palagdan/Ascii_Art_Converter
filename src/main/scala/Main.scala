
import converters.imageConverter.RgbToGrayScaleConverter
import converters.imageConverter.GrayScaleToAsciiConverter
import ui.ConsoleUI

object Main extends App {
      try {
            val consoleUI = new ConsoleUI(args)
            val image = consoleUI.getImage
            val filters = consoleUI.getGrayImageFilters
            val outputs = consoleUI.getOutput
            val table = consoleUI.getTable
            val rgbToGrayScaleConverter = new RgbToGrayScaleConverter()
            val grayScaleImage = rgbToGrayScaleConverter.convert(image)
            val filteredGrayScaleImage = filters.filter(grayScaleImage)
            val grayScaleToAsciiConverter = new GrayScaleToAsciiConverter(table)
            val asciiImageFiltered = grayScaleToAsciiConverter.convert(filteredGrayScaleImage)
            outputs.export(asciiImageFiltered.toString)
      } catch {
            case e: Throwable =>
                  println(s"Caught an exception: ${e.getMessage}")
      }


}