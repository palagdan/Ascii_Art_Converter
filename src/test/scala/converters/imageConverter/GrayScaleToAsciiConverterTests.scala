package converters.imageConverter
import models.image.GrayScaleImage
import models.image.AsciiImage
import models.pixel.GrayScalePixel
import models.pixel.AsciiPixel
import org.scalatest.FunSuite
import converters.imageConverter.AsciiTables
  class GrayScaleToAsciiConverterTests extends FunSuite {

    test("GrayScaleToAsciiConverter should convert GrayScaleImage to AsciiImage with bourke-small") {
      val converter = new GrayScaleToAsciiConverter(AsciiTables.linearTables("bourke-small"))

      val grayScaleImage = GrayScaleImage(Seq(
        Seq(GrayScalePixel(123), GrayScalePixel(233), GrayScalePixel(222)),
        Seq(GrayScalePixel(11), GrayScalePixel(1), GrayScalePixel(0)),
      ))
      val asciiImage = converter.convert(grayScaleImage)

      val expectedAsciiImage = AsciiImage(Seq(
        Seq(AsciiPixel('+'), AsciiPixel('.'), AsciiPixel(',')),
        Seq(AsciiPixel('@'), AsciiPixel('@'), AsciiPixel('@')),
      ))

      assert(asciiImage == expectedAsciiImage)
    }

    test("GrayScaleToAsciiConverter should convert GrayScaleImage with 0 values to AsciiImage with default") {
      val converter = new GrayScaleToAsciiConverter

      // Create a sample GrayScaleImage
      val grayScaleImage = GrayScaleImage(Seq(
        Seq(GrayScalePixel(0), GrayScalePixel(0), GrayScalePixel(0)),
        Seq(GrayScalePixel(0), GrayScalePixel(0), GrayScalePixel(0)),
      ))

      // Convert GrayScaleImage to AsciiImage
      val asciiImage = converter.convert(grayScaleImage)


      val expectedAsciiImage = AsciiImage(Seq(
        Seq(AsciiPixel('@'), AsciiPixel('@'), AsciiPixel('@')),
        Seq(AsciiPixel('@'), AsciiPixel('@'), AsciiPixel('@')),
      ))

      assert(asciiImage == expectedAsciiImage)
    }

    test("GrayScaleToAsciiConverter should convert GrayScaleImage with 255 values to AsciiImage with default table") {
      val converter = new GrayScaleToAsciiConverter

      // Create a sample GrayScaleImage
      val grayScaleImage = GrayScaleImage(Seq(
        Seq(GrayScalePixel(255), GrayScalePixel(255), GrayScalePixel(255)),
        Seq(GrayScalePixel(255), GrayScalePixel(255), GrayScalePixel(255)),
      ))

      // Convert GrayScaleImage to AsciiImage
      val asciiImage = converter.convert(grayScaleImage)

      val expectedAsciiImage = AsciiImage(Seq(
        Seq(AsciiPixel(' '), AsciiPixel(' '), AsciiPixel(' ')),
        Seq(AsciiPixel(' '), AsciiPixel(' '), AsciiPixel(' ')),
      ))

      assert(asciiImage == expectedAsciiImage)
    }
}
