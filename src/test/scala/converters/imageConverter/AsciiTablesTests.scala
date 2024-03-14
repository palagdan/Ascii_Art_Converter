package converters.imageConverter

import org.scalatest.FunSuite

class AsciiTablesTests extends FunSuite{

  test("linearTables should contain predefined tables") {
    assert(AsciiTables.linearTables("bourke-small") == "@%#*+=-:,. ")
    assert(AsciiTables.linearTables("bourke-large") == "$@B%8&WM#*oahkbdpqwmZO0QLCJUYXzcvunxrjft/\\|()1{}[]?-_+~<>i!lI;:,\"^`'. ")
  }

  test("nonLinearTables should contain predefined tables") {
    assert(AsciiTables.nonLinearTables("non-linear-large") == "@@@@@@@@@@@@@@@@@@@@@$%^&*+++++++++++++^^^^^^^^^^^!!!!!!!!..............                   ")
    assert(AsciiTables.nonLinearTables("non-linear-medium") == "@@%++**----:;~,  ")
    assert(AsciiTables.nonLinearTables("non-linear-small") == "@@%++**--  ")
    assert(AsciiTables.nonLinearTables("non-linear-xlarge") == "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@%++**----:;~,~~~~~~~~~~~~~..............................                               ")
  }

  test("default should be a predefined string") {
    assert(AsciiTables.default == "@%#*+=-:,.       ")
  }

}
