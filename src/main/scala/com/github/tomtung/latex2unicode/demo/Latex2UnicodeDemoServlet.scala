package com.github.tomtung.latex2unicode.demo

import org.scalatra._
import com.github.tomtung.latex2unicode._

class Latex2UnicodeDemoServlet extends Latex2unicodedemoStack {

  post("/q") {
    LaTeX2Unicode.convert(params("tex"))
  }

  get("/q") {
    redirect("/")
  }

}
