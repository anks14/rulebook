package com.example.rulebook;

import com.deliveredtechnologies.rulebook.NameValueReferableTypeConvertibleMap;
import com.deliveredtechnologies.rulebook.Result;
import com.deliveredtechnologies.rulebook.lang.RuleBuilder;
import com.deliveredtechnologies.rulebook.model.rulechain.cor.CoRRuleBook;
import org.mvel2.MVEL;
import org.mvel2.integration.VariableResolverFactory;
import org.mvel2.integration.impl.MapVariableResolverFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Rules extends CoRRuleBook<RuleOutput> {

    @Autowired
    private RuleService ruleService;

    @Override
    public void defineRules() {

        List<RuleDefinition> rules = ruleService.getRules();
        for (RuleDefinition ruleDefinition : rules) {
            addRule(RuleBuilder.create().withFactType(RuleInput.class)
                    .withResultType(RuleOutput.class)
                    .when((NameValueReferableTypeConvertibleMap<RuleInput> facts) -> {
                        Map<String, Object> context = new HashMap<>();
                        VariableResolverFactory functionFactory = new MapVariableResolverFactory(context);
                        context.put("headers", facts.getValue("request").getHeaders());
                        context.put("webSeriesCharacterDetails", facts.getValue("request").getWebSeriesCharacterDetails());
                        return MVEL.evalToBoolean(ruleDefinition.getRuleCondition(), functionFactory);

                    })
                    .then((NameValueReferableTypeConvertibleMap<RuleInput> facts, Result<RuleOutput> result) -> {
                        RuleOutput ruleOutput = new RuleOutput(ruleDefinition.getSelectedWebSeries());
                        result.setValue(ruleOutput);
                    })
                    .stop().build());
        }

    }
}

