package models.pixel

/**
 * A case class that represents a grayscale pixel.
 *
 * @constructor create a new grayscale pixel with an intensity.
 * @param intensity the intensity of the pixel. Must be an integer between 0 and 255 inclusive.
 * @throws IllegalArgumentException if the intensity is not between 0 and 255 inclusive.
 */
case class GrayScalePixel(intensity: Int) extends Pixel {
  require(intensity >= 0 && intensity <= 255, "Intensity must be between 0 and 255.")
}
