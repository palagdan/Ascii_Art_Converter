package filters.image.grayFilters.specific.flip

import models.image.GrayScaleImage

/**
 * Class `FlipYFilter` represents a filter that flips a grayscale image along the Y-axis.
 *
 * This class extends the `FlipFilter` class and overrides its `filter` method.
 */
class FlipYFilter extends FlipFilter {

  /**
   * Applies the flip filter to a grayscale image.
   *
   * The image is flipped along the Y-axis by reversing the order of pixels in each row of its grid.
   *
   * @param item the grayscale image to be filtered.
   * @return a new grayscale image that is flipped along the Y-axis.
   */
  override def filter(item: GrayScaleImage): GrayScaleImage = {
    GrayScaleImage(item.grid.map(row => row.reverse))
  }
}
