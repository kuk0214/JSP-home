package com.increpas.cafe.controller;

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

public interface CafeController {
	
	String exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException;
}
