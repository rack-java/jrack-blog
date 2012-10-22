package com.zzzhc.blog.controllers;

import com.zzzhc.routing.annotation.Resources;
import com.zzzhc.web.BaseController;

@Resources
public class CommentsController extends BaseController {

	public void index() {
		view.renderText("hahaha");
	}
	
}
