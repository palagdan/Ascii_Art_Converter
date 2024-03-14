package filters.image.grayFilters.mixed

import filters.image.grayFilters.GrayImageFilter
import models.image.GrayScaleImage

/**
 * Class `MixedFilter` represents a filter that applies a sequence of grayscale image filters.
 *
 * @param filters the sequence of grayscale image filters to be applied.
 * This class extends the `GrayImageFilter` class and overrides its `filter` method.
 */
class MixedFilter(filters: Seq[GrayImageFilter]) extends GrayImageFilter  {

  /**
   * Applies the sequence of filters to a grayscale image.
   *
   * The filters are applied in the order they appear in the sequence. Each filter is applied to the result of the previous filter.
   *
   * @param item the grayscale image to be filtered.
   * @return a new grayscale image that is the result of applying all the filters.
   */
  override def filter(item: GrayScaleImage): GrayScaleImage = {
    filters.foldLeft(item)((acc, filter) => filter.filter(acc))
  }
}

