package com.practice.Response;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/reponse/test")
public class ResponseApp extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("image/jpg");
		ServletOutputStream sos = response.getOutputStream();

		File file = new File("C:\\Users\\malep\\eclipse-workspace\\ServletApp\\jai.jpg");
		FileInputStream fis = new FileInputStream(file);
		byte[] b = new byte[(int) file.length()];
		fis.read(b);

		sos.write(b);
		sos.flush();
		fis.close();
		sos.close();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
