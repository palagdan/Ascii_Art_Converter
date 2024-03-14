package filters

/**
 * Trait `Filter[T]` represents a generic interface for filtering items of type `T`.
 *
 * @tparam T the type of items that this filter can handle.
 */
trait Filter[T] {

   /**
    * Filters the given item.
    *
    * @param item the item of type `T` to be filtered.
    * @return the filtered item of type `T`.
    */
   def filter(item: T): T
}
