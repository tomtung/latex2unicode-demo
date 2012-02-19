import org.eclipse.jetty.server.Server
import org.eclipse.jetty.servlet.{DefaultServlet, ServletContextHandler}
import com.github.tomtung.latex2unicode.demo.Latex2UnicodeDemoServlet

object JettyLauncher {
  def main(args: Array[String]) {
    val port = if(System.getenv("PORT") != null) System.getenv("PORT").toInt else 8080

    val server = new Server(port)
    val context = new ServletContextHandler(server, "/", ServletContextHandler.SESSIONS)

    context.addServlet(classOf[Latex2UnicodeDemoServlet], "/*")
    context.addServlet(classOf[DefaultServlet], "/css/*");
    context.addServlet(classOf[DefaultServlet], "/js/*");
    context.setResourceBase("src/main/webapp")

    server.start
    server.join
  }

}

