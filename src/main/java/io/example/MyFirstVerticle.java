package io.example;

import io.vertx.core.AbstractVerticle;

public class MyFirstVerticle extends AbstractVerticle{

    @Override
    public void start() throws Exception {
        vertx.createHttpServer().requestHandler(req -> {
            req.response()
                    .putHeader("content-type","text/plain")
                    .end("hello world!!");}).listen(8080);
    }
}
