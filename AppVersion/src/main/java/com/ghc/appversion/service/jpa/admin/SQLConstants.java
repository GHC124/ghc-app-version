package com.ghc.appversion.service.jpa.admin;

public interface SQLConstants {
	String ORDER_BY = ":orderBy";
	String SORT = ":sort";
	String LIMIT = "limit";
	String OFFSET = "offset";
	
	String USER_SUMMARY_QUERY = "SELECT distinct USER_ID, EMAIL, GROUP_CONCAT(GROUP_NAME) as GROUPNAMES FROM view_user_summary WHERE 1 group by USER_ID ORDER BY :orderBy :sort LIMIT :limit OFFSET :offset";
}
