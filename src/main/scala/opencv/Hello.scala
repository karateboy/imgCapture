package opencv

import org.opencv.core.Core
import org.opencv.core.CvType
import org.opencv.core.Mat
import org.opencv.core.Point
import org.opencv.core.Scalar
import org.opencv.videoio.VideoCapture
import org.opencv.imgcodecs.Imgcodecs
import java.time._
import org.opencv.imgproc.Imgproc

object Hello extends Greeting with App {

  val cameraNo = {
    if (args.contains("-camera")) {
      1
    } else
      0
  }

  def handlArgs = {

  }
  def initOpenCV = {
    cam.release()
  }

  def cleanup = {
    cam.release

  }

  System.loadLibrary(Core.NATIVE_LIBRARY_NAME)
  val cam = new VideoCapture(0)
  println(s"cam is ${cam.isOpened()}")

  val now = java.time.LocalDateTime.now()
  val fmt = java.time.format.DateTimeFormatter.ofPattern("yyyyMMddHHmmss")
  val fmt2 = java.time.format.DateTimeFormatter.ofPattern("yy/MM/dd HH:mm:ss")
  val img = new Mat()
  cam.read(img)
  
  Imgproc.putText(img, s"${now.format(fmt2)}", new Point(10, 30), 
      Imgproc.FONT_HERSHEY_SIMPLEX, 1, new Scalar(200, 0, 0), 2);
  Imgcodecs.imwrite(s"${now.format(fmt)}.jpg", img)

  cleanup
}

trait Greeting {
  lazy val greeting: String = "hello"
}
