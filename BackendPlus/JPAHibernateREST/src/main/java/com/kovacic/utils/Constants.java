package com.kovacic.utils;

public interface Constants {
	final String SEARCH = "/search/{q}";


	// logins //
	String SET_LOGGED = "/setLogged";
	String GET_ALL_LOGINS = "/getAllSystemLogins";
	String GET_LOGIN_BY_ID = "/getLogin{id}";
	String UPDATE_LOGIN = "/updateLogin{id}";
	String SAVE_LOGIN = "/saveLogin";

	// users //
	final String GET_USER_BY_ID = "/getUser/{id}";
	final String GET_ALL_USERS = "/getAllUsers";
	final String SAVE_USER = "/saveUser";
	final String UPDATE_USER = "/updateUser/{id}";
	final String DELETE_USER = "/deleteUser";


	// user-profiles //
	final String GET_USER_PROFILE_BY_ID = "/getUserProfile/{id}";
	final String GET_ALL_USER_PROFILES = "/getUserProfiles";
	final String SAVE_USER_PROFILE = "/saveUserProfile";
	final String UPDATE_USER_PROFILE = "/updateUserProfile/{id}";
	final String DELETE_USER_PROFILE = "/deleteUserProfile";

	// skills //
	final String GET_SKILL_BY_ID = "/getSkill/{id}";
	final String GET_ALL_SKILLS = "/getAllSkills";
	final String SAVE_SkILL = "/saveSkill";
	final String UPDATE_SKILL = "/updateSkill/{id}";
	final String DELETE_SKILL = "/deleteSkill";
    final String GET_SKILL_BY_NAME = "/getSkill/{name}";



}
