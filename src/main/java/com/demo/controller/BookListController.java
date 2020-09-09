package com.demo.controller;

import com.demo.pojo.Book;
import com.demo.service.BookListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class BookListController {

    @Autowired
    BookListService bookListService;

    @RequestMapping(value = "/getBookList.action",method = RequestMethod.GET)
    public List<Book> getAllBook(){
        return bookListService.getAll();
    }

    @RequestMapping(value = "/getBookListByCategory.action",method = RequestMethod.GET)
    public List<Book> getBookByCategory(HttpServletRequest request){
        Integer category = Integer.valueOf(request.getParameter("category"));
        return bookListService.getBookListByCategory(category);
    }

    @RequestMapping(value = "/addBook.action",method = RequestMethod.POST)
    public Boolean addBook(HttpServletRequest request){
        //(@RequestBody Book book)
        Book book = new Book();
        book.setCategory(Integer.parseInt(request.getParameter("category")));
        book.setBookName(request.getParameter("bookName"));
        book.setRemainNum(Integer.parseInt(request.getParameter("remainNum")));
        return bookListService.addBook(book);
    }

    @RequestMapping(value = "/deleteBook.action",method = RequestMethod.GET)
    public Boolean deleteBook(HttpServletRequest request){
        Integer bookId = Integer.parseInt(request.getParameter("bookId"));
        return bookListService.deleteBook(bookId);
    }

    @RequestMapping(value = "/changeRemainNum.action",method = RequestMethod.POST)
    public Boolean changeRemainNum(HttpServletRequest request){
        Integer newNumber = Integer.parseInt(request.getParameter("newNumber"));
        return bookListService.changeRemainNum(newNumber);
    }
}
