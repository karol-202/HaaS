package pl.karol202.haas

import java.net.Socket
import kotlin.concurrent.thread

class ClientHandler(socket: Socket,
                    private val name: String)
{
    private val input = socket.getInputStream().reader()
    private val output = socket.getOutputStream().writer()

    fun handle() = thread {
        input.forEachLine { handlePacket(it) }
    }

    private fun handlePacket(packet: String) = output.write("${getResponse(packet)}\n").also { output.flush() }

    private fun getResponse(packet: String) = when(packet)
    {
        "Hello" -> name
        else -> "Hello"
    }
}
