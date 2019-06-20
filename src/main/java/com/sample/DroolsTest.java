package com.sample;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

import org.junit.Test;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.QueryResults;
import org.kie.api.runtime.rule.QueryResultsRow;

import com.sample.model.Audit;
import com.sample.model.Reservation;
import com.sample.model.ReservationResults;
import com.sample.model.RuleType;
import com.sample.model.TCIDGroups;
import com.sample.model.TravelAgent;


/**
 * This is a sample class to launch a rule.
 */
public class DroolsTest {
	
    public static final void main(String[] args) {
        try {
            // load up the knowledge base
	        KieServices ks = KieServices.Factory.get();
    	    KieContainer kContainer = ks.getKieClasspathContainer();
        	KieSession kSession = kContainer.newKieSession("ksession-rules");

        	Reservation reservation = new Reservation();
        	reservation.setRoomType("1");

            kSession.insert(reservation);
            
            int count = kSession.fireAllRules();
            kSession.dispose();
            
            System.out.println("kSession.fireAllRules(): " + count);
            
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }
}
