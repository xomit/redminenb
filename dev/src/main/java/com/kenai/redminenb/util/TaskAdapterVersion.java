package com.kenai.redminenb.util;

import com.kenai.redminenb.issue.RedmineIssue;
import com.taskadapter.redmineapi.bean.Version;

/**
 * Helper class for task adapter related version beans.
 *
 * @author Timo Schmidt <timo@xomit.de>
 */
public class TaskAdapterVersion {

	public static Version fromIssue(final RedmineIssue issue, final int projectId, final String versionName) {
		return new Version(issue.getRepository().getManager().getTransport(), projectId, versionName);
	}

	private TaskAdapterVersion() {
		// NOPE
	}
}
