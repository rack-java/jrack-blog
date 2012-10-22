package com.zzzhc.blog;

import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.ibatis.datasource.unpooled.UnpooledDataSource;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

import com.zzzhc.blog.models.Post;
import com.zzzhc.blog.models.PostMapper;
import com.zzzhc.rack.multipart.UploadedFile;
import com.zzzhc.routing.annotation.Resources;
import com.zzzhc.web.BaseController;

@Resources(collection = { "upload" })
public class PostsController extends BaseController {

	public void index() {
		SqlSession session = openSession();
		try {
			PostMapper mapper = session.getMapper(PostMapper.class);
			List<Post> posts = mapper.getPosts();
			env.set("posts", posts);
		} finally {
			session.close();
		}
	}

	private SqlSession openSession() {
		DataSource dataSource = new UnpooledDataSource("com.mysql.jdbc.Driver",
				"jdbc:mysql://localhost/blog", "root", "");
		TransactionFactory transactionFactory = new JdbcTransactionFactory();
		Environment environment = new Environment("development",
				transactionFactory, dataSource);
		Configuration configuration = new Configuration(environment);
		configuration.addMapper(PostMapper.class);

		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder()
				.build(configuration);

		SqlSession session = sessionFactory.openSession();
		return session;
	}

	public void show() {
		SqlSession session = openSession();
		try {
			PostMapper mapper = session.getMapper(PostMapper.class);
			int id = Integer.parseInt((String) request.getParam("id"));
			Post post = mapper.getPost(id);
			env.set("post", post);
		} finally {
			session.close();
		}
	}

	public void create() {
		for (Map.Entry<String, Object> entry : request.getParams().entrySet()) {
			System.out.println("name=" + entry.getKey() + ", value="
					+ entry.getValue());
		}
		UploadedFile file = (UploadedFile) request.getParam("file");
		StringBuilder text = new StringBuilder("created<br>\n");
		text.append("hoho1234<br>\n");
		text.append(file.getOriginalFilename()).append("<br>\n");
		text.append(new String(file.getData()));
		view.renderText(text.toString());
	}

}
