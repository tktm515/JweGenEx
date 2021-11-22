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
 * Servlet implementation class ScheduleListServlet
 */
@WebServlet("/scheduleList")
public class ScheduleListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ScheduleListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//セッションスコープよりgaにグループアカウント情報格納
		HttpSession session = request.getSession();
		GroupAccount loginAccount = (GroupAccount)session.getAttribute("groupAccount");

		//スケジュールリストをIDから取得格納
		ScheduleManager sm = new ScheduleManager();
		List<Schedule> scheduleList = sm.findScheduleByGroupId(loginAccount.getId());

		//リクエストスコープに保存
		request.setAttribute("scheduleList", scheduleList);
		RequestDispatcher dispatcher =
				request.getRequestDispatcher("/WEB-INF/page/scheduleList.jsp");
		dispatcher.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
