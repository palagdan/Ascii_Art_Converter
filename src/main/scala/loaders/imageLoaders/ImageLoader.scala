package loaders.imageLoaders

import loaders.Loader
import models.image.RGBImage

/**
 * A trait that represents an image loader.
 *
 * This trait extends the Loader trait with a type parameter of RGBImage.
 * It can be extended by any class that needs to load an image and convert it into an RGBImage.
 */
trait ImageLoader extends Loader[RGBImage]{

}
