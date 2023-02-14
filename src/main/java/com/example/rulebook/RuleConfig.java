package com.example.rulebook;

import com.deliveredtechnologies.rulebook.lang.RuleBookBuilder;
import com.deliveredtechnologies.rulebook.model.RuleBook;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class RuleConfig {

    @Bean(name ="rules")
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public RuleBook ruleBook () {
        RuleBook ruleBook = RuleBookBuilder.create(Rules.class).
                withResultType(RuleOutput.class).withDefaultResult(getDefaultResult()).build();
        return  ruleBook;

    }

private RuleOutput getDefaultResult() {
        return new RuleOutput("NoMatch");
}


}
