package filters.image.grayFilters.defaults

import models.image.GrayScaleImage
import models.pixel.GrayScalePixel
import org.scalatest.FunSuite

class ImageIdentityFilterTests extends FunSuite{

    test("ImageIdentityFilter should maintain original image") {
      val originalPixels = Seq(Seq(GrayScalePixel(100), GrayScalePixel(150)), Seq(GrayScalePixel(50), GrayScalePixel(200)))
      val originalImage = GrayScaleImage(originalPixels)
      val filteredImage = ImageIdentityFilter.filter(originalImage)
      assert(filteredImage == originalImage)
    }

}
