package models.image

import models.pixel.AsciiPixel
import org.scalatest.FunSuite

class AsciiImageTests extends FunSuite {

  test("Creating a valid AsciiImage instance") {
    val validGrid = Seq(Seq(AsciiPixel('A'), AsciiPixel('B')), Seq(AsciiPixel('C'), AsciiPixel('D')))
    val asciiImage = AsciiImage(validGrid)

    assert(asciiImage.height === 2)
    assert(asciiImage.width === 2)
    assert(asciiImage.getPixel(0, 0) === AsciiPixel('A'))
    assert(asciiImage.getPixel(1, 1) === AsciiPixel('D'))
  }

  test("Creating an AsciiImage instance with invalid grid dimensions should throw an exception") {
    val invalidGrid = Seq(Seq(AsciiPixel('A'), AsciiPixel('B')), Seq(AsciiPixel('C')))
    assertThrows[IllegalArgumentException] {
       AsciiImage(invalidGrid)
    }
  }

  test("Accessing an AsciiPixel with invalid indices should throw an exception") {
    val validGrid = Seq(Seq(AsciiPixel('A'), AsciiPixel('B')), Seq(AsciiPixel('C'), AsciiPixel('D')))
    val asciiImage = AsciiImage(validGrid)

    assertThrows[IndexOutOfBoundsException] {
      asciiImage.getPixel(2, 0)
    }
  }
}

