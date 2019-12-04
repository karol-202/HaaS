package pl.karol202.haas

import java.io.File

class NameProvider
{
    private val names = loadNames()
    private var nameCounter = 0

    private fun loadNames() = File("imiona.txt").readLines()

    fun getName(): String {
        if (nameCounter >= names.size) nameCounter = 0
        return names[nameCounter++]
    }
}
