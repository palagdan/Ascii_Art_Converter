package loaders.imageLoaders

import models.image.RGBImage
import org.scalatest.FunSuite

import java.io.File
import javax.imageio.ImageIO

class CommonImageLoaderTests extends FunSuite{

  val filename = new File("images/test_image1.jpg")
  val bufferedImage = ImageIO.read(filename)
  val loader = CommonImageLoader(filename)

  test("CommonImageLoader.load returns an RGBImage") {
    val image = loader.load()
    assert(image.isInstanceOf[RGBImage])
  }

  test("CommonImageLoader.load returns an image with correct dimensions") {
    val image = loader.load()
    assert(image.height == bufferedImage.getHeight)
    assert(image.width == bufferedImage.getWidth)
  }
}
