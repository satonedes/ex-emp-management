package jp.co.sample.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.sample.domain.Administrator;
import jp.co.sample.form.InsertAdministratorForm;
import jp.co.sample.form.LoginForm;
import jp.co.sample.service.AdministratorService;

@Controller
@RequestMapping("/")
public class AdministratorController {
	
	@Autowired
	private AdministratorService administratorService;
	
	@ModelAttribute
	public InsertAdministratorForm setUpInsertAdministractorForm() {
		InsertAdministratorForm adForm = new InsertAdministratorForm();
		return adForm;
	}
	@RequestMapping("/toInsert")
	public String toInsert() {
		return "administrator/insert";
	}
	@RequestMapping("/insert")
	public String insert(InsertAdministratorForm form) {
		Administrator administrator = new Administrator();
		BeanUtils.copyProperties(form, administrator);
		administratorService.insert(administrator);
		return "redirect:/";
	}
	@ModelAttribute
	public LoginForm setUploginForm() {
		return new LoginForm();
//		return setUploginForm();
	}
	@RequestMapping("/")
	public String toLogin() {
		return "administrator/login";
	}
	@Autowired
	private HttpSession session;
	
	@RequestMapping("/login")
	public String login(LoginForm form, Model model) {
		Administrator administrator = administratorService.login(form.getMailAddress(), form.getPassword());
		if(administrator == null) {
			String error = "メールアドレスまたはパスワードが不正です。";
			model.addAttribute("error", error);
			return "administrator/login";
		}else {
			session.setAttribute("administratorName", administrator.getName());
		}
		return "forward:/employee/showList";
	}
}
