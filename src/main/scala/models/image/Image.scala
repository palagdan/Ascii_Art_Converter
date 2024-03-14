package models.image

import models.pixel.Pixel

/**
 * A trait that represents an image.
 *
 * This trait can be extended by any class that needs to represent an image.
 * Specific image types (e.g., grayscale, RGB, etc.) should provide their own
 * implementation of the methods and properties defined in this trait.
 *
 * @tparam T the type of pixel that makes up the image. Must be a subtype of `Pixel`.
 */
trait Image[T <: Pixel] {

  /**
   * Returns the pixel at the specified coordinates.
   *
   * @param i the row index of the pixel.
   * @param j the column index of the pixel.
   * @return the pixel at the specified coordinates.
   */
  def getPixel(i: Int, j: Int): T

  /**
   * Returns the height of the image.
   *
   * @return the number of rows in the image.
   */
  def height: Int

  /**
   * Returns the width of the image.
   *
   * @return the number of columns in the image.
   */
  def width: Int
}
