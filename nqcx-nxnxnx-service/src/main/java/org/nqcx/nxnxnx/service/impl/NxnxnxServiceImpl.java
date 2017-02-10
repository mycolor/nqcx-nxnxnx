/*
 * Copyright 2017 nqcx.org All right reserved. This software is the confidential and proprietary information
 * of nqcx.org ("Confidential Information"). You shall not disclose such Confidential Information and shall use
 * it only in accordance with the terms of the license agreement you entered into with nqcx.org.
 */

package org.nqcx.nxnxnx.service.impl;

import org.nqcx.commons.dao.DaoInterface;
import org.nqcx.commons.service.ServiceSupport;
import org.nqcx.nxnxnx.mapper.NxnxnxMapper;
import org.nqcx.nxnxnx.service.NxnxnxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author naqichuan 17/2/10 13:26
 */
@Service
public class NxnxnxServiceImpl extends ServiceSupport implements NxnxnxService {

    @Autowired
    private NxnxnxMapper nxnxnxMapper;

    @Override
    protected DaoInterface getDao() {
        return nxnxnxMapper;
    }
}
