package com.sample.model.utilities;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.drools.core.definitions.rule.impl.RuleImpl;
import org.drools.core.rule.Pattern;
import org.drools.core.rule.RuleConditionElement;
import org.kie.api.definition.rule.Rule;

public class AuditHelper {

  private AuditHelper() {
  }

  public static String getRuleHash(Rule rule) {
    StringBuffer sb = new StringBuffer();
    RuleImpl internalRule = (RuleImpl) rule;
    String[] parts = rule.getId().split(" ");
    
    //System.out.println("PARTS: " + parts);
    
    if (parts.length >= 3) {
      sb.append(parts[2]);
    }
    else {
      sb.append(rule.getId());
    }
    for (RuleConditionElement child : internalRule.getLhs().getChildren()) {
      Pattern pattern = (Pattern) child;
      sb.append(pattern.getConstraints());
    }

    String ruleString = sb.toString();

    return ruleString;

//        try {
//            MessageDigest md = MessageDigest.getInstance("MD5");
//            md.update(ruleString.getBytes());
//            return new String(md.digest());
//        } catch (NoSuchAlgorithmException e) {
//            e.printStackTrace();
//            return ruleString;
//        }

  }

}
