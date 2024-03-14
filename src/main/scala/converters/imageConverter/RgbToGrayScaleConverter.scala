package converters.imageConverter

import models.image.{GrayScaleImage, RGBImage}
import models.pixel.GrayScalePixel

/**
 * Class `RgbToGrayScaleConverter` represents a converter that transforms an RGB image into a grayscale image.
 *
 * This class extends the `ImageConverter[RGBImage, GrayScaleImage]` trait and overrides its `convert` method.
 */
class RgbToGrayScaleConverter extends ImageConverter[RGBImage, GrayScaleImage]{

  /**
   * Converts an RGB image into a grayscale image.
   *
   * Each pixel in the RGB image is transformed into a grayscale pixel. The grayscale value is calculated as a weighted sum of the red, green, and blue values of the RGB pixel, using the formula `0.3 * r + 0.59 * g + 0.11 * b`.
   *
   * @param elem the RGB image to be converted.
   * @return the grayscale image.
   */
  override def convert(elem: RGBImage): GrayScaleImage = {
    GrayScaleImage(elem.grid.map(row => row.map(rgbPixel =>
      GrayScalePixel(calculateGrayscaleValue(rgbPixel.r, rgbPixel.g, rgbPixel.b)))))
  }

  /**
   * Calculates the grayscale value of an RGB pixel.
   *
   * The grayscale value is calculated as a weighted sum of the red, green, and blue values of the RGB pixel, using the formula `0.3 * r + 0.59 * g + 0.11 * b`.
   *
   * @param r the red value of the RGB pixel.
   * @param g the green value of the RGB pixel.
   * @param b the blue value of the RGB pixel.
   * @return the grayscale value.
   */
  private def calculateGrayscaleValue(r: Int, g: Int, b: Int): Int = (0.3 * r + 0.59 * g + 0.11 * b).toInt
}

