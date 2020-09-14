//index.js
//获取应用实例
const app = getApp()
var utils = require("../../utils/util.js");


Page({
  data: {
	  bookList:[],
	  test:{
		  test:1
	  },
	  book:{},
	  updateBook:{},
  },
  onLoad: function () {
	  this.getAll();
	  console.log("初始数组：");
	  console.log([1,2,3]);
  },
  getAll: function() {
	  var url = app.globalData.url + "/getBookList.action";
	  console.log(url);
	  var data=null;
	  utils.httpGet(url, this.processClassInfo);
  },
  addBook:function(){
	  var book = this.data.book;
	  if (book.bookName != null && book.category != null && book.remainNum != null ){
		  var url = app.globalData.url + "/addBook.action";
		  console.log(url);
		  console.log("传入的data");
		  console.log(book);
		  utils.httpPost(url,book, this.processClassInfo);
	  }
	  else{
		  wx.showModal({
			  title: 'ERROR',
			  content: '信息不可为空!',
			  showCancel: false,
		  })
	  }
  },
  deleteBook:function(){
	  var bookID = this.data.bookID;
	  if (bookID != null) {
		  var url = app.globalData.url + "/deleteBook.action";
		  console.log(url);
		  //var data = { book };
		  console.log("传入的data");
		  console.log(bookID);
		  utils.httpPost(url, bookID, this.processClassInfo);
	  }
	  else {
		  wx.showModal({
			  title: 'ERROR',
			  content: '信息不可为空!',
			  showCancel: false,
		  })
	  }
  },
	updateNum: function () {
		var book = this.data.updateBook;
		if (book.bookID != null && book.remainNum != null) {
			var url = app.globalData.url + "/changeRemainNum.action";
			console.log(url);
			console.log("传入的data");
			console.log(book);
			utils.httpPost(url,book, this.processClassInfo);
		}
		else {
			wx.showModal({
				title: 'ERROR',
				content: '信息不可为空!',
				showCancel: false,
			})
		}
	},
	processClassInfo: function (res) {
		var that = this;
		console.log("bookList");
		console.log(res);
		//var bookList = res;
		//that.bookList = [];
		that.bookList = res;
		this.setData({
			bookList:res,
		});
		/*console.log("this.bookList");
		console.log(this.bookList);
		console.log("那么问题来了，bookList是数组吗？");
		console.log(that.bookList instanceof Array);
		console.log("内容是对象吗？");
		console.log(that.bookList[0] instanceof Object);
		console.log("能获取到对象属性吗？");
		console.log(that.bookList[0].bookName);*/
	},
	nameBlur: function (e) {
		var bookName = e.detail.value;
		this.data.book.bookName = bookName;
		//console.log("price");
		//console.log(price);
	},
	categoryBlur: function (e) {
		var category = e.detail.value;
		this.data.book.category = category;
		//console.log("price");
		//console.log(price);
	},
	numBlur: function (e) {
		var remainNum = e.detail.value;
		this.data.book.remainNum = remainNum;
		//console.log("price");
		//console.log(price);
	},
	idBlur: function (e) {
		var bookID = e.detail.value;
		this.data.bookID = bookID;
		//console.log("price");
		//console.log(price);
	},
	bookIdBlur: function (e) {
		var changeBookID = e.detail.value;
		this.data.updateBook.bookID = changeBookID;
		//console.log("price");
		//console.log(price);
	},
	newNumBlur: function (e) {
		var newNum = e.detail.value;
		this.data.updateBook.remainNum = newNum;
		//console.log("price");
		//console.log(price);
	},
})
