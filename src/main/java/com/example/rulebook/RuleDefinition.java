package com.example.rulebook;

public class RuleDefinition {

    private String ruleId;

    private String ruleName;

    private String ruleCondition;

    public String getSelectedWebSeries() {
        return selectedWebSeries;
    }

    public void setSelectedWebSeries(String selectedWebSeries) {
        this.selectedWebSeries = selectedWebSeries;
    }

    private String selectedWebSeries;



    public String getRuleId() {
        return ruleId;
    }

    public void setRuleId(String ruleId) {
        this.ruleId = ruleId;
    }

    public String getRuleName() {
        return ruleName;
    }

    public void setRuleName(String ruleName) {
        this.ruleName = ruleName;
    }

    public String getRuleCondition() {
        return ruleCondition;
    }

    public void setRuleCondition(String ruleCondition) {
        this.ruleCondition = ruleCondition;
    }


}
