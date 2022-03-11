package seamcarving

import java.awt.Color
import java.awt.image.BufferedImage
import java.io.File
import javax.imageio.ImageIO

fun main() {
    println("Enter rectangle width:")
    val width = readLine()!!.toInt()
    println("Enter rectangle height:")
    val height = readLine()!!.toInt()
    println("Enter output image name:")
    val fileName = readLine()!!
    val inputFile = File(fileName)
    val image = BufferedImage(width, height, BufferedImage.TYPE_INT_RGB)
    val graphics = image.createGraphics()
    graphics.background = Color.BLACK
    graphics.color = Color.BLACK
    graphics.fillRect(0, 0 , width, height)
    graphics.color = Color.RED
    graphics.drawLine(0, 0, width - 1, height - 1)
    graphics.drawLine(-1, height, width - 1, 0)
    ImageIO.write(image, "png", inputFile)
}
