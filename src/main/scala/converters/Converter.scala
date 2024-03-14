package converters

/**
 * Trait `Converter[FROM, TO]` represents a generic interface for converting objects of one type to another.
 *
 * @tparam FROM the type of objects that this converter can handle as input.
 * @tparam TO the type of objects that this converter produces as output.
 */
trait Converter[FROM, TO] {

    /**
     * Converts an object of type `FROM` into an object of type `TO`.
     *
     * @param elem the object of type `FROM` to be converted.
     * @return the converted object of type `TO`.
     */
    def convert(elem: FROM): TO
}

