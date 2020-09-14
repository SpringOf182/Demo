package com.demo;

import com.demo.BaseTest;
import com.demo.controller.BookListController;
import com.demo.pojo.Book;
import com.demo.service.BookListService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


//@Transactional
//@TransactionConfiguration(defaultRollback = false, transactionManager = "transactionManager")
public class BookList extends BaseTest {
    @Autowired
    private BookListController bookListController;
    @Autowired
    BookListService bookListService;

    @Test
    public void testGetAll() throws Exception{
        //List<Book> list = bookListController.getAllBook();
        List<Book> list = new ArrayList<>();
        Book book = list.get(0);
        System.out.println("输出测试！！！"+ book.getBookName());
    }

    @Test
    public void testUpdate() throws Exception{
        Book book=new Book();
        book.setBookID(6);
        book.setRemainNum(5);
        System.out.println("输出测试！！！"+ bookListController.changeRemainNum(book));
    }

}
