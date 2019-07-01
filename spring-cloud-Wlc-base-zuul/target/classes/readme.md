我们使用zuul做路由的时候可能会碰到上传文件的需求，上传小文件到是没事，但是如果大文件的话是无法上传呢，这儿呢就有一个办法来绕过SpringMVC的DispatchServlet。

例如我们上传文件的接口为http://localhost:8093/user/user/uploadFile 那么我们在上传的时候就可以访问http://localhost:8093/zuul/user/user/uploadFile来实现上传大文件