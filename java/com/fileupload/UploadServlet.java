package com.fileupload;

import java.io.IOException;
import java.util.Collection;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

@MultipartConfig
@SuppressWarnings("serial")
@WebServlet("/file")
public class UploadServlet extends HttpServlet{
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
	{
		try
		{
			Collection<Part> parts=req.getParts();
			for(Part part:parts)
			{
				part.write("C:/Users/Acer/Desktop/Angular/FileFolder/"+part.getSubmittedFileName());
			}
			res.getWriter().println("File Uploaded");
		}
		catch(Exception e)
		{
			e.printStackTrace();
			res.getWriter().println("Upload failed");
		}
	}
}
