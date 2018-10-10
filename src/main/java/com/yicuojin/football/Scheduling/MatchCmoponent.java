package com.yicuojin.football.Scheduling;

import javax.annotation.Resource;

import com.yicuojin.football.service.IMatchService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;


@Controller
@EnableScheduling
public class MatchCmoponent {

    private Logger logger = Logger.getLogger(MatchCmoponent.class);

    @Autowired
    private IMatchService matchService;

    /**
     * Description: (定时器 每天凌晨)竞猜结算
     *
     */
	/*@Scheduled(cron = "0/10 * *  * * ? ")
	public void setment(){

		logger.info("调起定时任务，结算....");
		boolean b = matchService.Settlement1();
		System.out.println(b);

	}*/

    /**
     * Description: (定时器 每五分钟)竞猜是否结束
     */
    @Scheduled(cron = "0 0/5 *  * * ? ")
    public void matchStart() {

        logger.info("调起定时任务，比赛是否结束竞猜....");
        boolean b = matchService.matechResult();
        System.out.println(b);

    }

}
