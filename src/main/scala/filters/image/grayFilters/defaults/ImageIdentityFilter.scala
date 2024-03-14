package filters.image.grayFilters.defaults

import filters.IdentityFilter
import filters.image.grayFilters.GrayImageFilter
import models.image.GrayScaleImage

/**
 * Object `ImageIdentityFilter` represents an identity filter for grayscale images.
 *
 * This object extends the `IdentityFilter[GrayScaleImage]` trait and mixes in the `GrayImageFilter` trait.
 */
object ImageIdentityFilter extends IdentityFilter[GrayScaleImage] with GrayImageFilter {

}

