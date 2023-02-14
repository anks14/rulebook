package com.example.rulebook;

import com.deliveredtechnologies.rulebook.FactMap;
import com.deliveredtechnologies.rulebook.NameValueReferableMap;
import com.deliveredtechnologies.rulebook.Result;
import com.deliveredtechnologies.rulebook.model.RuleBook;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class TestController {

    @Autowired
    @Qualifier("rules")
    private ObjectFactory<RuleBook> ruleBookObjectFactory;

    @GetMapping("web")
    public String fetchWebSeriesName(@RequestParam String charName) throws Exception {

        NameValueReferableMap facts = new FactMap();
        RuleInput input = new RuleInput();
        WebSeriesCharacterDetails webSeriesCharacterDetails = new WebSeriesCharacterDetails();
        webSeriesCharacterDetails.setCharacterName(charName);
        input.setWebSeriesCharacterDetails(webSeriesCharacterDetails);
        facts.setValue("request", input);
        RuleBook ruleBook = ruleBookObjectFactory.getObject();
        ruleBook.run(facts);
        Optional<Result<RuleOutput>> optRuleOp = ruleBook.getResult();
        if (optRuleOp.isPresent()) {
            Optional<RuleOutput> optionalRuleOutput = Optional.ofNullable(optRuleOp.get().getValue());
            if (optionalRuleOutput.isPresent()) {
                RuleOutput ruleOutput = optionalRuleOutput.get();
                return ruleOutput.getWebSeriesName();
            }


        }


        return "No Match!!";

    }


}
