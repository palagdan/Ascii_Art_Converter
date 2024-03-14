package loaders

/**
 * A generic trait that represents a loader.
 *
 * This trait can be extended by any class that needs to load data and convert it into a specific type.
 *
 * @tparam T the type of data that the loader will load.
 */
trait Loader[T] {
    /**
     * Loads data and converts it into the specified type.
     *
     * @return the loaded data of type T.
     */
    def load(): T
}

