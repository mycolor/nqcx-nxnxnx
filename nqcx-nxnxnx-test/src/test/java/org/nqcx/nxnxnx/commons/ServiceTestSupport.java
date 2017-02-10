/* 
 * Copyright 2017 nqcx.org All right reserved. This software is the
 * confidential and proprietary information of nqcx.org ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with nqcx.org
 */

package org.nqcx.nxnxnx.commons;

import org.nqcx.commons.lang.o.DTO;
import org.nqcx.commons.service.ServiceInterface;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;

import java.util.List;

/**
 * @author naqichuan Apr 12, 2013
 */
//@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@TestExecutionListeners({TransactionalTestExecutionListener.class, DependencyInjectionTestExecutionListener.class})
//@Transactional
public abstract class ServiceTestSupport extends AutoInject {

    /**
     * 子类实现，用于提供Service实例
     *
     * @return
     */
    protected abstract ServiceInterface getService();

    // ========================================================================

    protected DTO getDTO() {
        return new DTO();
    }

    protected <T> T getAddObject() {
        return null;
    }

    protected <T> T getModifyObject() {
        return null;
    }

    protected long getDeleteOneId() {
        return 4;
    }

    protected long[] getDeleteMultipleIds() {
        return new long[]{5, 6};
    }

    protected long getId() {
        return 2;
    }

    // ========================================================================

    public <T> void add() throws Exception {
        T t = getAddObject();
        if (t != null)
            assertTrue(getService().add(t).isSuccess());

        System.out.println("add: " + t);
    }

    public <T> void modify() throws Exception {
        T t = getModifyObject();
        if (t != null)
            assertTrue(getService().modify(t).isSuccess());

        System.out.println("modify: " + t);
    }

    public void deleteOne() throws Exception {
        DTO dto = getService().deleteOne(getDeleteOneId());
        assertTrue(dto.isSuccess());
    }

    public void deleteMultiple() throws Exception {
        DTO dto = getService().deleteMultiple(getDeleteMultipleIds());
        assertTrue(dto.isSuccess());
    }

    public <T> void query() throws Exception {
        DTO dto = getDTO();
        getService().query(dto);
        List<T> list = dto.getList();
        System.out.println("query: " + list);
    }

    public <T> void getById() throws Exception {
        T t = getService().getById(getId());
        System.out.println("getById: " + t);
    }
}
