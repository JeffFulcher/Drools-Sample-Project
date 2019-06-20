package com.sample.model;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class Audit {
	ConcurrentHashMap<RuleType, ArrayList<String>> event;

	public void setRuleID(RuleType ruleType, String rule) {
		ArrayList<String> ruleID = new ArrayList<String>();
		ruleID.add(rule);
		
		if(event.get(ruleType) != null) {
			//Replace or Add to exisiting key-value pair
			
			if(ruleType == RuleType.COMM) {
				//For COMM rules, replace key-value (Only take one rule)
				ArrayList<String> rules = new ArrayList<String>();
				rules.add(rule);
				event.put(ruleType, rules);
				
			} else if (ruleType != RuleType.COMM) {
				//For non-COMM rules, add to key-value (take as many rule)
				ArrayList<String> rules = new ArrayList<String>();
				rules = event.get(ruleType);
				rules.add(rule);
				event.put(ruleType, rules);
			}
		} else {
			//Create new key-value pair
			ArrayList<String> rules = new ArrayList<String>();
			rules.add(rule);
			event.put(ruleType, rules);
		}
	}

}
