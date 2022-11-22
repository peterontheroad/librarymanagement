package com.peter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import com.peter.entity.Book;
import com.peter.mapper.BookMapper;

@Controller
public class BookController {
	@Autowired
	private BookMapper bookMapper;
	
	@GetMapping("/list")
	public String listAll(Model model) {
		List<Book> books=bookMapper.selectAll();
		model.addAttribute("books",books);
		return "/books/list";
	}
	
	@GetMapping("/")
	public String toppage(Model model) {
		List<Book> books=bookMapper.selectAll();
		model.addAttribute("books",books);
		return "/books/index";
	}
	
	@GetMapping("/books/details/id={id}")
	public String details(@PathVariable("id") long id,Model model) {
		Book book=bookMapper.selectOne(id);
		model.addAttribute("book",book);
		return "/books/details";
	}
	
	@GetMapping("/books/register")
	public String register1(Model model,@ModelAttribute Book book) {
		model.addAttribute("book",book);
		return "books/register";
	}
	
	@PostMapping("/books/register")
	public String register2(@Validated @ModelAttribute Book book,BindingResult result) {
		if(result.hasErrors()) {
			return "books/register";
		}
		bookMapper.insertOne(book);
		return "redirect:/";
	}
	
	@PostMapping("/books/delete/id={id}")
	public String delete(@PathVariable long id,@ModelAttribute Book book) {
		bookMapper.deleteOne(book);
		return "redirect:/";
	}
	
	@GetMapping("books/update/id={id}")
	public String update1(@PathVariable("id") long id,Model model) {
		model.addAttribute("book",bookMapper.selectOne(id));
		return "books/update";
	}
	
	@PostMapping("/books/update/id={id}")
	public String update2(@ModelAttribute Book book,Model model) {
		bookMapper.updateOne(book.getId(), book.getTitle(), book.getAuthor(), book.getSn());
		return "redirect:/";
	}
	
	@GetMapping("/aaa")
	public String test1() {
		return "books/aaa";
	}
	
	
}
