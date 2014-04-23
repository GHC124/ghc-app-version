package com.ghc.appversion.service.jpa.admin;

public interface SQLConstants {
	String ORDER_BY = ":orderBy";
	String SORT = ":sort";
	String LIMIT = "limit";
	String OFFSET = "offset";
	
	/**
	 * Select all users information(email, groups)
	 */
	String USER_SUMMARY_QUERY = "SELECT distinct USER_ID, EMAIL, GROUP_CONCAT(GROUP_NAME) as GROUPNAMES FROM view_user_summary " +
			"WHERE 1 group by USER_ID ORDER BY :orderBy :sort LIMIT :limit OFFSET :offset";
	
	String FILTER_GROUP = ":filterGroup";
	/**
	 * Select all users information(email, groups) 
	 * and filter by group
	 */
	String USER_SUMMARY_FILTER_GROUP_QUERY = "SELECT distinct USER_ID, EMAIL, GROUP_CONCAT(GROUP_NAME) as GROUPNAMES " +
			"FROM (select * from view_user_summary where GROUP_ID in ( :filterGroup )) as t " +
			"WHERE 1 group by USER_ID ORDER BY :orderBy :sort LIMIT :limit OFFSET :offset";
	
	String USER_ID = "userId";
	/**
	 * Select all groups and show groups that a user joined
	 */
	String GROUP_USER_CHECK_QUERY = "SELECT g.ID, g.NAME, (SELECT ID FROM user_group WHERE USER_ID = :userId AND GROUP_ID = g.ID LIMIT 1) " +
             "as USER_GROUP_ID FROM groups as g WHERE 1 ORDER BY :orderBy :sort LIMIT :limit OFFSET :offset";
}
