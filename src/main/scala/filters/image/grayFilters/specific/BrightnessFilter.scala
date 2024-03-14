package filters.image.grayFilters.specific

import filters.image.grayFilters.GrayImageFilter
import models.image.GrayScaleImage
import models.pixel.GrayScalePixel

/**
 * Class `BrightnessFilter` represents a filter that adjusts the brightness of a grayscale image.
 *
 * @param value the brightness adjustment value. Positive values increase brightness, negative values decrease it.
 */
class BrightnessFilter(value: Int) extends GrayImageFilter {

  /**
   * Applies the brightness filter to a grayscale image.
   *
   * The brightness of each pixel in the image is adjusted by adding the `value` to its intensity.
   * If the resulting intensity is greater than 255, it is set to 255.
   * If the resulting intensity is less than 0, it is set to 0.
   *
   * @param item the grayscale image to be filtered.
   * @return a new grayscale image with adjusted brightness.
   */
  override def filter(item: GrayScaleImage): GrayScaleImage = {
    GrayScaleImage(item.grid.map(row => row.map(
      pixel =>
        if(pixel.intensity + value > 255)
          GrayScalePixel(255)
        else if(pixel.intensity + value < 0)
          GrayScalePixel(0)
        else
          GrayScalePixel(pixel.intensity + value)
    )))
  }
}
