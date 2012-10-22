<!DOCTYPE html>
<html class="no-js">
	<head>
  		<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <title></title>
  </head>
  <body>
<#list env.get("posts") as post>
<a href="/posts/${post.id}?id=${post.id}">${post.title}</a><br>
</#list>
  </body>
</html>