package converters.imageConverter

import models.image.{GrayScaleImage, RGBImage}
import models.pixel.{GrayScalePixel, RGBPixel}
import org.scalatest.FunSuite
class RgbToGrayScaleConverterTests extends FunSuite {

  test("RgbToGrayScaleConverter should convert RGBImage to GrayScaleImage") {
    val rgbPixels = Seq(
      Seq(RGBPixel(255, 0, 0), RGBPixel(0, 255, 0)),
    )

    val rgbImage = RGBImage(rgbPixels)

    val converter = new RgbToGrayScaleConverter

    val grayScaleImage = converter.convert(rgbImage)
    print(grayScaleImage)
    assert(grayScaleImage.grid.size == rgbImage.grid.size)
    assert(grayScaleImage.grid.head.size == rgbImage.grid.head.size)

    val expectedPixels = Seq(Seq(GrayScalePixel(76), GrayScalePixel(150)))
    val expectedImage = GrayScaleImage(expectedPixels)
    assert(grayScaleImage === expectedImage)
  }
}
