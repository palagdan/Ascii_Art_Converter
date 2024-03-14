package filters.image.grayFilters.specific

import filters.image.grayFilters.GrayImageFilter
import models.image.GrayScaleImage
import models.pixel.GrayScalePixel

/**
 * Class `InvertFilter` represents a filter that inverts the colors of a grayscale image.
 *
 * This class extends the `GrayImageFilter` class and overrides its `filter` method.
 */
class InvertFilter extends GrayImageFilter {

  /**
   * Applies the invert filter to a grayscale image.
   *
   * The color of each pixel in the image is inverted by subtracting its intensity from 255.
   *
   * @param item the grayscale image to be filtered.
   * @return a new grayscale image with inverted colors.
   */
  override def filter(item: GrayScaleImage): GrayScaleImage = {
    GrayScaleImage(item.grid.map(row => row.map(pixel => GrayScalePixel(255 - pixel.intensity))))
  }
}
