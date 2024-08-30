package com.samanecorp.secure.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.samanecorp.secure.dto.AccountUserDto;
import com.samanecorp.secure.entities.AccountUserEntity;
import com.samanecorp.secure.service.AccountUserService;
import com.samanecorp.secure.service.IAccountUserService;



/**
 * Servlet implementation class AdminServlet
 */
@WebServlet(name = "singup", value = "/singup")
public class SingUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IAccountUserService accountUserService = new AccountUserService();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SingUpServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Optional<List<AccountUserDto>> users = accountUserService.findAll();
		if (users.isPresent()) {
			request.setAttribute("userList", users.get());
		} else {
			request.setAttribute("userList", new ArrayList<AccountUserEntity>());
		}

		request.getRequestDispatcher("singup.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String email = request.getParameter("email");
		String password = request.getParameter("password");
		boolean etat = Boolean.valueOf(request.getParameter("etat"));

		AccountUserDto accountUserDto = new AccountUserDto();

		accountUserDto.setEmail(email);
		accountUserDto.setPassword(password);
		accountUserDto.setState(etat);
		try {
			accountUserService.save(accountUserDto);
		} catch (Exception e) {

		}

		doGet(request, response);
	}

}
