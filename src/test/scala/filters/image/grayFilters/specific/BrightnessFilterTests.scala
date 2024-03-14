package filters.image.grayFilters.specific

import models.image.GrayScaleImage
import models.pixel.GrayScalePixel
import org.scalatest.FunSuite

class BrightnessFilterTests extends FunSuite {

  test("BrightnessFilter should increase brightness within bounds") {
    val grayPixels = Seq(Seq(GrayScalePixel(100), GrayScalePixel(150)), Seq(GrayScalePixel(50), GrayScalePixel(200)))
    val grayImage = GrayScaleImage(grayPixels)
    val brightnessFilter = new BrightnessFilter(50)
    val brightened = brightnessFilter.filter(grayImage)

    val expectedPixels = Seq(Seq(GrayScalePixel(150), GrayScalePixel(200)), Seq(GrayScalePixel(100), GrayScalePixel(250)))
    val expectedImage = GrayScaleImage(expectedPixels)

    assert(brightened === expectedImage)
  }

  test("BrightnessFilter should decrease brightness within bounds") {
    val grayPixels = Seq(Seq(GrayScalePixel(100), GrayScalePixel(150)), Seq(GrayScalePixel(50), GrayScalePixel(200)))
    val grayImage = GrayScaleImage(grayPixels)
    val brightnessFilter = new BrightnessFilter(-30)
    val darkened = brightnessFilter.filter(grayImage)

    val expectedPixels = Seq(Seq(GrayScalePixel(70), GrayScalePixel(120)), Seq(GrayScalePixel(20), GrayScalePixel(170)))
    val expectedImage = GrayScaleImage(expectedPixels)

    assert(darkened === expectedImage)
  }

  test("BrightnessFilter should handle upper bound saturation") {
    val grayPixels = Seq(Seq(GrayScalePixel(200), GrayScalePixel(220)), Seq(GrayScalePixel(240), GrayScalePixel(255)))
    val grayImage = GrayScaleImage(grayPixels)
    val brightnessFilter = new BrightnessFilter(50)
    val brightened = brightnessFilter.filter(grayImage)

    val expectedPixels = Seq(Seq(GrayScalePixel(250), GrayScalePixel(255)), Seq(GrayScalePixel(255), GrayScalePixel(255)))
    val expectedImage = GrayScaleImage(expectedPixels)

    assert(brightened == expectedImage)
  }

  test("BrightnessFilter should handle lower bound saturation") {
    val grayPixels = Seq(Seq(GrayScalePixel(30), GrayScalePixel(20)), Seq(GrayScalePixel(10), GrayScalePixel(0)))
    val grayImage = GrayScaleImage(grayPixels)
    val brightnessFilter = new BrightnessFilter(-20)
    val darkened = brightnessFilter.filter(grayImage)

    val expectedPixels = Seq(Seq(GrayScalePixel(10), GrayScalePixel(0)), Seq(GrayScalePixel(0), GrayScalePixel(0)))
    val expectedImage = GrayScaleImage(expectedPixels)

    assert(darkened == expectedImage)
  }
}
