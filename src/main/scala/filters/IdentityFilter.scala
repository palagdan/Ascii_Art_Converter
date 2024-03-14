package filters

/**
 * Class `IdentityFilter[T]` represents an identity filter.
 *
 * @tparam T the type of items that this filter can handle.
 * This class extends the `Filter[T]` trait and overrides its `filter` method.
 */
class IdentityFilter[T] extends Filter[T] {

  /**
   * Returns the item unchanged.
   *
   * @param item the item to be filtered.
   * @return the same item.
   */
  override def filter(item: T): T = item
}
