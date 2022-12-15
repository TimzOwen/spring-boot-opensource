package com.timzowen.ipldashboard.data;

import com.timzowen.ipldashboard.model.Match;
import org.slf4j.LoggerFactory;

import javax.batch.api.chunk.ItemProcessor;
import java.util.logging.Logger;

public class MatcherDataProcessor implements ItemProcessor<MatchInput,Match> {

    private static final Logger log = LoggerFactory.getLogger(PersonItemProcessor.class);

    @Override
    public Match processItem(final MatchInput matchInput) throws Exception {

        Match match = new Match();
        match.setId(matchInput.getId());
        match.setCity(matchInput.getCity());

        return match;
    }
}

