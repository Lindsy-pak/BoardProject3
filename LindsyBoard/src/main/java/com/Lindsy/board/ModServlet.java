package com.Lindsy.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.BoardDAO;
import Model.BoardVO;
import Utils.JspUtils;

@WebServlet("/mod")
public class ModServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardDAO dao = new BoardDAO();
		
		String boardNum = request.getParameter("boardNum");
		int no = Integer.parseInt(boardNum);
		
		request.setAttribute("data", dao.selboard(no));
		
		JspUtils.moveToJsp(request, response, "mod");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardDAO dao = new BoardDAO();
		BoardVO vo = new BoardVO();
		
		String BoardNum = request.getParameter("boardNum");
		int no = Integer.parseInt(BoardNum);
		String title = request.getParameter("title");
		String contents = request.getParameter("contents");
		
		vo.setBoardNum(no);
		vo.setTitle(title);
		vo.setContents(contents);
		
		dao.modBoard(vo);
		
		response.sendRedirect("/list");
	}

}
