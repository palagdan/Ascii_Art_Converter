package exporters

/**
 * Trait `Exporter[T]` represents a generic interface for exporting items of type `T`.
 *
 * @tparam T the type of items that this exporter can handle.
 */
trait Exporter[T] {

    /**
     * Exports the given item.
     *
     * @param item the item of type `T` to be exported.
     */
    def export(item: T): Unit
}
