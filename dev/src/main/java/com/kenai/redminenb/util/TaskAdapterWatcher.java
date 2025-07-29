package com.kenai.redminenb.util;

import com.kenai.redminenb.user.RedmineUser;
import com.taskadapter.redmineapi.bean.Watcher;

/**
 * Helper class for task adapter related watcher beans.
 *
 * @author Timo Schmidt <timo@xomit.de>
 */
public class TaskAdapterWatcher {

	public static Watcher fromUser(final RedmineUser user) {
		return new Watcher().setId(user.getId());
	}

	private TaskAdapterWatcher() {
		// NOPE
	}
}
