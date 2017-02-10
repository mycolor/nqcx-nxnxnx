/*
 * Copyright 2017 nqcx.org All right reserved. This software is the confidential and proprietary information
 * of nqcx.org ("Confidential Information"). You shall not disclose such Confidential Information and shall use
 * it only in accordance with the terms of the license agreement you entered into with nqcx.org.
 */

package org.nqcx.nxnxnx.queue;

import org.nqcx.commons.lang.consts.LoggerConst;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

/**
 * 发送消息 mqSender.send(NxnxnxMqDestination.NXNXNX_QUEUE, "msg");
 *
 * @author naqichuan 17/2/10 13:29
 */
public class NxnxnxRecevier implements MessageListener {

    private final static Logger logger = LoggerFactory.getLogger(LoggerConst.LOGGER_MQ_NAME);

    @Override
    public void onMessage(Message message) {
        if (message == null)
            return;
        try {
            ObjectMessage om = (ObjectMessage) message;

            logger.info("OPERATE: ONMESSAGE, object: {}", om.getObject());

            String json = String.valueOf(om.getObject());
            logger.info(json);

        } catch (JMSException e) {
            logger.warn("处理失败", e.getMessage());
        }
    }
}
