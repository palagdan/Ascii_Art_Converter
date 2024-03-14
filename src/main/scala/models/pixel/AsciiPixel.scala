package models.pixel

/**
 * A case class that represents an ASCII pixel.
 *
 * @constructor create a new ASCII pixel with a symbol.
 * @param symbol the character that represents the pixel. Must be a printable ASCII character (from ' ' to '~').
 * @throws IllegalArgumentException if the symbol is not a printable ASCII character.
 */
case class AsciiPixel(symbol: Char) extends Pixel {
  require(symbol >= ' ' && symbol <= '~', "Symbol must be a printable ASCII character.")

  /**
   * Returns a string representation of the ASCII pixel.
   *
   * @return the symbol of the ASCII pixel as a string.
   */
  override def toString: String  = {
    symbol.toString
  }
}

