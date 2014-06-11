package br.com.livros.tags;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.Tag;

import br.com.ifsp.livro.pool.Pool;

public class ExibeLivros implements Tag{

	private PageContext context;
	private Connection coon = new Pool().getConnection();
	
	@Override
	public int doEndTag() throws JspException {
		return EVAL_PAGE;
	}

	@Override
	public int doStartTag() throws JspException { 
		try {
			String sql = "select * from livro";
			ResultSet rs = this.coon.prepareStatement(sql).executeQuery();
			
			rs.last();
			if (rs.getRow() < 1){
				this.context.getOut().println("Não há dados a serem consultados");
			}else {
				rs.beforeFirst();
				
				while (rs.next()){
					this.context.getOut().println(rs.getString(1));
				}
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return EVAL_BODY_INCLUDE;
	}

	@Override
	public Tag getParent() {
		return null;
	}

	@Override
	public void release() {
		try {
			this.coon.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void setPageContext(PageContext pc) {
		this.context = pc;
	}

	@Override
	public void setParent(Tag arg0) {
		System.out.println("Por implementar");
	}

}
