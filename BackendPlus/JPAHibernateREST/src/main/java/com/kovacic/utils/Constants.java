package com.kovacic.utils;

public interface Constants {
	final String SEARCH = "/search/{q}";

	// users //
	final String GET_USER_BY_ID = "/getUser/{userId}";
	final String GET_ALL_USERS = "/getAllUsers";
	final String SAVE_USER = "/saveUser";
	final String UPDATE_USER = "/updateUser/{userId}";
	final String DELETE_USER = "/deleteUser";


	// skills //
	final String GET_SKILL_BY_ID = "/getSkill/{userId}";
	final String GET_ALL_SKILLS = "/getAllSkills";
	final String SAVE_SkILL = "/saveSkill";
	final String UPDATE_SKILL = "/updateSkill/{skillId}";
	final String DELETE_SKILL = "/deleteSkill";
    final String GET_SKILL_BY_NAME = "/getSkill/{name}";
}
