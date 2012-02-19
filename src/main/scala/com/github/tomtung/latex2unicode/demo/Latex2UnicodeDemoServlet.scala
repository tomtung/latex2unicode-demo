package com.github.tomtung.latex2unicode.demo

import org.scalatra._
import scalate.ScalateSupport
import com.github.tomtung.latex2unicode._

class Latex2UnicodeDemoServlet extends ScalatraServlet with ScalateSupport {

  post("/q") {
	LatexToUnicodeConverter.convert(params("tex"))
  }
  
  get("/q") {
	redirect("/")
  }
  
  notFound {
    // Try to render a ScalateTemplate if no route matched
    findTemplate(requestPath) map { path =>
      contentType = "text/html"
      layoutTemplate(path)
    } orElse serveStaticResource() getOrElse redirect("/")
  }
}
