/**
 * Copyright 2017 Pivotal Software, Inc.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.micrometer.boot2.samples.components;

import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Timer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
public class TimerTestController {

    private final MeterRegistry registry;
    Timer timer;

    public TimerTestController(MeterRegistry registry) {
        this.registry = registry;
        //必须设置，在application.yaml中设置的host-tag为wbg.example.com，必须设置host-tag的value，否则monitor-service不接收metrics
        this.registry.config().commonTags("wbg.example.com", "default-app-global");
       //必须设置，表示是业务metrics，在monitor-service中会将"app"加入到metrics名
        this.registry.config().commonTags("migu_source", "app");
        //创建timer,并且设置标签
        timer = Timer.builder("reqTimer")
                .tag("timek", "timev")
                //设置记录20% 50% 95% 99%请求的延时时间
                .publishPercentiles(0.2, 0.5, 0.95, 0.99)
                //设置记录延时在100ms以内、275ms以内、300ms以内、 500ms以内请求的个数
                .register(registry);
    }

    @GetMapping("/api/timer")
    public double timer() {
        /*long beginTime = System.currentTimeMillis();


        StopWatch clock = new StopWatch();
        clock.start();

        Random ra =new Random();
        try{
            long sleepTime = Math.abs(ra.nextInt()) % 100;
            sleep( Math.abs(sleepTime));
        }catch(Exception e){

        }

        clock.stop();
        long endTime = System.currentTimeMillis();*/


        long  time=1000L;

        timer.record(time, TimeUnit.MILLISECONDS);//timer记录了这个方法longTimer.start()的处理时间
        return time;
    }

}
