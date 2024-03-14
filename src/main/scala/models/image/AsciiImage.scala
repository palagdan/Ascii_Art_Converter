package models.image

import models.pixel.{AsciiPixel, RGBPixel}

/**
 * A case class that represents an ASCII image.
 *
 * @constructor create a new ASCII image with a grid of ASCII pixels.
 * @param grid the 2D sequence of ASCII pixels that make up the image. All rows must be of the same size.
 * @throws IllegalArgumentException if the grid is empty or the rows are of different sizes.
 */
case class AsciiImage(grid: Seq[Seq[AsciiPixel]]) extends Image[AsciiPixel]{

  require(grid.nonEmpty && grid.forall(row => row.size == grid.head.size), "Invalid Ascii image grid dimensions.")

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
   * @return the ASCII pixel at the specified coordinates.
   * @throws IndexOutOfBoundsException if the indices are out of the grid's bounds.
   */
  override def getPixel(i: Int, j: Int): AsciiPixel = {
    if (i >= 0 && i < height && j >= 0 && j < width) {
      grid(i)(j)
    } else {
      throw new IndexOutOfBoundsException("Invalid indices for accessing Ascii image grid.")
    }
  }

  /**
   * Returns a string representation of the ASCII image.
   *
   * @return a string where each pixel is represented by its ASCII symbol. Rows are separated by newlines.
   */
  override def toString: String = {
    grid.map(row => row.mkString("")).mkString("\n")
  }
}

