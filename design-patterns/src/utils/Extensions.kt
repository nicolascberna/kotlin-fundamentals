package utils

import java.util.*

fun getOSName(): String {
    return System.getProperty("os.name").lowercase(Locale.getDefault())
}