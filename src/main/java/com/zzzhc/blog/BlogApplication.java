package com.zzzhc.blog;

import com.zzzhc.rack.Server;
import com.zzzhc.web.Application;

public class BlogApplication extends Application {

	public static void main(String[] args) throws Exception {
		Server rackup = new Server();
		rackup.parseOptions(args);
		rackup.start();
	}

}
