app = new com.zzzhc.blog.BlogApplication()
app.initialize()

static_file = new com.zzzhc.rack.Static("public")
static_file.addUrl("/css");
builder.use(static_file)

builder.run(app)