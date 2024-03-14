package loaders.imageLoaders

import models.image.RGBImage
import models.pixel.RGBPixel
import scala.util.Random

/**
 * An object that extends the ImageLoader trait to load random RGB images.
 *
 * This object overrides the `load` method of the ImageLoader trait to generate
 * a random RGB image. The dimensions of the image (height and width) are
 * randomly chosen between 1 and 1600. Each pixel in the image is also randomly
 * generated with red, green, and blue color intensities ranging from 0 to 255.
 */
object RandomImageLoader extends ImageLoader {

  /**
   * Generates a random RGB image.
   *
   * @return a randomly generated RGB image with dimensions and pixel intensities
   *         randomly chosen within specified ranges.
   */
  override def load(): RGBImage = {
    val min = 1
    val max = 1600
    val height = Random.nextInt(max - min) + min
    val width = Random.nextInt(max - min) + min
    val generated: Array[Array[RGBPixel]] = Array.ofDim(height, width)

    val transformed: Seq[Seq[RGBPixel]] = generated.map(row => row.map(_ =>
      RGBPixel(Random.nextInt(255), Random.nextInt(255), Random.nextInt(255))
    ).toSeq).toSeq

    // Create an RGBImage from the generated array
    RGBImage(transformed)
  }
}
