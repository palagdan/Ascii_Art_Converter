package loaders.imageLoaders
import models.image.RGBImage
import org.scalatest.FunSuite

class RandomImageLoaderTests extends FunSuite{

    test("RandomImageLoader.load returns an RGBImage") {
        val image = RandomImageLoader.load()
        assert(image.isInstanceOf[RGBImage])
    }

    test("RandomImageLoader.load returns an image with dimensions within the specified range") {
        val image = RandomImageLoader.load()
        assert(image.height >= 1 && image.height <= 1600)
        assert(image.width >= 1 && image.width <= 1600)
    }
}
