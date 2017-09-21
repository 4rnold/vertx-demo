package io.example;

import io.vertx.core.Vertx;
import io.vertx.ext.unit.Async;
import io.vertx.ext.unit.TestContext;
import io.vertx.ext.unit.junit.VertxUnitRunner;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.junit.runner.RunWith;

/**
 * MyFirstVerticle Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>09/21/2017</pre>
 */
@RunWith(VertxUnitRunner.class)
public class MyFirstVerticleTest {

    private Vertx vertx;

    @Before
    public void before(TestContext testContext) throws Exception {
        vertx = Vertx.vertx();
        vertx.deployVerticle(MyFirstVerticle.class.getName(), testContext.asyncAssertSuccess());
    }

    @After
    public void after(TestContext testContext) throws Exception {
        vertx.close(testContext.asyncAssertSuccess());
    }

    /**
     * Method: start()
     */
    @Test
    public void testStart(TestContext testContext) throws Exception {
        Async async = testContext.async();
        vertx.createHttpClient().getNow(8080, "localhost", "/", response -> {
            response.handler(body -> {
                testContext.assertTrue(body.toString().contains("hello"));
                async.complete();
            });
        });
    }


} 
