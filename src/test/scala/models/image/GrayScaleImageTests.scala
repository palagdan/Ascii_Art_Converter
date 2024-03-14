package models.image

import models.pixel.GrayScalePixel
import org.scalatest.FunSuite

class GrayScaleImageTests extends FunSuite {

  test("Creating a valid GrayScaleImage instance") {
    val validGrid = Seq(Seq(GrayScalePixel(100), GrayScalePixel(150)),
      Seq(GrayScalePixel(200), GrayScalePixel(50)))
    val grayScaleImage = GrayScaleImage(validGrid)

    assert(grayScaleImage.height === 2)
    assert(grayScaleImage.width === 2)
    assert(grayScaleImage.getPixel(0, 0) === GrayScalePixel(100))
    assert(grayScaleImage.getPixel(1, 1) === GrayScalePixel(50))
  }

  test("Creating a GrayScaleImage instance with invalid grid dimensions should throw an exception") {
    val invalidGrid = Seq(Seq(GrayScalePixel(100), GrayScalePixel(150)),
      Seq(GrayScalePixel(200)))

    assertThrows[IllegalArgumentException] {
      GrayScaleImage(invalidGrid)
    }
  }

  test("Accessing a GrayScalePixel with invalid indices should throw an exception") {
    val validGrid = Seq(Seq(GrayScalePixel(100), GrayScalePixel(150)),
      Seq(GrayScalePixel(200), GrayScalePixel(50)))
    val grayScaleImage = GrayScaleImage(validGrid)

    assertThrows[IndexOutOfBoundsException] {
      grayScaleImage.getPixel(2, 0)
    }
  }
}
