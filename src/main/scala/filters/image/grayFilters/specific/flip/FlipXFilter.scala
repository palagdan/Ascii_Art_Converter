package filters.image.grayFilters.specific.flip

import models.image.GrayScaleImage

/**
 * Class `FlipXFilter` represents a filter that flips a grayscale image along the X-axis.
 *
 * This class extends the `FlipFilter` class and overrides its `filter` method.
 */
class FlipXFilter extends FlipFilter {

  /**
   * Applies the flip filter to a grayscale image.
   *
   * The image is flipped along the X-axis by reversing the order of rows in its grid.
   *
   * @param item the grayscale image to be filtered.
   * @return a new grayscale image that is flipped along the X-axis.
   */
  override def filter(item: GrayScaleImage): GrayScaleImage = {
    GrayScaleImage(item.grid.reverse)
  }
}
