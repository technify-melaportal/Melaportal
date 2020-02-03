package com.beerrun.multitenancy;

import org.hibernate.context.spi.CurrentTenantIdentifierResolver;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

/**
 * Created by Subhash Lamba on 22-01-2017.
 */
public class CurrentTenantIdentifierResolverImpl implements CurrentTenantIdentifierResolver {

    @Override
    public String resolveCurrentTenantIdentifier() {
        /*ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        String tenantId="";
        if(Defs.tenanno.equalsIgnoreCase("")) {
        	tenantId= attr.getRequest().getParameter("tenantId");
        }else {
        	tenantId="tenantId2";
        }*/
        
    	 String tenantId="";
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        
       
        if (requestAttributes != null) {
             tenantId = (String) requestAttributes.getAttribute("tenantId",
                    RequestAttributes.SCOPE_REQUEST);
            System.out.println("identifier--------"+tenantId);
            if (tenantId == null) {
            	tenantId = (String) requestAttributes.getAttribute("tenantId",
                        RequestAttributes.SCOPE_SESSION);
            	  System.out.println("null--------"+tenantId);
                return tenantId;
            }
        }
        
       
        return tenantId;
    }

    @Override
    public boolean validateExistingCurrentSessions() {
        return true;
    }
}
