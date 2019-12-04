package pl.karol202.haas

import java.net.ServerSocket

fun main()
{
    println("Starting HaaS (Hello as a Service)")
    val nameProvider = NameProvider()
    val serverSocket = ServerSocket(5000)
    while(true) ClientHandler(serverSocket.accept(), nameProvider.getName()).handle()
}
