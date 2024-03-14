package models.pixel

import org.scalatest.FunSuite

class GrayScalePixelTests extends FunSuite {

  test("Creating a valid GrayScalePixel instance") {
    val validIntensity = 128
    val grayScalePixel = GrayScalePixel(validIntensity)

    assert(grayScalePixel.intensity === validIntensity)
  }

  test("Creating a GrayScalePixel instance with intensity below the valid range should throw an exception") {
    val belowRangeIntensity = -5

    assertThrows[IllegalArgumentException] {
      GrayScalePixel(belowRangeIntensity)
    }
  }

  test("Creating a GrayScalePixel instance with intensity above the valid range should throw an exception") {
    val aboveRangeIntensity = 300

    assertThrows[IllegalArgumentException] {
      GrayScalePixel(aboveRangeIntensity)
    }
  }

}
