package org.kakarrot.baisccontroller;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/temp")
public class tmpPWController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("image/gif");
		
		BufferedImage image = 
				new BufferedImage(300, 300, BufferedImage.TYPE_INT_RGB); //메모리에 이미지 만들기
		
		
		Graphics g = image.getGraphics();
		
		g.setColor(Color.pink);
		g.fillRect(0, 0, 300, 300);
		
		String text = "" + (int)(Math.random()* 100000);
		g.setFont(new Font("Serif",Font.BOLD,50));
		g.setColor(Color.black);
		g.drawString(text, 20, 130);
		
		OutputStream os = 
				resp.getOutputStream();
		ImageIO.write(image, "GIF", os);
	
	}
	
}
