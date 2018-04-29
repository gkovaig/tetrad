package edu.cmu.tetrad.algcomparison.score;

import edu.cmu.tetrad.data.DataModel;
import edu.cmu.tetrad.data.DataType;
import edu.cmu.tetrad.data.DataUtils;
import edu.cmu.tetrad.search.DiscreteMixedScore;
import edu.cmu.tetrad.search.Score;
import edu.cmu.tetrad.util.Experimental;
import edu.cmu.tetrad.util.Parameters;

import java.util.ArrayList;
import java.util.List;

/**
 * Wrapper for Fisher Z test.
 *
 * @author jdramsey
 */
public class DiscreteMixedBicScore implements ScoreWrapper, Experimental {
    static final long serialVersionUID = 23L;

    @Override
    public Score getScore(DataModel dataSet, Parameters parameters) {
        final DiscreteMixedScore discreteMixedScore
                = new DiscreteMixedScore(DataUtils.getMixedDataSet(dataSet), parameters.getDouble("structurePrior"));
        discreteMixedScore.setNumCategoriesToDiscretize(parameters.getInt("numCategoriesToDiscretize"));
        return discreteMixedScore;
    }

    @Override
    public String getDescription() {
        return "Discrete Mixed BIC Score";
    }

    @Override
    public DataType getDataType() {
        return DataType.Mixed;
    }

    @Override
    public List<String> getParameters() {
        List<String> parameters = new ArrayList<>();
        parameters.add("structurePrior");
        return parameters;
    }
}
