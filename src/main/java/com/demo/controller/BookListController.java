package com.demo.controller;

import com.demo.pojo.Book;
import com.demo.service.BookListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
public class BookListController {

    @Autowired
    BookListService bookListService;
    /*@ModelAttribute(value = "book")
    public Book book() {
        return new Book();
    };*/


    @RequestMapping(value = "/getBookList.action",method = RequestMethod.GET)
    @ResponseBody
    public List<Book> getAllBook(){
        return bookListService.getAll();
    }
    /*public String getAllBook(Model model){
        List<Book> bookList = bookListService.getAll();
        System.out.println(bookList);
        model.addAttribute("bookList", bookList);
        System.out.println(model);
        return "show.html";
    }
    public ModelAndView getAllBook(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("BookList.jsp");//参数为指定页面
        List<Book> bookList = bookListService.getAll();
        modelAndView.addObject("bookList", bookList);
        return modelAndView;
    }*/

    @RequestMapping(value = "/getBookListByCategory.action",method = RequestMethod.POST)
    @ResponseBody
    public List<Book> getBookByCategory(@RequestBody Integer category){
        return bookListService.getBookListByCategory(category);
    }
    /*public ModelAndView getBookByCategory(HttpServletRequest request){
        Integer category = Integer.valueOf(request.getParameter("category"));
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("BookList");//参数为指定页面
        List<Book> bookList = bookListService.getBookListByCategory(category);
        modelAndView.addObject("bookList", bookList);
        return modelAndView;
    }*/

    @RequestMapping(value = "/addBook.action",method = RequestMethod.POST)
    @ResponseBody
    public List<Book> addBook(@RequestBody Book book) {
        //@RequestBody 同时请求header应为'content-type': 'application/json',
        bookListService.addBook(book);
        return bookListService.getAll();
    }
    /*public String addBook(@ModelAttribute @Valid Book book, Model model){
        bookListService.addBook(book);
        List<Book> bookList = bookListService.getAll();
        model.addAttribute("bookList", bookList);
        return "show.html";//参数为指定页面
    }*/

    @RequestMapping(value = "/deleteBook.action",method = RequestMethod.POST)
    @ResponseBody
    public List<Book> deleteBook(@RequestBody Integer bookId){
        //Integer bookId = Integer.parseInt(request.getParameter("bookId").trim());
        bookListService.deleteBook(bookId);
        return bookListService.getAll();
    }
    /*public String deleteBook(Integer bookID,Model model){
        bookListService.deleteBook(bookID);
        List<Book> bookList = bookListService.getAll();
        model.addAttribute("bookList", bookList);
        return "show.html";//参数为指定页面
    }*/

    @RequestMapping(value = "/changeRemainNum.action",method = RequestMethod.POST)
    @ResponseBody
    public List<Book> changeRemainNum(@RequestBody Book book){
        System.out.println("++++++++++>>>>>>>");
        System.out.println("++++++++++>>>>>>>"+book);
        bookListService.changeRemainNum(Integer.valueOf(book.getBookID()),Integer.valueOf(book.getRemainNum()));
        return bookListService.getAll();
    }
}
