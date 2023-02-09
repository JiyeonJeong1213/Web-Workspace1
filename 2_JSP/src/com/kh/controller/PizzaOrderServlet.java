package com.kh.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PizzaOrderServlet
 */
@WebServlet("/test.do")
public class PizzaOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PizzaOrderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1) 전달값 중에 한글이 있을 경우 인코딩 처리 (post방식일 때만)
		request.setCharacterEncoding("UTF-8");
		
		// 2) 요청시 전달값 뽑기 및 데이터 가공처리 => 변수, 객체로 기록
		String pizza = request.getParameter("pizza");
		String[] toppings = request.getParameterValues("topping");
		String[] sides = request.getParameterValues("side");
		int price = 0;
		
		switch(pizza) {
		case "치즈피자" : price += 5000; break; 
		case "콤비네이션피자" : price += 6000; break;
		case "포테이토피자" : price += 7000; break;
		case "고구마피자" : price+=7000; break;
		case "불고기피자" : price+=8000; break;
		}
		if(toppings != null) {
			for(String topping:toppings) {
				switch(topping) {
				case "고구마무스" : price+=1000; break;
				case "콘크림무스" : price+=1500; break;
				case "파인애플토핑" : price+=2000;break;
				case "치즈토핑" : price += 2000; break;
				case "치즈크러스트" : price+=2000;break;
				case "치즈바이트" : price+=3000; break;
				}
			}
		}
		if(sides != null) {
			for(String side:sides) {
				switch(side) {
				case "오븐구이통닭" : price+=9000; break;
				case "치킨스틱&윙" : price+=4900; break;
				case "치즈오븐스파게티" : price+=4000; break;
				case "새우링&웨지감자" : price+=3500; break;
				case "갈릭포테이토" : price+=3000; break;
				case "콜라" : price+=1500; break;
				case "사이다" : price+=1500; break;
				case "갈릭소스" : price+=500; break;
				case "피클" : price+=300; break;
				case "핫소스" : price+=100; break;
				case "파마산 치즈가루" : price+=100; break;
				}
			}
		}
		
		request.setAttribute("pizza", pizza);
		request.setAttribute("toppings", toppings);
		request.setAttribute("sides", sides);
		request.setAttribute("price", price);
		
//		RequestDispatcher view = request.getRequestDispatcher("views/responsePage.jsp");
//		view.forward(request, response);
		
		request.getRequestDispatcher("views/responsePage.jsp").forward(request, response);
	}

}
