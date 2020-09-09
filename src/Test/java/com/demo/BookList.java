package com.demo;

import com.demo.BaseTest;
import com.demo.controller.BookListController;
import com.demo.pojo.Book;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


//@Transactional
//@TransactionConfiguration(defaultRollback = false, transactionManager = "transactionManager")
public class BookList extends BaseTest {
    @Autowired
    private BookListController bookListController;

    @Test
    public void testGetAll() throws Exception{
        List<Book> list = bookListController.getAllBook();
        Book book = list.get(0);
        System.out.println("输出测试！！！"+ book.getBookName());
    }

}
