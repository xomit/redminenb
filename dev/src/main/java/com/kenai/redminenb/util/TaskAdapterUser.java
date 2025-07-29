package com.kenai.redminenb.util;

import com.kenai.redminenb.issue.RedmineIssue;
import com.taskadapter.redmineapi.bean.User;

/**
 * Helper class for task adapter related user beans.
 *
 * @author Timo Schmidt <timo@xomit.de>
 */
public class TaskAdapterUser {

	public static User fromIssue(final RedmineIssue issue) {
		return new User(issue.getRepository().getManager().getTransport()).setId(issue.getIssue().getAssigneeId());
	}

	private TaskAdapterUser() {
		// NOPE
	}
}
