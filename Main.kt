package seamcarving

import java.awt.Color
import java.awt.image.BufferedImage
import java.io.File
import javax.imageio.ImageIO

private const val IN_ARGUMENT = "-in"
private const val OUT_ARGUMENT = "-out"

fun main(args: Array<String>) {
    invertPhoto(args)
//    drawCross()
}

private fun invertPhoto(args: Array<String>) {
    val inputFileName = if (args[0] == IN_ARGUMENT) args[1] else "in.png"
    val outputFileName = if (args[2] == OUT_ARGUMENT) args[3] else "out.png"
    val imageFile = File(inputFileName)
    val file = ImageIO.read(imageFile)

    val image = BufferedImage(file.width, file.height, BufferedImage.TYPE_INT_RGB)
    for (x in 0 until file.width) {
        for (y in 0 until file.height) {
            val color = Color(file.getRGB(x, y))
            val modifiedColor = Color(255 - color.red, 255 - color.green, 255 - color.blue)
            image.setRGB(x, y, modifiedColor.rgb)
        }
    }
    val outputFile = File(outputFileName)
    ImageIO.write(image, "png", outputFile)
}

private fun drawCross() {
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
    graphics.fillRect(0, 0, width, height)
    graphics.color = Color.RED
    graphics.drawLine(0, 0, width - 1, height - 1)
    graphics.drawLine(-1, height, width - 1, 0)
    ImageIO.write(image, "png", inputFile)
}
