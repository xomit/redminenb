package com.kenai.redminenb.util;

import com.kenai.redminenb.issue.RedmineIssue;
import com.taskadapter.redmineapi.RedmineManager;
import com.taskadapter.redmineapi.bean.Project;

/**
 * Helper class for task adapter related project beans.
 *
 * @author Timo Schmidt <timo@xomit.de>
 */
public class TaskAdapterProject {

	public static Project fromIssue(final RedmineIssue issue) {
		return fromManager(issue.getRepository().getManager()).setId(issue.getIssue().getProjectId()).setName(issue.getIssue().getProjectName());
	}

	public static Project fromManager(final RedmineManager manger) {
		return new Project(manger.getTransport());
	}

	private TaskAdapterProject() {
		// NOPE
	}
}
