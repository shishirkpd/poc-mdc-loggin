package com.poc.mdc;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;

import static java.util.concurrent.TimeUnit.MINUTES;

@RestController
public class TransferController {
    ExecutorService executor = new MdcAwareThreadPoolExecutor(3, 3, 0, MINUTES,
            new LinkedBlockingQueue<>(), Thread::new, new ThreadPoolExecutor.AbortPolicy());

    @PostMapping("/transfer")
    public void transfer(@RequestBody Transfer transfer) {
        Runnable task = new Slf4jRunnable(transfer);
        executor.submit(task);
    }
}
