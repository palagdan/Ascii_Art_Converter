package converters.imageConverter

/**
 * The AsciiTables object is responsible for storing predefined ASCII conversion tables.
 * It contains both linear and non-linear tables for converting grayscale values into ASCII characters.
 */
object AsciiTables {

  /**
   * A map of linear ASCII conversion tables.
   * Each key represents the name of the table, and the value is a string of ASCII characters ordered by intensity.
   */
  val linearTables: Map[String, String] = Map(
    "bourke-small" -> "@%#*+=-:,. ",
    "bourke-large" -> "$@B%8&WM#*oahkbdpqwmZO0QLCJUYXzcvunxrjft/\\|()1{}[]?-_+~<>i!lI;:,\"^`'. ",
  )


  /**
   * A map of non-linear ASCII conversion tables.
   * Each key represents the name of the table, and the value is a string of ASCII characters ordered by intensity.
   * The distribution of characters is non-linear, meaning some intensity levels may have more corresponding characters than others.
   */
  val nonLinearTables: Map[String, String] = Map(
    "non-linear-large" -> "@@@@@@@@@@@@@@@@@@@@@$%^&*+++++++++++++^^^^^^^^^^^!!!!!!!!..............                   ",
    "non-linear-medium" -> "@@%++**----:;~,  ",
    "non-linear-small" -> "@@%++**--  ",
    "non-linear-xlarge" -> "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@%++**----:;~,~~~~~~~~~~~~~..............................                               ",
  )


  /**
   * The default ASCII conversion table used if no specific table is defined.
   */
  val default: String = "@%#*+=-:,.       "
}
