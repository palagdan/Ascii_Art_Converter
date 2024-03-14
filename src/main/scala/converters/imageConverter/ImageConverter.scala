package converters.imageConverter

import converters.Converter
import models.image.Image

/**
 * Trait `ImageConverter[FROM, TO]` represents a generic interface for converting images of one type to another.
 *
 * @tparam FROM the type of images that this converter can handle as input. `FROM` must be a subtype of `Image[_]`.
 * @tparam TO the type of images that this converter produces as output. `TO` must be a subtype of `Image[_]`.
 * This trait extends the `Converter[FROM, TO]` trait.
 */
trait ImageConverter[FROM <: Image[_], TO <: Image[_]] extends Converter[FROM, TO] {

}
