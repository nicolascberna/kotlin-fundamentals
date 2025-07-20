package structural.facade.template

import java.io.File

class VideoFile(private val name: String) {
    val codecType: String = name.substring(name.indexOf(".") + 1)
}

interface Codec

class MPEG4CompressionCodec : Codec {
    val type = "mp4"
}

class OggCompressionCodec : Codec {
    val type = "ogg"
}

class CodecFactory {
    fun extract(file: VideoFile): Codec {
        val type = file.codecType
        if (type == "mp4") {
            println("CodecFactory: extracting mpeg audio...")
            return MPEG4CompressionCodec()
        } else {
            println("CodecFactory: extracting ogg audio...")
            return OggCompressionCodec()
        }
    }
}

object BitrateReader {
    fun read(file: VideoFile, codec: Codec): VideoFile {
        println("BitrateReader: reading file...")
        return file
    }

    fun convert(buffer: VideoFile, codec: Codec): VideoFile {
        println("BitrateReader: writing file...")
        return buffer
    }
}

object AudioMixer {
    fun fix(result: VideoFile): File {
        println("AudioMixer: fixing audio...")
        return File("tmp")
    }
}

//Facade
internal class VideoConversionFacade {
    fun convertVideo(fileName: String, format: String): File {
        println("VideoConversionFacade: conversion started.")
        val file = VideoFile(fileName)
        val sourceCodec = CodecFactory().extract(file)
        val destinationCodec: Codec = if (format == "mp4") {
            MPEG4CompressionCodec()
        } else {
            OggCompressionCodec()
        }
        val buffer: VideoFile = BitrateReader.read(file, sourceCodec)
        val intermediateResult = BitrateReader.convert(buffer, destinationCodec)
        val result: File = AudioMixer.fix(intermediateResult)
        println("VideoConversionFacade: conversion completed")
        return result
    }
}

fun main() {
    val converter: VideoConversionFacade = VideoConversionFacade()
    val mp4Video = converter.convertVideo("video.ogg", "mp4")
}
