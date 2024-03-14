package loaders.imageLoaders

import java.io.File


/**
 * A class that extends the CommonImageLoader to load JPG images.
 *
 * @constructor create a new JPG image loader with a filename.
 * @param filename the file from which the JPG image should be loaded.
 */
class JpgImageLoader(filename: File) extends CommonImageLoader(filename) {

}

