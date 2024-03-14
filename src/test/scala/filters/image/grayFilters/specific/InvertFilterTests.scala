package filters.image.grayFilters.specific

import org.scalatest.FunSuite
import filters.image.grayFilters.specific.InvertFilter
import models.image.GrayScaleImage
import models.pixel.GrayScalePixel

class InvertFilterTests extends FunSuite{

  test("InvertFilter should invert pixel values"){
    val grayPixels = Seq(Seq(GrayScalePixel(125), GrayScalePixel(134)), Seq(GrayScalePixel(12), GrayScalePixel(1)))
    val grayImage = GrayScaleImage(grayPixels)
    val invertFilter = new InvertFilter
    val inverted = invertFilter.filter(grayImage)

    val filteredGrayPixels = Seq(Seq(GrayScalePixel(130), GrayScalePixel(121)), Seq(GrayScalePixel(243), GrayScalePixel(254)))
    val expected = GrayScaleImage(filteredGrayPixels)

    assert(inverted === expected)
  }

  test("InvertFilter should handle extreme pixel values") {
    val grayPixels = Seq(Seq(GrayScalePixel(0), GrayScalePixel(255)), Seq(GrayScalePixel(128), GrayScalePixel(64)))
    val grayImage = GrayScaleImage(grayPixels)
    val invertFilter = new InvertFilter
    val inverted = invertFilter.filter(grayImage)

    val filteredGrayPixels = Seq(Seq(GrayScalePixel(255), GrayScalePixel(0)), Seq(GrayScalePixel(127), GrayScalePixel(191)))
    val expected = GrayScaleImage(filteredGrayPixels)

    assert(inverted === expected)
  }

  test("InvertFilter should invert 255 to 0") {
    val grayPixels = Seq(Seq(GrayScalePixel(255), GrayScalePixel(255)), Seq(GrayScalePixel(255), GrayScalePixel(255)))
    val grayImage = GrayScaleImage(grayPixels)
    val invertFilter = new InvertFilter
    val inverted = invertFilter.filter(grayImage)

    val filteredGrayPixels = Seq(Seq(GrayScalePixel(0), GrayScalePixel(0)), Seq(GrayScalePixel(0), GrayScalePixel(0)))
    val expected = GrayScaleImage(filteredGrayPixels)

    assert(inverted === expected)
  }
  test("InvertFilter should invert from 0 to 255") {
    val grayPixels = Seq(Seq(GrayScalePixel(0), GrayScalePixel(0)), Seq(GrayScalePixel(0), GrayScalePixel(0)))
    val grayImage = GrayScaleImage(grayPixels)
    val invertFilter = new InvertFilter
    val inverted = invertFilter.filter(grayImage)

    val filteredGrayPixels = Seq(Seq(GrayScalePixel(255), GrayScalePixel(255)), Seq(GrayScalePixel(255), GrayScalePixel(255)))
    val expected = GrayScaleImage(filteredGrayPixels)

    assert(inverted === expected)
  }


}
