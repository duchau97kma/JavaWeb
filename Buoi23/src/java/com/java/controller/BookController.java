/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.java.controller;

import DTO.Book;
import Model.BookModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


/**
 *
 * @author Winter
 */
@Controller
public class BookController {
    BookModel model = new BookModel();
    
    @RequestMapping("/index")
    public String getAllBook(Model mn) {
        
      mn.addAttribute("listBook", model.getAll());
        return "index";
    }
    @RequestMapping("/addbook")
    public String add(Model mn){
        Book Book = new Book();
        mn.addAttribute("command", Book);
        return "addbook";
    }
    @RequestMapping("/save")
    public String save(@ModelAttribute("book") Book book){
        model.addBook(book);
        return "redirect:/index";
    }
    @RequestMapping("/editBook")
    public String edit(@RequestParam("id") int id,Model mn){
        Book book = model.getBookById(id);
        mn.addAttribute("command", book);
        return "updateBook";
    }
    @RequestMapping("update")
    public String update(@ModelAttribute("book") Book book){
        model.updateBook(book);
        return "redirect:/index";
    }
  
    @RequestMapping("/delete")
    public String delete(@RequestParam("id") int id){
        model.deleteBook(id);
        return "redirect:/index";
    }
}
