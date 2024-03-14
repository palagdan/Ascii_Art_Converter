package ui

import converters.imageConverter.AsciiTables
import exporters.text.defaults.DefaultTextExporter
import exporters.text.mixed.MixedTextExporter
import exporters.text.special.{FileOutputExporter, StdOutputExporter}
import exporters.text.{StreamTextExporter, TextExporter}
import filters.image.grayFilters.GrayImageFilter
import filters.image.grayFilters.defaults.ImageIdentityFilter
import filters.image.grayFilters.mixed.MixedFilter
import filters.image.grayFilters.specific.{BrightnessFilter, InvertFilter}
import filters.image.grayFilters.specific.flip.{FlipXFilter, FlipYFilter}
import loaders.imageLoaders.{JpgImageLoader, PngImageLoader, RandomImageLoader}
import models.image.RGBImage

import java.io.File


/**
 * ConsoleUI is a class that parses command-line arguments for a console-based user interface.
 * It extends the UI trait, providing methods to extract specific parameters and configurations
 * for image processing, filters, output options, and ASCII tables.
 *
 * @param args An array of command-line arguments passed to the console.
 */
class ConsoleUI(args: Array[String]) extends UI {

  /**
   * Private member to store the parsed command-line arguments.
   */
  private val parsedArgs = parseArgs(args)


  def getParsedArgs: Map[String, Array[String]] = parsedArgs
  /**
   * Private method to define the supported command-line flags.
   */
  private def flags: Seq[String] = Seq("image", "image-random", "invert", "brightness",
    "flip", "output-file", "output-console", "table")

  /**
   * Private method to parse command-line arguments into a map of flag-value pairs.
   *
   * @param args The array of command-line arguments.
   * @return A Map containing flag-value pairs parsed from the command-line arguments.
   * @throws IllegalArgumentException if an unsupported flag is encountered.
   */
  private def parseArgs(args: Array[String]): Map[String, Array[String]] = {
    val mutableMap: scala.collection.mutable.Map[String, Array[String]] = scala.collection.mutable.Map()

    var lastKey: Option[String] = None

    args.foldLeft((mutableMap, Option.empty[String])) { case ((map, lastKey), arg) =>
      if (arg.startsWith("--")) {
        val key = arg.stripPrefix("--")
        if (map.contains(key)) {
          (map, Some(key))
        } else if (flags.contains(key)) {
          map.put(key, Array.empty[String]) // Add a new key with an empty value
          (map, Some(key))
        } else {
          throw new IllegalArgumentException("The flag " + key + " does not exists!")
        }
      } else {
        lastKey match {
          case Some(key) =>
            val currentValues = map(key)
            map.update(key, currentValues :+ arg) // Update the last key with the new value
            (map, lastKey)
          case None =>
            (map, lastKey) // Ignore values that don't have a preceding key
        }
      }
    }


    mutableMap.toMap
  }

  /**
   * Retrieves an RGB image based on the parsed command-line arguments.
   *
   * @return An RGBImage object representing the parsed image.
   * @throws NoSuchElementException if the required parameters for image loading are not provided.
   * @throws Exception              if the retrieved image is null.
   */
  def getImage: RGBImage = {
    var image: RGBImage = null
    parsedArgs.foreach{ case (key, value) =>
      key match {
        case "image" =>
          if (value.isEmpty) {
            throw new NoSuchElementException("No filename in the output-file array.")
          }
          val filename = value(0)
          val file = new File(filename)
          val extension = filename.split("\\.").last
          extension match {
            case "jpg" => image = new JpgImageLoader(file).load()
            case "png" => image = new PngImageLoader(file).load()
            case _ => throw new IllegalArgumentException("The extension ." + extension + " is not supported!")
          }
        case "image-random" => image = RandomImageLoader.load()
        case _ =>
       }
    }
    if(image == null)
      throw new Exception("Image parameter is null!")
    image
  }


  /**
   * Retrieves a GrayImageFilter based on the parsed command-line arguments.
   *
   * @return A GrayImageFilter representing the parsed filters.
   */
  def getGrayImageFilters: GrayImageFilter = {
      var filters: Array[GrayImageFilter] = Array()

      parsedArgs.foreach{ case (key, value) =>
        key match {
          case "invert" =>
            filters = filters :+  new InvertFilter()
          case "brightness" =>
            if(value.isEmpty){
              throw new NoSuchElementException("No elements in the Brightness filter array")
            }
            val brightness = value(0).toInt
            filters = filters :+ new BrightnessFilter(brightness)

          case "flip" =>
            if (value.isEmpty) {
              throw new NoSuchElementException("No elements in the flip filter array")
            }
            value.foreach {
              case "x" =>
                filters = filters :+ new FlipXFilter()
              case "y" =>
                filters = filters :+ new FlipYFilter()
              case _ =>
            }
          case _ =>
        }
      }
    if (filters.isEmpty)
      ImageIdentityFilter
    else if(filters.length == 1)
      filters(0)
    else
      new MixedFilter(filters)
  }

  /**
   * Retrieves a TextExporter for output based on the parsed command-line arguments.
   *
   * @return A TextExporter representing the parsed output options.
   */
  def getOutput: TextExporter = {
      var outputs: Array[StreamTextExporter] = Array()
     parsedArgs.foreach{case (key, value) =>
       key match {
         case "output-file" =>
            if(value.isEmpty) {
              throw new NoSuchElementException("No filename in the output-file array.")
            }
           val file: File = new File(value(0))
           outputs = outputs :+ new FileOutputExporter(file)
         case "output-console" =>
            outputs = outputs :+ new StdOutputExporter
         case _ =>
       }
     }
    if(outputs.isEmpty)
      DefaultTextExporter
    else if(outputs.length == 1)
      outputs(0)
    else
      new MixedTextExporter(outputs)
  }

  /**
   * Retrieves an ASCII table configuration based on the parsed command-line arguments.
   *
   * @return A String representing the ASCII table configuration.
   * @throws NoSuchElementException if the required parameters for table configuration are not provided.
   */
  def getTable: String = {
    var table: String = AsciiTables.default
    parsedArgs.foreach{ case (key, value) =>
      key match {
        case "table" =>
          if (value.isEmpty){
            throw new NoSuchElementException("No table for the table array.")
          }
          val tablename = value(0)
          if(AsciiTables.linearTables.contains(tablename))
            table = AsciiTables.linearTables(tablename)
          else if(AsciiTables.nonLinearTables.contains(tablename))
            table = AsciiTables.nonLinearTables(tablename)
          else
            table = value(0)
        case _ =>
      }
    }
    table
  }
}
