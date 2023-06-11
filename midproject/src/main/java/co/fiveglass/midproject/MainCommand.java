package co.fiveglass.midproject;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.fiveglass.midproject.common.Command;

public class MainCommand implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		
		return "main/main";
	}

}
