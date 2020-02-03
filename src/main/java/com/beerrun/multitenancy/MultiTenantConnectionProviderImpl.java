package com.beerrun.multitenancy;

import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;

import org.hibernate.service.jdbc.connections.spi.AbstractDataSourceBasedMultiTenantConnectionProviderImpl;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import com.beerrun.master.MasterService;
/**
 * Created by Subhash Lamba on 22-01-2017.
 */

public class MultiTenantConnectionProviderImpl extends AbstractDataSourceBasedMultiTenantConnectionProviderImpl {
	String dbname ="";
    @Override
    protected DataSource selectAnyDataSource() {
    	System.out.println("selectAnyDataSource");
        return MasterService.getDataSourceHashMap("opcenter").get("tenantId1");
    }

    @Override
    public DataSource selectDataSource(String tenantIdentifier) {
    	RequestAttributes request = RequestContextHolder.getRequestAttributes();
    	 dbname = (String) request.getAttribute("dbname",
                 RequestAttributes.SCOPE_SESSION);
    	System.out.println("tenantIdentifier========"+tenantIdentifier);
    	System.out.println("dbname========"+dbname);
    	
        return MasterService.getDataSourceHashMap(dbname).get(tenantIdentifier);
    	
    }

}
