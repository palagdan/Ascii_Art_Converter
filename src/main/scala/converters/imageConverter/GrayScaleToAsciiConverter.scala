package converters.imageConverter
import models.image.GrayScaleImage
import models.image.AsciiImage
import models.pixel.{AsciiPixel, GrayScalePixel}

/**
 * The GrayScaleToAsciiConverter class is responsible for converting grayscale images to ASCII art.
 * It extends the ImageConverter interface, which defines a method for converting one type of image to another.
 *
 * @param asciiTable A string of ASCII characters ordered by intensity. This table is used to map grayscale values to ASCII characters.
 */
class GrayScaleToAsciiConverter(asciiTable: String = "@%#*+=-:,. ") extends ImageConverter[GrayScaleImage, AsciiImage]{

  /**
   * Converts a grayscale image to an ASCII image.
   * This is done by mapping each pixel in the grayscale image to an ASCII character based on its intensity.
   *
   * @param elem The grayscale image to be converted.
   * @return The resulting ASCII image.
   */
  override def convert(elem: GrayScaleImage): AsciiImage = {
    val asciiImage = elem.grid.map(row => row.map(pixel => transformPixel(pixel)))
    AsciiImage(asciiImage)
  }

  /**
   * Transforms a grayscale pixel to an ASCII pixel.
   * This is done by mapping the pixel's intensity to an ASCII character using the asciiTable.
   *
   * @param pixel The grayscale pixel to be transformed.
   * @return The resulting ASCII pixel.
   */
  private def transformPixel(pixel: GrayScalePixel): AsciiPixel = {
    val asciiIndex = ((asciiTable.length - 1) * pixel.intensity / 255) % asciiTable.length
    AsciiPixel(asciiTable(asciiIndex))
  }
}

