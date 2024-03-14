package models.pixel

import org.scalatest.FunSuite

class RGBPixelTests extends FunSuite {

  test("Creating a valid RGBPixel instance") {
    val validR = 100
    val validG = 150
    val validB = 200
    val rgbPixel = RGBPixel(validR, validG, validB)

    assert(rgbPixel.r === validR)
    assert(rgbPixel.g === validG)
    assert(rgbPixel.b === validB)
  }

  test("Creating an RGBPixel instance with an out-of-range component should throw an exception") {
    val invalidR = 300
    val validG = 150
    val validB = 200

    assertThrows[IllegalArgumentException] {
      RGBPixel(invalidR, validG, validB)
    }
  }

  test("Creating an RGBPixel instance with all valid components should not throw an exception") {
    val validR = 100
    val validG = 150
    val validB = 200

    RGBPixel(validR, validG, validB)

  }

}
