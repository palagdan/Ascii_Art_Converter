package models.image

import models.pixel.RGBPixel
import org.scalatest.FunSuite

class RGBImageTests extends FunSuite{
  test("Creating a valid RGBImage instance") {
    val validGrid = Seq(Seq(RGBPixel(255, 0, 0), RGBPixel(0, 255, 0)),
      Seq(RGBPixel(0, 0, 255), RGBPixel(128, 128, 128)))
    val rgbImage = new RGBImage(validGrid)
    assert(rgbImage.height === 2)
    assert(rgbImage.width === 2)
    assert(rgbImage.getPixel(0, 0) === RGBPixel(255, 0, 0))
    assert(rgbImage.getPixel(1, 1) === RGBPixel(128, 128, 128))
  }

  test("Creating an RGBImage instance with invalid grid dimensions should throw an exception") {
    val invalidGrid = Seq(Seq(RGBPixel(255, 0, 0), RGBPixel(0, 255, 0)),
      Seq(RGBPixel(0, 0, 255)))

    assertThrows[IllegalArgumentException] {
       RGBImage(invalidGrid)
    }
  }

  test("Accessing an RGBPixel with invalid indices should throw an exception") {
    val validGrid = Seq(Seq(RGBPixel(255, 0, 0), RGBPixel(0, 255, 0)),
      Seq(RGBPixel(0, 0, 255), RGBPixel(128, 128, 128)))
    val rgbImage = RGBImage(validGrid)

    assertThrows[IndexOutOfBoundsException] {
      rgbImage.getPixel(2, 0)
    }
  }
}
