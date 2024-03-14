package models.pixel

import org.scalatest.FunSuite

class AsciiPixelTests extends FunSuite {

  test("Creating a valid AsciiPixel instance") {
    val validSymbol = 'A'
    val asciiPixel = AsciiPixel(validSymbol)

    assert(asciiPixel.symbol === validSymbol)
  }

  test("Creating an AsciiPixel instance with a non-printable ASCII character should throw an exception") {
    val nonPrintableSymbol = '\u0001'

    assertThrows[IllegalArgumentException] {
      AsciiPixel(nonPrintableSymbol)
    }
  }

  test("Creating an AsciiPixel instance with a printable ASCII character should not throw an exception") {
    val printableSymbol = 'X'
    AsciiPixel(printableSymbol)
  }

}


