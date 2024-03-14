package loaders.imageLoaders
import models.image.RGBImage
import models.pixel.RGBPixel

import models.image.RGBImage
import models.pixel.RGBPixel

import java.awt.image.BufferedImage
import java.io.File
import javax.imageio.ImageIO

/**
 * A case class that extends the ImageLoader trait to load images from a file.
 *
 * @constructor create a new image loader with a filename.
 * @param filename the file from which the image should be loaded.
 */
case class CommonImageLoader(filename: File) extends ImageLoader{


  /**
   * Loads an image from the file specified in the constructor.
   *
   * The image is loaded into a BufferedImage, and then each pixel is read and converted into an RGBPixel.
   * The RGBPixels are stored in a 2D array that represents the image.
   *
   * @return an RGBImage that represents the loaded image.
   * @throws IOException if there is an error reading the file.
   */
  override def load(): RGBImage = {
    val bufferedImage: BufferedImage = ImageIO.read(filename)

    val width = bufferedImage.getWidth
    val height = bufferedImage.getHeight
    val rgbValues = Array.ofDim[RGBPixel](height, width)

    for (y <- 0 until height) {
      for (x <- 0 until width) {
        val rgbPixel: Int = bufferedImage.getRGB(x, y)
        val red: Int = (rgbPixel >> 16) & 0xFF
        val green: Int = (rgbPixel >> 8) & 0xFF
        val blue: Int = rgbPixel & 0xFF
        rgbValues(y)(x) = RGBPixel(red, green, blue)
      }
    }
    val loaded = rgbValues.map(row => row.toSeq).toSeq
    RGBImage(loaded)
  }
}
