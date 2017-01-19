package com.eden.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.UUID;

public class NullCheck {

	public static void main(String[] args) {
		Map<String, String> map = new HashMap<String, String>();
		String str = "abcdefg";
		System.out.println(str.subSequence(1, 3));
		
		String uuid = UUID.randomUUID().toString();
		String uuidStr = uuid.substring(0,8)+uuid.substring(9,13)+uuid.substring(14,18)+uuid.substring(19,23)+uuid.substring(24);
		System.out.println(uuidStr);
		
		map.isEmpty();
		Set<Entry<String, String>> set = map.entrySet();
		List<String> list = new ArrayList<String>();
		list.isEmpty();
		System.out.println(set.size());
	}

}
