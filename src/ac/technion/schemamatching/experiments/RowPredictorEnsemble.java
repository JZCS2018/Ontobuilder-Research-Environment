/**
 * 
 */
package ac.technion.schemamatching.experiments;

import java.util.ArrayList;
import java.util.Properties;

import ac.technion.schemamatching.statistics.Statistic;

/**
 * @author tomer_s
 *
 */
public class RowPredictorEnsemble implements MatchingExperiment {

	/* (non-Javadoc)
	 * @see ac.technion.schemamatching.experiments.MatchingExperiment#runExperiment(ac.technion.schemamatching.experiments.ExperimentSchemaPair)
	 */
	public ArrayList<Statistic> runExperiment(ExperimentSchemaPair esp) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see ac.technion.schemamatching.experiments.MatchingExperiment#init(ac.technion.schemamatching.experiments.OBExperimentRunner, java.util.Properties, java.util.ArrayList)
	 */
	public boolean init(OBExperimentRunner oer, Properties properties,
			ArrayList<OtherMatcher> om) {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see ac.technion.schemamatching.experiments.MatchingExperiment#getDescription()
	 */
	public String getDescription() {
		// TODO Auto-generated method stub
		return null;
	}

}