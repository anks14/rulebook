package com.example.rulebook;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RuleService {

    public List<RuleDefinition> getRules() {
        List<RuleDefinition> rules = new ArrayList<>();

        // add rule 1
        RuleDefinition rule1 = new RuleDefinition();
        rule1.setRuleId("1");
        rule1.setRuleName("GOT");
        rule1.setSelectedWebSeries("GOT");
        rule1.setRuleCondition("import org.apache.commons.lang3.StringUtils; StringUtils.equalsIgnoreCase(webSeriesCharacterDetails.getCharacterName(),'JonSnow')");


        // add rule 2

        RuleDefinition rule2 = new RuleDefinition();
        rule2.setRuleId("2");
        rule2.setRuleName("BreakingBad");
        rule2.setRuleCondition("import org.apache.commons.lang3.StringUtils; StringUtils.equalsIgnoreCase(webSeriesCharacterDetails.getCharacterName(),'WalterWhite')");

        rule2.setSelectedWebSeries("BreakingBad");


        //add rule 3
        RuleDefinition rule3 = new RuleDefinition();
        rule3.setRuleId("3");
        rule3.setRuleName("Suits");
        rule3.setRuleCondition("import org.apache.commons.lang3.StringUtils; StringUtils.equalsIgnoreCase(webSeriesCharacterDetails.getCharacterName(),'HarveySpectre')");

        rule3.setSelectedWebSeries("Suits");

        rules.add(rule1);
        rules.add(rule2);
        rules.add(rule3);

        return rules;

    }


}

