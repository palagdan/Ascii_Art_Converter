package filters.image.grayFilters.specific.flip

import models.image.GrayScaleImage
import models.pixel.GrayScalePixel
import org.scalatest.FunSuite

class FlipYFilterTests extends FunSuite{
  test("FlipXFilter should flip the grid by Y axes") {
    val grayScalePixels = Seq(Seq(GrayScalePixel(234), GrayScalePixel(34), GrayScalePixel(23)),
      Seq(GrayScalePixel(12), GrayScalePixel(1), GrayScalePixel(13)))
    val grayScaleImage = GrayScaleImage(grayScalePixels)

    val flipXFilter = new FlipYFilter
    val filtered: GrayScaleImage = flipXFilter.filter(grayScaleImage)

    val expectedPixels = Seq(Seq(GrayScalePixel(23), GrayScalePixel(34), GrayScalePixel(234)),
      Seq(GrayScalePixel(13), GrayScalePixel(1), GrayScalePixel(12)))
    val expectedImage = GrayScaleImage(expectedPixels)
    assert(filtered === expectedImage)
  }

  test("FlipXFilter should flip the grid by Y axes with extreme values") {
    val grayScalePixels = Seq(Seq(GrayScalePixel(255), GrayScalePixel(255), GrayScalePixel(0)),
      Seq(GrayScalePixel(0), GrayScalePixel(255), GrayScalePixel(0)))
    val grayScaleImage = GrayScaleImage(grayScalePixels)

    val flipXFilter = new FlipYFilter
    val filtered: GrayScaleImage = flipXFilter.filter(grayScaleImage)

    val expectedPixels = Seq(Seq(GrayScalePixel(0), GrayScalePixel(255), GrayScalePixel(255)),
      Seq(GrayScalePixel(0), GrayScalePixel(255), GrayScalePixel(0)))
    val expectedImage = GrayScaleImage(expectedPixels)
    assert(filtered === expectedImage)
  }
}
