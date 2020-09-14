const formatTime = date => {
  const year = date.getFullYear()
  const month = date.getMonth() + 1
  const day = date.getDate()
  const hour = date.getHours()
  const minute = date.getMinutes()
  const second = date.getSeconds()

  return [year, month, day].map(formatNumber).join('/') + ' ' + [hour, minute, second].map(formatNumber).join(':')
}

const formatNumber = n => {
  n = n.toString()
  return n[1] ? n : '0' + n
}

//回调函数的参数可能要改，List，Map返回数据有待研究
function httpGet(url, callBack) {
	console.log("Get请求");
	wx.request({
		url: url,
		header: {
			'content-type': 'application/x-www-form-urlencoded;charset=utf-8',
		},
		success: function (res) {
			console.log("请求到东西了，下面是返回");
			console.log(res);
			if (res.statusCode != 200) {
				wx.showModal({
					title: '提示',
					content: '服务器或操作错误，请重试',
					showCancel: false
				})
			} else {
				console.log(url + "->res：");
				console.log(res);
				callBack(res.data);
			}
		},
		error: function (res) {
			console.log(url + '接口调用失败');
		}
	})
}

function httpPost(url, data, callBack) {
	wx.request({
		url: url,
		header: {
			'content-type': 'application/json;charset=utf-8',
		},
		data: data,
		method: "POST",
		success: function (res) {
			if (res.statusCode != 200) {
				wx.showModal({
					title: '提示',
					content: '服务器或操作错误，请重试',
					showCancel: false
				})
			} else {
				console.log(url + "->res：");
				console.log(res);
				callBack(res.data);
			}
		},
		error: function (res) {
			console.log(url + '接口调用失败');
		}
	})
}

module.exports = {
	httpGet: httpGet,
	httpPost: httpPost,
  formatTime: formatTime
}
