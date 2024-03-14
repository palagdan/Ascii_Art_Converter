package ui.console

import converters.imageConverter.AsciiTables
import exporters.text.defaults.DefaultTextExporter
import exporters.text.mixed.MixedTextExporter
import exporters.text.special.{FileOutputExporter, StdOutputExporter}
import models.image.RGBImage
import org.scalatest.FunSuite
import filters.image.grayFilters.defaults.ImageIdentityFilter
import filters.image.grayFilters.mixed.MixedFilter
import filters.image.grayFilters.specific.flip.{FlipXFilter, FlipYFilter}
import filters.image.grayFilters.specific.{BrightnessFilter, InvertFilter}
import ui.ConsoleUI

class ConsoleParserTests extends FunSuite{


  test("parseArgs should return empty map when no arguments are passed") {
    val test = new ConsoleUI(Array.empty[String])
    assert(test.getParsedArgs == Map.empty)
  }

  test("parseArgs should return map with known flag") {
    val test = new ConsoleUI(Array("--image"))
    val actual = test.getParsedArgs
    val exptected = Map("image" -> Array.empty[String])
    assert(test.getParsedArgs.map{case (s, arr) => (s, arr.toSeq)} === exptected.map{ case (s, arr) => (s, arr.toSeq)})
  }


  test("parseArgs should return map with flag and values when flag is passed with values") {
    val test = new ConsoleUI(Array("--flip", "value1", "value2"))

    val actual = test.getParsedArgs
    val expected = Map("flip" -> Array("value1", "value2"))

    assert(actual.map { case (s, arr) => (s, arr.toSeq) } === expected.map { case (s, arr) => (s, arr.toSeq) })
  }


  test("parseArgs should throw IllegalArgumentException when unsupported flag is passed") {
    assertThrows[IllegalArgumentException] {
      val test = new ConsoleUI(Array("--images"))
    }
  }

  test("getImage should throw NoSuchElementException when no filename is provided") {
    val test = new ConsoleUI(Array("--image"))
    assertThrows[NoSuchElementException] {
      test.getImage
    }
  }

  test("getImage should load jpg image when jpg file is provided") {
    val test = new ConsoleUI(Array("--image", "images/test_image1.jpg"))
    assert(test.getImage.isInstanceOf[RGBImage])
  }

  test("getImage should load random image when --image-random flag is provided") {
    val test = new ConsoleUI(Array("--image-random"))
    assert(test.getImage.isInstanceOf[RGBImage])
  }

  test("getImage should throw Exception when no image flag is provided") {
    val test = new ConsoleUI(Array("--invert"))
    assertThrows[Exception] {
      test.getImage
    }
  }


  test("getGrayImageFilters should return ImageIdentityFilter when no filter flags are provided") {
    val test = new ConsoleUI(Array("--image"))
    assert(test.getGrayImageFilters == ImageIdentityFilter)
  }

  test("getGrayImageFilters should return InvertFilter when --invert flag is provided") {
    val test = new ConsoleUI(Array("--invert"))
    assert(test.getGrayImageFilters.isInstanceOf[InvertFilter])
  }

  test("getGrayImageFilters should throw NoSuchElementException when --brightness flag is provided without value") {
    val test = new ConsoleUI(Array("--brightness"))
    assertThrows[NoSuchElementException] {
      test.getGrayImageFilters
    }
  }

  test("getGrayImageFilters should return BrightnessFilter when --brightness flag is provided with value") {
    val test = new ConsoleUI(Array("--brightness", "10"))
    assert(test.getGrayImageFilters.isInstanceOf[BrightnessFilter])
  }

  test("getGrayImageFilters should throw NoSuchElementException when --flip flag is provided without value") {
    val test = new ConsoleUI(Array("--flip"))
    assertThrows[NoSuchElementException] {
      test.getGrayImageFilters
    }
  }

  test("getGrayImageFilters should return FlipXFilter when --flip flag is provided with 'x' value") {
    val test = new ConsoleUI(Array("--flip", "x"))
    assert(test.getGrayImageFilters.isInstanceOf[FlipXFilter])
  }

  test("getGrayImageFilters should return FlipYFilter when --flip flag is provided with 'y' value") {
    val test = new ConsoleUI(Array("--flip", "y"))
    assert(test.getGrayImageFilters.isInstanceOf[FlipYFilter])
  }

  test("getGrayImageFilters should return MixedFilter when multiple filter flags are provided") {
    val test = new ConsoleUI(Array("--invert", "--brightness", "10", "--flip", "x"))
    assert(test.getGrayImageFilters.isInstanceOf[MixedFilter])
  }

  test("getOutput should return DefaultTextExporter when no output flags are provided") {
    val test = new ConsoleUI(Array("--image"))
    assert(test.getOutput == DefaultTextExporter)
  }



  test("getOutput should throw NoSuchElementException when --output-file flag is provided without a filename") {
    val test = new ConsoleUI(Array("--output-file"))
    assertThrows[NoSuchElementException] {
      test.getOutput
    }
  }

  test("getOutput should return StdOutputExporter when --output-console flag is provided") {
    val test = new ConsoleUI(Array("--output-console"))
    assert(test.getOutput.isInstanceOf[StdOutputExporter])
  }

  test("getTable should return default table when no table flag is provided") {
    val test = new ConsoleUI(Array("--image"))
    assert(test.getTable == AsciiTables.default)
  }

  test("getTable should throw NoSuchElementException when --table flag is provided without a tablename") {
    val test = new ConsoleUI(Array("--table"))
    assertThrows[NoSuchElementException] {
      test.getTable
    }
  }

  test("getTable should return linear table when --table flag is provided with a linear tablename") {
    val test = new ConsoleUI(Array("--table", "bourke-large"))
    assert(test.getTable == AsciiTables.linearTables("bourke-large"))
  }

  test("getTable should return non-linear table when --table flag is provided with a non-linear tablename") {
    val test = new ConsoleUI(Array("--table", "non-linear-small"))
    assert(test.getTable == AsciiTables.nonLinearTables("non-linear-small"))
  }

  test("getTable should return the provided tablename when --table flag is provided with a tablename not in linear or non-linear tables") {
    val test = new ConsoleUI(Array("--table", "otherTablename"))
    assert(test.getTable == "otherTablename")
  }
}
