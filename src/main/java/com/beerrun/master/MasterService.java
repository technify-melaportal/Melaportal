package com.beerrun.master;

import java.util.HashMap;

import javax.sql.DataSource;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 * Created by Subhash Lamba on 22-01-2017.
 */

public class MasterService {
    public static HashMap<String, DataSource> getDataSourceHashMap(String dbname) {
    
    	System.out.println("dbname---------"+dbname);
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/opcenter_ip");
//        dataSource.setUrl("jdbc:mysql://50.23.230.106:3306/opcenter");
//        dataSource.setUrl("jdbc:mysql://192.168.1.178:3306/paid_beerrun");
        dataSource.setUsername("reportopcenter");
        dataSource.setPassword("technify");

        DriverManagerDataSource dataSource1 = new DriverManagerDataSource();
        dataSource1.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource1.setUrl("jdbc:mysql://localhost:3306/"+dbname);
//        dataSource.setUrl("jdbc:mysql://50.23.230.106:3306/"+dbname);
       // dataSource1.setUrl("jdbc:mysql://192.168.1.178:3306/"+dbname);
        dataSource1.setUsername("reportopcenter");
        dataSource1.setPassword("technify");

        HashMap hashMap = new HashMap();
        hashMap.put("tenantId1", dataSource);
        hashMap.put("tenantId2", dataSource1);
      
        return hashMap;
    }
}
