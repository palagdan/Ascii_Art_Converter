package models.image

import models.pixel.GrayScalePixel

/**
 * A case class that represents a grayscale image.
 *
 * @constructor create a new grayscale image with a grid of grayscale pixels.
 * @param grid the 2D sequence of grayscale pixels that make up the image. All rows must be of the same size.
 * @throws IllegalArgumentException if the grid is empty or the rows are of different sizes.
 */
case class GrayScaleImage(grid: Seq[Seq[GrayScalePixel]]) extends Image[GrayScalePixel]{

  require(grid.nonEmpty && grid.forall(row => row.size == grid.head.size), "Invalid GrayScale image grid dimensions.")

  /**
   * Returns the height of the image.
   *
   * @return the number of rows in the grid.
   */
  override def height: Int = grid.length

  /**
   * Returns the width of the image.
   *
   * @return the number of columns in the grid.
   */
  override def width: Int = grid.head.size

  /**
   * Returns the pixel at the specified coordinates.
   *
   * @param i the row index of the pixel.
   * @param j the column index of the pixel.
   * @return the grayscale pixel at the specified coordinates.
   * @throws IndexOutOfBoundsException if the indices are out of the grid's bounds.
   */
  override def getPixel(i: Int, j: Int): GrayScalePixel = {
    if (i >= 0 && i < height && j >= 0 && j < width) {
      grid(i)(j)
    } else {
      throw new IndexOutOfBoundsException("Invalid indices for accessing Gray Scale image grid.")
    }
  }
}

