package filters.image

import filters.Filter
import models.image.{GrayScaleImage, Image}
import models.pixel.Pixel

/**
 * Trait `ImageFilter[T]` represents a generic interface for filtering images.
 *
 * @tparam T the type of images that this filter can handle. `T` must be a subtype of `Image[_]`.
 */
trait ImageFilter[T <: Image[_]] extends Filter[T] {

}
