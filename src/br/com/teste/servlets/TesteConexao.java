package br.com.teste.servlets;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.ifsp.livro.pool.Pool;



/**
 * Servlet implementation class TesteConexao
 */
@WebServlet("/TesteConexao")
public class TesteConexao extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private Connection conn = null;
    private Pool pool = new Pool();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TesteConexao() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.conn = pool.getConnection();
		
		if (this.conn != null){
			response.getWriter().println("Conexão realizada com sucesso!");
		}else
			response.getWriter().println("Problema com conexão!");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
