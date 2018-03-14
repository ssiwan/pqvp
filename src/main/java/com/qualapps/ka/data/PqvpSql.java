package com.qualapps.ka.data;

public class PqvpSql {

	public static final String addUser = "insert into user_profile ( " +
			"usr_profile_id, usr_name, usr_pwd, usr_role," +
			" change_date, change_type, change_user ) " +
			"values ( ?, ?, ?, ?, ?, ?, ?)";

	public static final String getUserByUsrName = "select usr_profile_id, usr_name, usr_pwd, usr_role from user_profile where usr_name = ?";

	public static final String getUser = "select usr_profile_id, usr_name, usr_pwd, usr_role from user_profile where usr_name = ? and usr_pwd = ?";
	
	public static final String getAllArticles = "select art_id, art_title, art_content, art_views, art_status, art_rating, change_date, change_type, change_user from ka";
	
	public static final String getAllArticlesByTitle = "select art_id, art_title, art_content, art_views, art_status, art_rating, change_date, change_type, change_user from ka where to_tsvector(art_title) @@ to_tsquery(?);";
	
	public static final String getAllArticlesByContent = "select art_id, art_title, art_content, art_views, art_status, art_rating, change_date, change_type, change_user " +
														"from ka where to_tsvector(art_content) @@ to_tsquery(?);";
	
	public static final String getArticlesByRating = "select art_id, art_title, art_content, art_views, art_status, art_rating, change_date, change_type, change_user from ka order by art_views, change_date desc limit 10";
	
	public static final String getArticleForId = "select art_id, art_title, art_content, art_views, art_status, art_rating, change_date, change_type, change_user from ka where art_id = ?";
	
	public static final String addArticle = "insert into ka ( " +
											"art_id, art_title, art_content, art_views, art_status, art_rating, change_date, change_type, change_user ) " +
											"values ( ?, ?, ?, ?, ?, ?, ?, ?, ? )";
	
	public static final String updateArticle = "update ka " +
												"set art_title=?, art_content=?, art_views=?, art_status=?, art_rating=?, change_date=?, change_type=?, change_user=? " +
												"where art_id = ?";
	
	public static final String deleteArticle = "delete from ka where art_id = ?";
	
	public static final String getAllArtifacts = "select artif_id, arti_loc, arti_type, change_date, change_type, change_user, arti_desc, article_art_id " +
												"from article_artifacts";

	
	public static final String getArtifactsForId = "select artif_id, arti_loc, arti_type, change_date, change_type, change_user, arti_desc, article_art_id " +
													"from article_artifacts where artif_id = ?";
	
	public static final String getArtifactsForArt = "select artif_id, arti_loc, arti_type, change_date, change_type, change_user, arti_desc, article_art_id " +
													"from article_artifacts where article_art_id = ?";
	
	public static final String addArtifact = "insert into article_artifacts ( " +
											 "artif_id, arti_loc, arti_type, change_date, change_type, change_user, arti_desc, article_art_id ) " +
											 "values ( ?, ?, ?, ?, ?, ?, ?, ? )";
	
	public static final String updateArtifact = "update article_artifacts " +
												"set arti_loc=?, arti_type=?, change_date=?, change_type=?, change_user=?, arti_desc=?, article_art_id=? " +
												"where artif_id = ?";
	
	public static final String deleteArtifact = "delete from article_artifacts where artif_id = ?";
	
	public static final String deleteArtifactForArt = "delete from article_artifacts where article_art_id = ?";
	
	public static final String getAllCategory = "select cat_id, cat_name, cat_descr, change_date, change_type, change_user from category";
	
	public static final String getCategoryForCatId = "select cat_id, cat_name, cat_descr, change_date, change_type, change_user	from category where cat_id = ?";
	
	public static final String addCategory = "insert into category (cat_id, cat_name, cat_descr, change_date, change_type, change_user) " +
											 "values ( ?, ?, ?, ?, ?, ? )";
	
	public static final String updateCategory = "update category set cat_name=?, cat_descr=?, change_date=?, change_type=?, change_user=? where cat_id=?";
	
	public static final String deleteCategory = "delete from category where cat_id=?";
	
	public static final String addCatArt = "insert into article_category ( article_art_id, category_cat_id ) values ( ?, ? )";
	
	public static final String deleteCatArtForArt = "delete article_category where article_art_id = ?";
	
	public static final String deleteCatForCat = "delete article_category where category_cat_id = ?";
	
	public static final String getArtCat = "select a.art_id, a.art_title, a.art_content, a.art_views, a.art_status, art_rating, a.change_date, a.change_type, a.change_user, b.category_cat_id " +
											"from ka a, article_category b where a.art_id = b.article_art_id and b.category_cat_id = ?";

	public static final String getCatArt = "select a.cat_id, a.cat_name, a.cat_descr, a.change_date, a.change_type, a.change_user, b.article_art_id " +
											"from category a, article_category b where a.cat_id = b.category_cat_id and b.article_art_id = ?";

}