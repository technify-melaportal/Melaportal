/**
 * 
 */
package com.beerrun.common;

/**
 * @author 
 *
 */
public interface BeerRunConstants {

	public  final static String AUTO_INVOICE = "sales/auto invoice/sales-auto-invoice";

	public static String[] ITEM_TYPES = { "ING", "POS", "PKG", "MISC" };

	public static String[] INVOICE_ITEM_TYPES = { "FG", "POS" ,"Credit", "Other Charge"};

	public static Integer STATUS = 1;

	public static String[] PRICE_GROUP_ITEM_TYPES = { "1", "2", "3", "4" };

	public static String KEG_DEPOSIT_ITEM_NAME = "Keg Deposit";
	
	public static String KEG_DEPOSIT_ITEM_TYPE = "3";
	
	public static String CREDIT_ITEM_TYPE = "4";
	
	public static String INGREDIENT_ITEM_TYPE = "ING";
	
	public static String PACKAGE_ITEM_TYPE = "PKG";
	
	public static String POS_ITEM_TYPE = "POS";
	
	public static String MISC_ITEM_TYPE = "MISC";	
	
	public static Integer[] POSTATUS = {1, 2};
	
	public static Integer[] SOSTATUS = {2, 3};
	
	public static Integer[] BLSTATUS = {1, 2};
		
}
