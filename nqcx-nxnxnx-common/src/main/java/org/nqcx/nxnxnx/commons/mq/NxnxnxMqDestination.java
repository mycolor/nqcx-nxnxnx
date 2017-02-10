/*
 * Copyright 2017 nqcx.org All right reserved. This software is the confidential and proprietary information
 * of nqcx.org ("Confidential Information"). You shall not disclose such Confidential Information and shall use
 * it only in accordance with the terms of the license agreement you entered into with nqcx.org.
 */

package org.nqcx.nxnxnx.commons.mq;


import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.nqcx.commons.mq.MqDestination;

import javax.jms.Destination;

/**
 * @author naqichuan 16/10/19 11:07
 */
public enum NxnxnxMqDestination implements MqDestination {

    NXNXNX_TOPIC(new ActiveMQTopic("NXNXNX_TOPIC")), //
    NXNXNX_QUEUE(new ActiveMQQueue("NXNXNX_QUEUE"));

    private Destination destination;

    NxnxnxMqDestination(Destination destination) {
        this.destination = destination;
    }

    @Override
    public Destination getDestination() {
        return this.destination;
    }
}
