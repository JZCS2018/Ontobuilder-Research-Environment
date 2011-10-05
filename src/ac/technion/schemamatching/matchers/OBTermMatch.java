/**
 * 
 */
package ac.technion.schemamatching.matchers;

import java.util.HashMap;

import ac.technion.iem.ontobuilder.core.ontology.Ontology;
import ac.technion.iem.ontobuilder.matching.algorithms.line2.misc.MatchingAlgorithmsNamesEnum;
import ac.technion.iem.ontobuilder.matching.match.MatchInformation;
import ac.technion.iem.ontobuilder.matching.utils.AlgorithmXMLEditor;
import ac.technion.iem.ontobuilder.matching.wrapper.OntoBuilderWrapper;
import ac.technion.iem.ontobuilder.matching.wrapper.OntoBuilderWrapperException;
import ac.technion.schemamatching.experiments.OBExperimentRunner;

/**
 * Wrapper for default configurated Ontobuilder Term Match
 * @author Tomer Sagi
 *
 */
public class OBTermMatch implements FirstLineMatcher {
	/* (non-Javadoc)
	 * @see ac.technion.schemamatching.matchers.FirstLineMatcher#getName()
	 */
	private double weightMaxSubString = 0.4;
	private double weightNGram = 0.4;
	private double weightJaroWinkler = 0.2;
	private double stringNameWeight = 0.25;
	private double wordNameWeight = 0.25;
	private double stringLabelWeight = 0.25;
	private double wordLabelWeight = 0.25;
	
	/**
	 * Parameterized constructor, edits algorithm.xml file and sets the relevant parameters
	 * with nGram weight, jaroWinklerWeight and maxSubStringWeight (1- nGramWeight - jaroWinklerWeight)
	 *  
	 * @param nGramWeight
	 */
	public OBTermMatch(double nGramWeight, double jaroWinklerWeight, double wordNameWeight,double stringNameWeight ,double stringLabelWeight, double wordLabelWeight)
	{
		weightMaxSubString = 1-nGramWeight- jaroWinklerWeight;
		weightNGram = nGramWeight;
		weightJaroWinkler = jaroWinklerWeight;
		this.wordLabelWeight = wordLabelWeight;
		this.stringLabelWeight = stringLabelWeight;
		this.wordNameWeight = wordNameWeight;
		this.stringNameWeight = stringNameWeight;
		HashMap<String,Double> parameterValues = new HashMap<String,Double>(); 
		parameterValues.put("nGramWeight", weightNGram);
		parameterValues.put("maxCommonSubStringWeight", weightMaxSubString);
		parameterValues.put("jaroWinklerWeight",weightJaroWinkler);
		parameterValues.put("wordLabelWeight",wordLabelWeight);
		parameterValues.put("stringLabelWeight",stringLabelWeight);
		parameterValues.put("wordNameWeight",wordNameWeight);
		parameterValues.put("stringNameWeight",stringNameWeight);
		try {
			AlgorithmXMLEditor.updateAlgorithmParams("Term Match",parameterValues);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public OBTermMatch() {}

	public String getName() {
		return "Ontobuilder Term Match";
	}

	/* (non-Javadoc)
	 * @see ac.technion.schemamatching.matchers.FirstLineMatcher#hasBinary()
	 */
	public boolean hasBinary() {
		return false;
	}

	/* (non-Javadoc)
	 * @see ac.technion.schemamatching.matchers.FirstLineMatcher#match(com.modica.ontology.Ontology, com.modica.ontology.Ontology, boolean)
	 */
	public MatchInformation match(Ontology candidate, Ontology target, boolean binary) {
		OntoBuilderWrapper obw = OBExperimentRunner.getOER().getOBW();
		MatchInformation res = null;
		try {
			res = obw.matchOntologies(candidate, target, MatchingAlgorithmsNamesEnum.TERM.getName());
		} catch (OntoBuilderWrapperException e) {
			e.printStackTrace();
		}
		return res;
	}

	/* (non-Javadoc)
	 * @see ac.technion.schemamatching.matchers.FirstLineMatcher#getConfig()
	 */
	public String getConfig() { 
		String config = "NGram=" + Double.toString(weightNGram)
						+ ";MaxSubStr=" + Double.toString(weightMaxSubString)
						+ ";weightJaroWinkler=" + Double.toString(weightJaroWinkler)
						+ ";wordLabelWeight=" + Double.toString(wordLabelWeight)
						+ ";stringLabelWeight=" + Double.toString(stringLabelWeight)
						+ ";wordNameWeight=" + Double.toString(wordNameWeight)
						+ ";stringNameWeight=" + Double.toString(stringNameWeight)
						+ ";weightJaroWinkler=" + Double.toString(weightJaroWinkler);
		return config;
	}

	/* (non-Javadoc)
	 * @see ac.technion.schemamatching.matchers.FirstLineMatcher#getType()
	 */
	public MatcherType getType() {
		return MatcherType.SYNTACTIC;
	}

	/* (non-Javadoc)
	 * @see ac.technion.schemamatching.matchers.FirstLineMatcher#getDBid()
	 */
	public int getDBid() {
		return 0;
	}

}
