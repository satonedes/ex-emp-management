package jp.co.sample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.sample.form.InsertAdministractorForm;
import jp.co.sample.service.AdministractorService;

@Controller
@RequestMapping("/")
public class AdministractorController {
	
	@Autowired
	private AdministractorService administractorService;
	
	@ModelAttribute
	public InsertAdministractorForm setUpInsertAdministractorForm() {
		InsertAdministractorForm adForm = new InsertAdministractorForm();
		return adForm;
	}
	@RequestMapping("/toInsert")
	public String toInsert() {
		return "administrator";
	}
}
