package com.kenai.redminenb.util;

import com.kenai.redminenb.issue.RedmineIssue;
import com.taskadapter.redmineapi.bean.IssueCategory;

/**
 * Helper class for task adapter related issue category beans.
 *
 * @author Timo Schmidt <timo@xomit.de>
 */
public class TaskAdapterIssueCategory {

	public static IssueCategory fromIssue(final RedmineIssue issue, final int projectId, final String categoryName) {
		return new IssueCategory(issue.getRepository().getManager().getTransport(), projectId, categoryName);
	}

	private TaskAdapterIssueCategory() {
		// NOPE
	}
}
