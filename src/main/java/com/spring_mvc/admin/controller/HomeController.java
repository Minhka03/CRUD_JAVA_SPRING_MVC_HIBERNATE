package com.spring_mvc.admin.controller;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.spring_mvc.admin.dao.UserDAO;
import com.spring_mvc.admin.entities.User;
import com.spring_mvc.admin.security.entities.CustomUserDetails;


@Controller
public class HomeController {
	
	@Autowired
	private UserDAO userDao;
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String register(@ModelAttribute("users") User user) {
		
		
		return "admin/register";
	}
	@PostMapping(value = "/login")
	public String save(Model model, @RequestParam("username")String username,@RequestParam("password") String password, @RequestParam("email") String email) {
		User user = new User();
		System.out.println(password);
		password = new BCryptPasswordEncoder().encode(password);
		user.setUserName(username);
		user.setPassWord(password);
		user.setEmail(email);
		user.setEnabled(true);
		userDao.insert(user);
		return "admin/login";
		
	}
	
	@RequestMapping(value = "/login")
	public String login(@RequestParam(value = "error", required = false) String error, Model model) {
		if (error != null) {
			model.addAttribute("mess", "Login failed!");
		}
		return "admin/login";
	}

	@RequestMapping("/logout")
	public String logout(Model model) {
		model.addAttribute("mess", "Has Logged out!!!");
		return "admin/login";
	}
	
	
	@RequestMapping(value = "/checkrole")

	public String checkRole() {

	//lấy thông tin tài khoản

	CustomUserDetails account = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

	//duyệt role để kiểm tra và điều hướng

	for(var g: account.getAuthorities()) {

	if(g.getAuthority().equals("ROLE_ADMIN")) {

	return "redirect:/admin";

	}

	if(g.getAuthority().equals("ROLE_USER")) {

	return "redirect:/";

	}

	}

	return "admin/403";

	}
	
	@RequestMapping("/403")

	public String accessDenied(Model model) {

	model.addAttribute("msg", "BẠN KHÔNG CÓ QUYỀN TRUY CẬP VÀO TRANG NÀY");

	return "admin/403";

	}
	
	
	
	
	
	
}
