package filters.image.grayFilters.mixed

import filters.image.grayFilters.specific.{BrightnessFilter, InvertFilter}
import models.image.GrayScaleImage
import models.pixel.GrayScalePixel
import org.scalatest.FunSuite

class MixedFilterTests extends FunSuite{

  test("MixedFilter should apply multiple filters sequentially") {
    val originalPixels = Seq(Seq(GrayScalePixel(100), GrayScalePixel(150)), Seq(GrayScalePixel(50), GrayScalePixel(200)))
    val originalImage = GrayScaleImage(originalPixels)

    val filter1 = new BrightnessFilter(50)
    val filter2 = new InvertFilter

    val mixedFilter = new MixedFilter(Seq(filter1, filter2))
    val filteredImage = mixedFilter.filter(originalImage)

    val expectedPixels = Seq(Seq(GrayScalePixel(105), GrayScalePixel(55)), Seq(GrayScalePixel(155), GrayScalePixel(5)))
    val expectedImage = GrayScaleImage(expectedPixels)

    assert(filteredImage == expectedImage)
  }

}
