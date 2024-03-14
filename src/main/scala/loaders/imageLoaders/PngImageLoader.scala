package loaders.imageLoaders

import java.io.File

/**
 * A class that extends the CommonImageLoader to load PNG images.
 *
 * @constructor create a new PNG image loader with a filename.
 * @param filename the file from which the PNG image should be loaded.
 */
class PngImageLoader(filename: File) extends CommonImageLoader(filename) {

}
