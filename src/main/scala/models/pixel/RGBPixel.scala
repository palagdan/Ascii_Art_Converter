package models.pixel

/**
 * A case class that represents an RGB pixel.
 *
 * @constructor create a new RGB pixel with red, green, and blue color intensities.
 * @param r the red color intensity of the pixel. Must be an integer between 0 and 255 inclusive.
 * @param g the green color intensity of the pixel. Must be an integer between 0 and 255 inclusive.
 * @param b the blue color intensity of the pixel. Must be an integer between 0 and 255 inclusive.
 * @throws IllegalArgumentException if any of the color intensities are not between 0 and 255 inclusive.
 */
case class RGBPixel(r: Int, g: Int, b: Int) extends Pixel {
    require(r >= 0 && r <= 255 && g >= 0 && g <= 255 && b >= 0 && b <= 255, "Color intensities must be between 0 and 255.")
}

