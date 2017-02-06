## 通过Packet Capture抓包暴走日报获取api

>暴走日报一直是我非常喜欢的一个应用，然而我却对其进行了抓包然后抓出了其中的api，完全出自技术学习，希望不要有什么不好的结果。

### 以下为抓取的api列表

### 1.获取各个栏位list url ###

	http://dailyapi.ibaozou.com/api/v31/tags/index

返回结果（json）：

	{
		"data": [
		{
		"name": "首页",
		"url": "http://dailyapi.ibaozou.com/api/v31/documents/latest"
		},
		{
		"name": "用户投稿",
		"url": "http://dailyapi.ibaozou.com/api/v31/documents/contributes/latest"
		},
		{
		"name": "视频",
		"url": "http://dailyapi.ibaozou.com/api/v31/documents/videos/latest"
		}
		],
		"version": 5
	}

### 2.获取各个栏位的list###
**首页**	
>http://dailyapi.ibaozou.com/api/v31/documents/latest

**用户投稿**	
>http://dailyapi.ibaozou.com/api/v31/documents/contributes/latest

**视频**	
>http://dailyapi.ibaozou.com/api/v31/documents/videos/latest

内容获取就不再赘述了

	