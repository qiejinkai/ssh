package com.qjk.ssh.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qjk.ssh.data.User;
import com.qjk.ssh.group.ValidateInPost;
import com.qjk.ssh.service.IUserService;


@Controller
@RequestMapping("/user")
public class UserController {
	
	@Resource
	IUserService userService;
	
	@RequestMapping(value="/users",method=RequestMethod.GET)
	public String users(Model model){
		
		List<User>list = userService.queryUser();
		model.addAttribute("users", list);
		
		return "user/users";
	}
	
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public String add(@ModelAttribute("user") User user){
		
		return "user/add";
	}
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String add(@Validated(value={ValidateInPost.class}) User user,BindingResult result){
		if(result.hasErrors()){
			return "user/add";
		}
		userService.addUser(user);
		return "redirect:/user/users";
	}
	
	
	
	@RequestMapping(value="/{id}/update",method=RequestMethod.GET)
	public String update(Model model,@PathVariable long id){
		User user = userService.findUserById(id);
		if(user == null){
			return "redirect:/user/users";
		}
		model.addAttribute("user", user);
		return "user/update";
	}
	
	@RequestMapping(value="/{id}/update",method=RequestMethod.POST)
	public String update(@Validated User user,BindingResult result){
		if(result.hasErrors()){
			return "user/update";
		}
		userService.updateUser(user);
		return "redirect:/user/users";
	}
	
	@RequestMapping(value="/{id}/delete",method=RequestMethod.GET)
	public String delete(@PathVariable long id){
		User u = new User();
		u.setUid(id);
		userService.deleteUser(u);
		return "redirect:/user/users";
	}
	
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public String show(@PathVariable long id,Model model){
		model.addAttribute(userService.findUserById(id));
		return "user/show";
	}

	@RequestMapping(value="/show",method=RequestMethod.GET)
	@ModelAttribute
	public User show(@RequestParam("id") long id){
//		model.addAttribute(list.get(phone));
		return userService.findUserById(id);
	}
	@RequestMapping(value="/{id}",method=RequestMethod.GET,params={"json"})
	@ResponseBody
	public User show(@PathVariable long id,String json){
		//model.addAttribute(list.get(phone));
		return userService.findUserById(id);
}
	
}
