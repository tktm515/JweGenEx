package com.kensyuu.jge.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kensyuu.jge.bean.GroupAccount;
import com.kensyuu.jge.bean.Schedule;
import com.kensyuu.jge.service.ScheduleManager;

/**
 * Servlet implementation class AddScheduleServlet
 */
@WebServlet("/addSchedule")
public class AddScheduleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddScheduleServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		GroupAccount groupAccount = (GroupAccount)session.getAttribute("groupAccount");
		groupAccount.getGroupName();
		RequestDispatcher dispatcher =
				request.getRequestDispatcher("/WEB-INF/page/addSchedule.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		//セッションスコープからログインgroupAccount情報
		//リクエストパラメータから入力情報取得
		HttpSession session = request.getSession();
		GroupAccount loginAccount = (GroupAccount)session.getAttribute("groupAccount");

		int groupId = loginAccount.getId();
		String date = request.getParameter("date");
		String startTime = request.getParameter("startTime");
		String endTime = request.getParameter("endTime");
		String title = request.getParameter("title");
		String place = request.getParameter("place");

		//取得した値をscに格納
		Schedule sc = new Schedule();
		sc.setGroupId(groupId);
		sc.setDate(date);
		sc.setStartTime(startTime);
		sc.setEndTime(endTime);
		sc.setTitle(title);
		sc.setPlace(place);
		//エラーチェック・メッセージ格納
		List<String> emgList = sc.validate();
		if(emgList.size() != 0) {
			request.setAttribute("messageList", emgList);
			request.setAttribute("schedule", sc);

			RequestDispatcher dispatcher =
					request.getRequestDispatcher("/WEB-INF/page/addSchedule.jsp");
			dispatcher.forward(request, response);
		}
		ScheduleManager sm = new ScheduleManager();
		sm.addSchedule(sc);
		//リダイレクト
		response.sendRedirect("/JweGenEx/scheduleList");

	}

}
