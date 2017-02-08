import com.github.tomtung.latex2unicode.demo._
import org.scalatra._
import javax.servlet.ServletContext

class ScalatraBootstrap extends LifeCycle {
  override def init(context: ServletContext) {
    context.mount(new Latex2UnicodeDemoServlet, "/*")
  }
}
