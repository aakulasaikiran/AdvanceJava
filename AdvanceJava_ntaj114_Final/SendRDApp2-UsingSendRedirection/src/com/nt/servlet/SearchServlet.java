package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SearchServlet extends HttpServlet {
	
  @Override
  	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	  PrintWriter pw=null;
	  String ss=null;
	  String engine=null;
	  String url=null;
	  //general settings
	  pw=res.getWriter();
	  res.setContentType("text/html");
	  //read form data
	  ss=req.getParameter("search");
	  engine=req.getParameter("engine");
	  //prepare url based on the search engine that is selected
	  if(engine.equalsIgnoreCase("google")){
		  url="https://www.google.co.in/search?q="+ss;
	  }
	  else if(engine.equalsIgnoreCase("bing")){
		  url="http://www.bing.com/search?q="+ss;
	  }
	  else{
		  url="https://in.search.yahoo.com/search?p="+ss;
	  }
	  
	  //perform sendRedirection
	  res.sendRedirect(url);
	  RequestDispatcher rd=req.getRequestDispatcher("/myfile.html");
	  rd.include(req,res);
	  //close stream
	  pw.close();
  	}//doGet(-,-)
  
  @Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	    doGet(req,res);
	}
}//class
