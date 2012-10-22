<!DOCTYPE html>
<html class="no-js">
	<head>
  		<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <title></title>
  </head>
  <body>
	title: ${env.get("post").title}<br>
		<form method="POST" enctype="multipart/form-data" action="/posts">
			name: <input name="user[][name]"><br>
			<input name="file" type="file"><br>
			<input type="submit" value="submit">
		</form>
	</body>
</html>